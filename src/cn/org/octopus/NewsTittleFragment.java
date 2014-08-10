package cn.org.octopus;

import android.app.Activity;
import android.app.ListFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;

/**
 * 内部类 : 
 * 		Callbacks接口
 * 	 	Fragement中维护该接口子类对象 
 * 		需要Activity实现该接口, 实现接口方法 
 * 		Activity 在onAttach()方法中传入; 
 * 
 * 方法简介 : 
 *		重写生命周期的 11 个方法;
 *		onAttach() 方法中, 传入所嵌入的Activity, 并判断是否嵌入正确
 *		onCreate() 方法中, 创建  Fragement 中 ListView 的适配器, 并将适配器设置给 ListView
 *		onDetach() 方法中, 将  Callbacks 接口子类对象置空
 *
 *		setChoiceMode() 设置ListView 的选择模式
 *		onListItemClick() ListView 的点击回调方法
 *	注意 Android 
 *		
 */
public class NewsTittleFragment extends ListFragment {

	private Callbacks activityCallback;			/* 从 onAttach()方法中传入的 Callbacks 接口子类, 由 Activity 强制转换而来 */
	
	/** 定义回调接口  
	 * 	接口用法 : 
	 * 	1. 该 Fragement 所 Activity 实现该接口
	 * 	2. 该 Fragement 中 维护一个 该接口子类, 即 Activity
	 * 	3. 调用 Activity 接口子类的方法, 将数据传递给 Activity **/
	public interface Callbacks{
		public void onNewsSelect(int id);
	}
	
	
	/** Fragment 嵌入Activity */
	@Override
	public void onAttach(Activity activity) {
		super.onAttach(activity);
		System.out.println("onAttach");
		
		if ( ! ( activity instanceof Callbacks))
			System.out.println("Fragement in wrong Activity !");
		
		/* 为Activity中定义的Callbacks接口子类对象赋值 */
		activityCallback = (Callbacks) activity;
	}
	
	/** Fragement 创建
	 * 	进行设置适配器操作 */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		System.out.println("onCreate");
		
		/* 为 ListFragment 创建适配器
		 * 注意使用的是 Android 自带的布局, 在 sdk\platforms\android-10\data\res\layout 目录下
		 *  */
		ListAdapter adapter = new ArrayAdapter<News>(getActivity(), android.R.layout.simple_list_item_activated_1, android.R.id.text1, NewsContent.getInstance().news);
		/* 设置适配器 给 ListFragement */
		setListAdapter(adapter);
	}
	
	/** Fragment 绘制 */
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		System.out.println("onCreateView");
		return super.onCreateView(inflater, container, savedInstanceState);
		
	}
	
	/** Activity 创建完毕 */
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		super.onActivityCreated(savedInstanceState);
		System.out.println("onActivityCreated");
	}
	
	/** Fragement 进入可视状态 */
	@Override
	public void onStart() {
		super.onStart();
		System.out.println("onStart");
	}
	
	/** Fragement 进入激活状态 */
	@Override
	public void onResume() {
		super.onResume();
		System.out.println("onResume");
	}
	
	/** Fragement 进入暂停状态 */
	@Override
	public void onPause() {
		super.onPause();
		System.out.println("onPause");
	}
	
	/** Fragement 进入停止状态 */
	@Override
	public void onStop() {
		super.onStop();
		System.out.println("onStop");
	}
	
	/** 销毁 Fragement 显示组件 */
	@Override
	public void onDestroyView() {
		super.onDestroyView();
		System.out.println("onDestroyView");
	}
	
	/** 销毁 Fragement */
	@Override
	public void onDestroy() {
		super.onDestroy();
		System.out.println("onDestroy");
	}
	
	/** 将 Fragement 从 Activity 中删除 */
	@Override
	public void onDetach() {
		super.onDetach();
		System.out.println("onDetach");
		activityCallback = null;
	}
	
	/**
	 * 列表对象被点击之后回调的方法
	 */
	@Override
	public void onListItemClick(ListView l, View v, int position, long id) {
		super.onListItemClick(l, v, position, id);
		activityCallback.onNewsSelect((int) id);
	}
	
	/** 设定选择模式, 该列表默认不能选择, 可以设置为不能选择, 单选 和 多选
	 * 	ListView.CHOICE_MODE_NONE		不能选择
	 * 	ListView.CHOICE_MODE_SINGLE		单选
	 * 	ListView.CHOICE_MODE_MULTIPLE	多选
	 *  */
	public void setChoiceMode(int choiceMode) {
		getListView().setChoiceMode(choiceMode);
	}
	
}
