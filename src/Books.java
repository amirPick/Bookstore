import java.util.ArrayList;

public class Books {

	private ArrayList<Book> listOfBooks = new ArrayList<Book>();

	public Books(ArrayList<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}

	public ArrayList<Book> getListOfBooks() {
		return listOfBooks;
	}

	public void setListOfBooks(ArrayList<Book> listOfBooks) {
		this.listOfBooks = listOfBooks;
	}
}
