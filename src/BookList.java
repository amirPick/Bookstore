import java.util.List;

public interface BookList {
	Book[] foundBooks(String searchString);

	boolean add(Book book, int amount);

	int[] buy(Book... books);

	List<Book> getAllBooksFromStock();
}
