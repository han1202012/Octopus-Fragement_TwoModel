package cn.org.octopus;

public class News {

	private int id;			//新闻序号
	private String tittle;	//新闻标题
	private String content;	//新闻内容

	/** 构造方法  */
	public News(int id, String tittle, String content) {
		super();
		this.id = id;
		this.tittle = tittle;
		this.content = content;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTittle() {
		return tittle;
	}

	public void setTittle(String tittle) {
		this.tittle = tittle;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	/* 这里只返回标题, 是为了适配 ListFragement 时使用 */
	@Override
	public String toString() {
//		return "News [id=" + id + ", tittle=" + tittle + ", content=" + content
//				+ "]";
		return tittle;
	}
	
}
