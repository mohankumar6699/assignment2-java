package question4;

import java.util.*;
import static java.lang.System.out;

public class Main {


	public static void main(String[] args) {
		List<Book>books = new LinkedList<>();
		books.add(new Book("java",460)); //adding book "java" to list "books"
		books.add(new Book("php",764));    //adding book "php" to list "books"
		books.add(new Book("python",986));  //adding book "python" to list "books"
		BookApp bkapp = new BookApp();
		int totalPages = bkapp.calcTotalPages(books, 0);
		out.printf("Total number of books: %d\n", books.size()); //displays total number of books
		out.printf("Total pages: %d\n", totalPages); //displays total number of pages in all books



	}


}

class Book
{ 
	private String title;
	private int numOfPages;

	public Book( String title, int numOfPages ) {
		this.setTitle(title);
		this.setNumOfPages(numOfPages);
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}

	public int getNumOfPages() {
		return numOfPages;
	}

	public void setNumOfPages(int numOfPages) {
		this.numOfPages = numOfPages;
	}

}


//this will count total number of pages of all three books and returns value
class BookApp {
	public int calcTotalPages(List<Book> bookList, int accum) {
		if (bookList != null && bookList.size() > 0) {
			List<Book> subList = bookList.subList(1,bookList.size());
			return calcTotalPages(subList, accum + bookList.get(0).getNumOfPages() ); 
		}
		else
		{
			return accum;
		}
	}
}





