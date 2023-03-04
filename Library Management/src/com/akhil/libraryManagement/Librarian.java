package com.akhil.libraryManagement;
import java.util.Scanner;
public class Librarian 
{
	public static void main(String[] args) 
	{
		Scanner scan = new Scanner(System.in);
		Library l = new Library();
		int choice;
		while(true)
		{
			System.out.println();
			System.out.println("Enter 1 to add book .");
			System.out.println("Enter 2 to search book by id ");
			System.out.println("Enter 3 to search book by title ");
			System.out.println("Enter 4 to remove book ");
			System.out.println("Enter 5 to get book details by id ");
			System.out.println("Enter 6 to exit ");
			System.out.println();
			choice = scan.nextInt();
			if(choice==1)
			{
				System.out.println("Enter Book Id : ");
				int bookId = scan.nextInt();
				System.out.println("Enter Book Title : ");
				String bookTitle = scan.next();
				System.out.println("Enter Author Name : ");
				String authorName = scan.next();
				System.out.println("Enter price : ");
				int price = scan.nextInt();
				System.out.println("Enter pages : ");
				int pages = scan.nextInt();
				l.addBook(bookId,bookTitle,authorName,price,pages);
			}
			else if(choice==2)
			{
				System.out.println("Enter Book Id : ");
				int bookId = scan.nextInt();
				l.searchBookById(bookId);
			}
			else if(choice==3)
			{
				System.out.println("Enter Book Title : ");
				String bookTitle = scan.next();
				l.searchBookByTitle(bookTitle);
			}
			else if(choice==4)
			{
				System.out.println("Enter Book Id : ");
				int bookId = scan.nextInt();
				l.removeBook(bookId);
			}
			else if(choice==5)
			{
				System.out.println("Enter Book Id : ");
				int bookId = scan.nextInt();
				l.getBookById(bookId);
			}
			else if(choice==6)
			{
				System.out.println();
				System.out.println("Thanks");
				break;
			}
			else
			{
				System.out.println();
				System.err.println("Please enter correct option ");
				System.out.println();
			}
		}
	}
}
