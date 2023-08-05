package com.library;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Library {
	private int id;
	private String title;
	private String authorName;
	private Boolean isAvailable=true;
	

	public Library(int i, String string, String string2) {
		this.id=i;
		this.title=string;
		this.authorName=string2;
		this.isAvailable=true;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getTitle() {
		return title;
	}


	public void setTitle(String title) {
		this.title = title;
	}


	public String getAuthorName() {
		return authorName;
	}


	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}


	public Boolean getIsAvailable() {
		return isAvailable;
	}


	public void setIsAvailable(Boolean isAvailable) {
		this.isAvailable = isAvailable;
	}
	

	
}
class Book
{
		private List<Library> books;
		public Book()
		{
			this.books=new ArrayList<>();
		}
		public void addBook(Library book)
		{
			books.add(book);
		}
		public void displayBook()
		{
			System.out.println("Books:");
			System.out.println("\n1)ID\n2)Title\n3)Author Name\n4)Book Availability");
			for(Library book :books)
			{
				System.out.println(book.getId()+" "+book.getTitle()+" "+book.getAuthorName()+" "+
			    (book.getIsAvailable()? "Available" : "Not Available"));
			}
			System.out.print("\n");
		}
		public Library findBookById(int id)
		{
			for(Library book : books)
			{
				if(book.getId()==id)
				{
					return book;
				}
			}
			return null;
		}
		
}
class LibrarySystem
{
	public static void main(String[] args)
	{
		Book bk=new Book();
		bk.addBook(new Library(1, "Let Us C", "Yashvant Kanetkar"));
		bk.addBook(new Library(2, "Head First Java", "Kathy Sierra & Bert Bates"));
		bk.addBook(new Library(3, "The C++ Programming Language", "Bjarne Stroustrup"));
		Scanner sc=new Scanner(System.in);
		
		int choice;
		do {
			System.out.println("Library System");
			System.out.println("1. Display Books");
			System.out.println("2. Issue Books");
			System.out.println("3. Return Books");
			System.out.println("4. Exit");
			System.out.println("Enter Your Choice: ");
			choice=sc.nextInt();
			switch(choice)
			{
			case 1:
				bk.displayBook();
				break;
			case 2:
				System.out.println("Enter the book ID to issue book: ");
				int issueId=sc.nextInt();
				Library issueBook=bk.findBookById(issueId);
				if(issueBook !=null && issueBook.getIsAvailable())
				{
					issueBook.setIsAvailable(false);
					System.out.println("Book Issues Successfully.");
				}
				else
				{
					System.out.println("Book Not Available for Issuing.");
				}
				break;
			case 3:
				System.out.println("Enter the book ID to return: ");
				int returnId=sc.nextInt();
				Library returnBook=bk.findBookById(returnId);
				if(returnBook !=null && returnBook.getIsAvailable())
				{
					returnBook.setIsAvailable(true);
					System.out.println("Book Returned Successfully.");
				}
				else
				{
					System.out.println("Invalid book id or book already returned.");
				}
				break;
			case 4:
				System.out.println("Exit");
				break;
			default:
				System.out.println("Invalid Choice!!");
			}
			System.out.print("\n");
			
			
		}while(choice!=4);
		sc.close();
	}
}

