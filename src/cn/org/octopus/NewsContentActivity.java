package cn.org.octopus;

import android.app.Activity;
import android.os.Bundle;

public class NewsContentActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		/* 设置布局文件 */
		setContentView(R.layout.activity_news_content);
		
		/* 创建 Fragement */
		NewsContentFragement fragement = new NewsContentFragement();
		/* 创建绑定的数据 */
		Bundle bundle = new Bundle();
		/* 从Activity 获取 启动该 Activity 的 Intent */
		int id = getIntent().getIntExtra(NewsContentFragement.TAG_NEWS_ID, 0);
		bundle.putInt(NewsContentFragement.TAG_NEWS_ID, id);
		/* 设置数据给 Fragment */
		fragement.setArguments(bundle);
		/* 开启事务 操作 Fragement 并提交 */
		getFragmentManager().beginTransaction().add(R.id.news_content, fragement).commit();
	}
}
