import java.math.BigDecimal;

public class Book {
	private String title;
	private String author;
	private BigDecimal price;
	private int onStock;

	public Book(final String pTitle, final String pAuthor,
			final BigDecimal pPrice, final int pOnStock) {
		super();
		this.title = pTitle;
		this.author = pAuthor;
		this.price = pPrice;
		this.onStock = pOnStock;
	}

	public Book() {
	}

	public String getTitle() {
		return title;
	}

	public String getAuthor() {
		return author;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public int getOnStock() {
		return onStock;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public void setOnStock(int onStock) {
		this.onStock = onStock;
	}
}
