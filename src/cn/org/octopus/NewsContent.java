package cn.org.octopus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NewsContent {

	/* 单例模式
	 * 1. 私有 静态 本类成员变量
	 * 2. 私有 构造 函数
	 * 3. 公共 静态 函数, 检查本类成员变量是否为null, 返回本类成员变量 */
	
	private static NewsContent newsContent;
	
	public List<News> news;
	public Map<Integer, News> news_map;
	
	private NewsContent(){
		news = new ArrayList<News>();
		news_map = new HashMap<Integer, News>();
		
		News news1 = new News(0, "郭振玺敛财术", "7月30日，央视纪录频道CCTV-9总监刘文被带走。据相关报道，刘文被带走的原因是 “发现在纪录片对外采购上有财务问题”，另外，在一些高收视率的纪录片创作上，“涉嫌与隐性的植入广告有关的利益交换”。");
		News news2 = new News(1, "朝鲜新版5000朝元新钞无金日成头像", "韩国网刊《每日朝鲜》8月1日报道,已经开始流通的5000朝元新钞并未印金日成肖像,意味金日成肖像已从朝鲜货币上暂时消失。 旧版朝鲜5000元纸币上印有金日成头像。");
		News news3 = new News(2, "美国医生感染埃博拉", "菲律宾卫生部部长恩里克·奥尼亚说，目前菲律宾尚无埃博拉疫情。卫生部已通报地方卫生部门，一旦发现返菲海外劳工出现感染埃博拉病毒早期症状，立即对患者实行隔离治疗。卫生部还要求近期即将从海外回国的劳工如出现发烧、头痛、关节和肌肉疼痛、喉咙痛等症状，在回国前应获得所雇佣国家卫生部门的无感染证明，以避免埃博拉病毒传入菲律宾。");
				
		news.add(news1);
		news.add(news2);
		news.add(news3);
		
		news_map.put(news1.getId(), news1);
		news_map.put(news2.getId(), news2);
		news_map.put(news3.getId(), news3);
	}
	
	/**
	 * 判断成员变量 是否为null 
	 * 	如果不为null, 直接返回;
	 * 	如果为null, 先创建在返回;
	 */
	public static NewsContent getInstance() {
		
		if(newsContent != null)
			return newsContent;
		else
			return new NewsContent();
	}
	
}
