import java.util.List;

import org.junit.Before;
import org.junit.Test;

public class BookListImplTest {

	BookListImpl bookListImpl;

	@Before
	public void setUp() throws Exception {
		bookListImpl = new BookListImpl();
	}

	@Test
	public void testGetAllBooksFromStock() {
		List<Book> booksFromStock = bookListImpl.getAllBooksFromStock();
		for (Book book : booksFromStock) {
			System.out.print(book.getTitle() + ", adsdsada");
			System.out.print(book.getAuthor() + ", ");
			System.out.print(book.getPrice() + ", ");
			System.out.print(book.getOnStock());
			System.out.println();
		}
	}

	@Test
	public void testFoundBooksForTitleWithOneResult() {
		final String searchString = "How To Spend Money";

		Book[] books = bookListImpl.foundBooks(searchString);

		for (Book book : books) {
			System.out.println("Found book:");
			System.out.print("Title= " + book.getTitle() + ", Author="
					+ book.getAuthor() + ", Price=" + book.getPrice());
		}
	}

	@Test
	public void testFoundBooksForAuthorWithOneResult() {
		final String searchString = "First Author";

		Book[] books = bookListImpl.foundBooks(searchString);

		for (Book book : books) {
			System.out.println("Found book:");
			System.out.print("Title= " + book.getTitle() + ", Author="
					+ book.getAuthor() + ", Price=" + book.getPrice());
		}
	}

	@Test
	public void testFoundBooksWithMultipleBooks() {
		final String searchString = "Random Sales";

		Book[] books = bookListImpl.foundBooks(searchString);

		System.out.println("Found books:");

		for (Book book : books) {
			System.out.print("Title= " + book.getTitle() + ", Author="
					+ book.getAuthor() + ", Price=" + book.getPrice());
			System.out.println("");
		}
	}
}
