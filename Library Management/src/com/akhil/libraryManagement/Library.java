package com.akhil.libraryManagement;
import java.sql.*;
import java.util.*;
public class Library 
{
	public static String url="jdbc:mysql://localhost:3306?user=root&password=1234";
	public int bookId;
	public String bookTitle;
	public String authorName;
	public int price;
	public int pages;
	public void addBook(int bookId,String bookTitle,String authorName,int price,int pages)
	{
		this.bookId = bookId;
		this.authorName = authorName;
		this.bookTitle = bookTitle;
		this.price = price;
		this.pages = pages;
		try 
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement("Insert into library.book values(?,?,?,?,?)");
			stmt.setInt(1, bookId);
			stmt.setString(2, bookTitle);
			stmt.setString(3, authorName);
			stmt.setInt(4, price);
			stmt.setInt(5, pages);
			stmt.executeUpdate();
			System.out.println("Book added to the database. ");
			con.close();
		} catch (SQLException e) 
		{
			e.printStackTrace();
		}		
	}
	public void searchBookById(int bookId)
	{
		this.bookId = bookId;
		try 
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement("Select bookTitle from library.book where bookId = ?");
			stmt.setInt(1, bookId);
			ResultSet rs = stmt.executeQuery();
			System.out.println();
			if(rs.next())
			{
				System.out.println("The book title is "+ rs.getString(1));
			}
			else
			{
				System.out.println("Book Id doesnt exist. ");
			}
		}
		catch(SQLException e) 
		{
			e.printStackTrace();
		}
	}
	public void searchBookByTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
		try
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement("Select * from library.book where bookTitle = ?");
			stmt.setString(1, bookTitle);
			ResultSet rs = stmt.executeQuery();
			System.out.println();
			if(rs.next())
			{
				System.out.println("The book "+bookTitle+" is written by " + rs.getString(3));
			}
			else
			{
				System.out.println("Book doesnt exist. ");
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
	public void removeBook(int bookId)
	{
		this.bookId =bookId;
		try
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt= con.prepareStatement("Delete from library.book where bookId=?");
			stmt.setInt(1, bookId);
			stmt.executeUpdate();
			System.out.println("Book Deleted from database. ");
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}		
	}
	public void getBookById(int bookId)
	{
		this.bookId = bookId;
		try
		{
			Connection con = DriverManager.getConnection(url);
			PreparedStatement stmt = con.prepareStatement("select * from library.book where bookId=?");
			stmt.setInt(1, bookId);
			ResultSet rs = stmt.executeQuery();
			if(rs.next())
			{
				System.out.println();
				System.out.println("Book Id : " + rs.getInt(1));
				System.out.println("Book Title: " + rs.getString(2));
				System.out.println("Author Name: " + rs.getString(3));
				System.out.println("Price: " + rs.getInt(4));
				System.out.println("Page : " + rs.getInt(5));
			}
			else
			{
				System.out.println("BookId not found in database. ");
			}			
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}
//Akhil
