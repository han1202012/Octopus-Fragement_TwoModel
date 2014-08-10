package cn.org.octopus;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import cn.org.octopus.NewsTittleFragment.Callbacks;

public class MainActivity extends Activity implements Callbacks {

	private boolean isLand;		/* 标识是否是横屏 */
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* 加载布局文件, 这个布局文件中有一个 Fragment, 会自动加载该 Fragmet */
		setContentView(R.layout.activity_main);
		
		/* 查看加载的是哪个文件, 如果文件中包含 R.id.news_content_content 组件, 就说明现在是横屏的 */
		isLand = findViewById(R.id.news_content) != null;
	}

	/** 
	 * 实现的 Callbasks 接口的方法, 
	 * 当 NewsTittleFragement 中的 ListView 被点击的时候 回调 
	 * */
	@Override
	public void onNewsSelect(int id) {
		
		/* 如果是横屏的情况, 两个 Fragement 都在一个界面中  */
		if(isLand){
			/* 创建 Bundle 对象, Activity 传递给 Fragment 的参数需要靠该对象进行传递 */
			Bundle arguments = new Bundle();
			/* 封装数据到 Bundle 对象中, 注意提前定义好键值 */
			arguments.putInt(NewsContentFragement.TAG_NEWS_ID, id);
			/* 创建 Fragment 对象 */
			NewsContentFragement fragement = new NewsContentFragement();
			/* 将 Activity 要传递的数据 传递给 Fragment 对象 */
			fragement.setArguments(arguments);
			/* 获取FragmentManager 对象 */
			FragmentManager manager = getFragmentManager();
			/* 开启事务, 获取事务 */
			FragmentTransaction transaction =  manager.beginTransaction();
			/* 在事务中进行替换操作 */
			transaction.replace(R.id.news_content, fragement);
			/* 提交操作 */
			transaction.commit();
		}else{	/* 竖屏的情况, 需要开启 Activity */
			System.out.println("isLand : " + isLand);
			Intent intent = new Intent(getApplicationContext(), NewsContentActivity.class);
			/* 通过 Intent 的 Bundle 对象传递参数 */
			intent.putExtra(NewsContentFragement.TAG_NEWS_ID, id);
			startActivity(intent);
		}
		
	}

}
