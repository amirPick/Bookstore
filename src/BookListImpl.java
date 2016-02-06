import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookListImpl implements BookList {

	@Override
	public Book[] foundBooks(String searchString) {
		List<Book> booksFromStock = getAllBooksFromStock();
		Book[] books = (Book[]) booksFromStock.toArray((new Book[booksFromStock
				.size()]));

		int countFoundBooks = countFoundBooks(booksFromStock, searchString);

		Book[] foundBooks = new Book[countFoundBooks];

		for (Book book : books) {
			if (book.getAuthor().equals(searchString)
					|| book.getTitle().equals(searchString)) {
				for (int i = 0; i < foundBooks.length; i++) {
					foundBooks[i] = new Book();
					foundBooks[i].setTitle(book.getTitle());
					foundBooks[i].setAuthor(book.getAuthor());
					foundBooks[i].setPrice(book.getPrice());
					continue;
				}
			}

		}
		return foundBooks;
	}

	private int countFoundBooks(List<Book> booksFromStock, String searchString) {
		int countBooks = 0;
		for (Book book : booksFromStock) {
			if (book.getAuthor().equals(searchString)
					|| book.getTitle().equals(searchString)) {
				countBooks++;
			}
		}
		return countBooks;
	}

	@Override
	public boolean add(Book book, int amount) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int[] buy(Book... books) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Book> getAllBooksFromStock() {

		List<Book> books = new ArrayList<>();

		try {
			URL oracle = new URL(
					"http://www.contribe.se/bookstoredata/bookstoredata.txt");
			BufferedReader in = new BufferedReader(new InputStreamReader(
					oracle.openStream()));
			String bookDataStr;
			while ((bookDataStr = in.readLine()) != null) {
				Book book = readLineAsBook(bookDataStr);
				books.add(book);
			}
			in.close();
			return books;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return Collections.emptyList();
	}

	private Book readLineAsBook(String bookDataStr) {
		String[] fields = bookDataStr.split(";");

		Book book = new Book();
		book.setTitle(fields[0]);
		book.setAuthor(fields[1]);
		book.setPrice(convertFromStringToBigDecimal(fields[2]));
		book.setOnStock(Integer.parseInt(fields[3]));

		return book;
	}

	private BigDecimal convertFromStringToBigDecimal(String fields) {
		return new BigDecimal(fields.replaceAll(",", ""));
	}
}
