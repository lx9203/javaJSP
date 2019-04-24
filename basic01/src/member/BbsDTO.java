package member;

public class BbsDTO {
	private int id;
	private String title;
	private int memberId;
	private String name;
	private String date;
	private String content;
	
	public BbsDTO() {}
	
	public BbsDTO(String title, String content) {
		super();
		this.title = title;
		this.content = content;
	}


	public BbsDTO(int memberId, String title, String content) {
		this.memberId = memberId;
		this.title = title;
		this.content = content;
	}
	
	public BbsDTO(int id, String title, String name, String content) {
		this.id = id;
		this.title = title;
		this.name = name;
		this.content = content;
	}
	
	public BbsDTO(int id, String title, int memberId, String name, String date, String content) {
		super();
		this.id = id;
		this.title = title;
		this.memberId = memberId;
		this.name = name;
		this.date = date;
		this.content = content;
	}

	public int getId() {
		return id;
	}
	
	public int getMemberId() {
		return memberId;
	}


	public void setMemberId(int memberId) {
		this.memberId = memberId;
	}


	public String getTitle() {
		return title;
	}
	public String getName() {
		return name;
	}
	public String getDate() {
		return date;
	}
	public String getContent() {
		return content;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public void setContent(String content) {
		this.content = content;
	}
	
	public String fullString() {
		return "BbsFull [id=" + id + ", title=" + title + ", name=" + name + 
		", date=" + date.substring(0, 16) + "\n         content=" + content + "]";
	}
	@Override
	public String toString() {
		return "BbsMember [id=" + id + ", title=" + title + ", name=" + name + ", date=" + date.substring(0, 16) + "\n content=" + content + "]";
	}
	
	public String doString() {
		return "BbsDTO [title=" + title + ", content=" + content + "]";
	}
	
	
}
