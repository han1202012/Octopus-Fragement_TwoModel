package cn.org.octopus;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class NewsContentFragement extends Fragment {

	/* Bundle的key */
	public static final String TAG_NEWS_ID = "cn.org.octopus.news.tittle";
	
	private News news;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		/* 校验 参数中是否包含 TAG_NEWS_ID 键值*/
		boolean isIllegal = getArguments().containsKey(TAG_NEWS_ID);
		
		if(isIllegal){
			/* 如果包含 TAG_NEWS_ID 键值, 就会去键对应的 id */
			int id = getArguments().getInt(TAG_NEWS_ID);
			/* 从 NewsContent 单例对象中的 map 集合中获取 news 对象 */
			news = NewsContent.getInstance().news_map.get(id);
		}
	}
	
	@Override
	public void onSaveInstanceState(Bundle outState) {
		super.onSaveInstanceState(outState);
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		
		/* 加载布局文件 */
		View rootView = inflater.inflate(R.layout.fragment_news_content, container, false);
		/* 获取新闻标题组件 */
		TextView news_content_tittle = (TextView) rootView.findViewById(R.id.news_content_tittle);
		/* 获取新闻内容组件 */
		TextView news_content_content = (TextView) rootView.findViewById(R.id.news_content_content);
		if(null != news){
			/* 设置新闻标题 */
			news_content_tittle.setText(news.getTittle());
			/* 设置新闻内容 */
			news_content_content.setText(news.getContent());
		}
		
		return rootView;
	}
	
}
