package JSon;

public class BookDTO {
	private String name;
	private String Writer;
	private int price;
	private String genre;
	private String publisher;
	
	public BookDTO(String name, String writer, int price, String genre, String publisher) {
		super();
		this.name = name;
		Writer = writer;
		this.price = price;
		this.genre = genre;
		this.publisher = publisher;
	}
	
	public BookDTO() {
		super();
	}

	public String getName() {
		return name;
	}
	public String getWriter() {
		return Writer;
	}
	public int getPrice() {
		return price;
	}
	public String getGenre() {
		return genre;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setWriter(String writer) {
		Writer = writer;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	
	@Override
	public String toString() {
		return "BookDTO [name=" + name + ", Writer=" + Writer + ", price=" + price + ", genre=" + genre + ", publisher="
				+ publisher + "]";
	}
}
