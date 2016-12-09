package com.library.controller;

import java.io.*;
import java.text.*;
import java.util.*;

import javax.swing.JOptionPane;

<<<<<<< HEAD
public class Library {
	
	public static final int LIBRARY_OWNER_ID = 0;   
	private final String BookListURL = "./books.dat";
	private final String UserListURL = "./users.dat";
	private final long OverdueTimeLimit = 60*1000; 
	private final long NewbookTimeLimit = 60*1000; 
=======
/**
 * Library class, manage books and users
 * make all the member variables private
 * add copyBookImage() and addBook(book,srcBookImgPath,srcBookImgFilename) methods
 */
public class Library {
	
	public static final int LIBRARY_OWNER_ID = 0; // ownerId of the library is 0. i.e. not rented.  
	private final String BookListURL = "./books.dat";
	private final String UserListURL = "./users.dat";
	private final long OverdueTimeLimit = 60*1000; // in millisecond
	private final long NewbookTimeLimit = 60*1000; // in millisecond
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	private final int FINE_PER_SECOND = 1;
	private final String DEFAULT_BOOK_IMAGE_PATH =  "./images/";
	
	private ArrayList<Book> bookList;
	private ArrayList<User> userList;
	
	public Library(){ //constructor
		bookList = new ArrayList<Book>();
		userList = new ArrayList<User>();
	}
	
	
	void saveBooks() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(BookListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(bookList);

	}
	
	void saveUsers() throws IOException{
		
		FileOutputStream fout = new FileOutputStream(UserListURL);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject(userList);
		oos.close();
	}
	
	@SuppressWarnings("unchecked")
	void loadBooks() throws Exception{
		
		FileInputStream fis = new FileInputStream(BookListURL);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    bookList = (ArrayList<Book>)ois.readObject();
	    ois.close();
	    
	 
	}
	
	@SuppressWarnings("unchecked")
	void loadUsers() throws Exception{
		
		FileInputStream fis = new FileInputStream(UserListURL);
	    ObjectInputStream ois = new ObjectInputStream(fis);
	    userList = (ArrayList<User>)ois.readObject();
	    ois.close();
	}
	 
	
	
	boolean loginCheck(String userName, String password){
		Iterator<User> userItr = userList.iterator();
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			if(userName.equals(tempUser.getUserName()) && password.equals(tempUser.getPassword())){
				return true;
<<<<<<< HEAD
			}
		}
		return false;
		
	}
=======
			}//end if
		}//end while
		return false;
		
	}//login check  - old version
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	
	public User login(String userName, String password){
		
<<<<<<< HEAD
		User currentUser = null; 
=======
		User currentUser = null; //initialize
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		Iterator<User> userItr = userList.iterator();
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			if(tempUser.getUserName().equals(userName) && tempUser.getPassword().equals(password)){
				currentUser = tempUser;
				break;
<<<<<<< HEAD
			}
		}
=======
			}//if login successful
		}//while
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		return currentUser; //return null if login failed.
	}
	
	public String getBookImgFileFullName(String isbn){
		return DEFAULT_BOOK_IMAGE_PATH+isbn + ".jpg"; //Extension .jpg
	}
	
	/**
	 * Copy the book image file into the default Book Image folder.
	 * @param srcImgPath  original image file path e.g. D:/img1
	 * @param srcImgFileName original image filename,  e.g. abc.jpg
	 * @param newImgFilename new image filename, without extension,  e.g.  1234
	 * @return if success copy the file, return true; else return false;
	 * e.g. Will copy D:/img1/abc.jpg into DEFAULT_BOOK_IMG_PATH/1234.jpg. 
	 * @throws Exception
	 */
	public boolean copyBookImage(String srcImgPath, String srcImgFileName, String newImgFilename)
	{
		String srcPath = srcImgPath + srcImgFileName;
		FileInputStream fi;
		try {
			fi = new FileInputStream(srcPath);
		} catch (FileNotFoundException e) {
<<<<<<< HEAD
			
=======
			//e.printStackTrace();
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
			return false;
		}
		BufferedInputStream in = new BufferedInputStream(fi);
		newImgFilename = srcImgFileName.replaceAll(srcImgFileName,
				newImgFilename) + ".jpg";
		File destDir = new File(DEFAULT_BOOK_IMAGE_PATH);
		if (!destDir.exists()) {
			destDir.mkdir();
		}
		String destPath = destDir.toString() + "\\" + newImgFilename;
		FileOutputStream fo;
		try {
			fo = new FileOutputStream(destPath);

			BufferedOutputStream out = new BufferedOutputStream(fo);
			byte[] buf = new byte[1024];
			int len = in.read(buf);
			while (len != -1) {
				out.write(buf, 0, len);
				len = in.read(buf);
			}
			out.close();
			fo.close();
			in.close();
			fi.close();
			return true;
			
		} catch (Exception e) {
			return false;
		}
	}
	
	public void addBook(Book b){
		b.setAddedDate(new Date());
		bookList.add(b);
		
	}//add book
	
	/**
	 * add a book into library, and also copy its image file into the default book image folder.
	 * @param b Book
	 * @param srcBookImgPath original book image file path e.g. D:/img1
	 * @param srcBookImgFileName original image filename,  e.g. abc.jpg
	 */
	void addBook(Book b, String srcBookImgPath, String srcBookImgFileName){
		b.setAddedDate(new Date());
		copyBookImage(srcBookImgPath,srcBookImgFileName,b.getIsbn());
		bookList.add(b);
	}//add book
	
	public void updateBook(String isbn, Book b){
		Iterator<Book> bookItr = bookList.iterator();
		int index = -1;
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			index++;
			if(tempBook.getIsbn().equals(isbn)){
				bookList.set(index, b);
				break;
<<<<<<< HEAD
			}
		}
	}
=======
			}//end if
		}//end while
	}//update book
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	public boolean deleteBook(String isbn){
		Iterator<Book> bookItr = bookList.iterator();
		int index = -1;
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			index++;
			if(tempBook.getIsbn().equals(isbn)){
				if(tempBook.isRented()==true){
					return false;
				}
				else{
					bookList.remove(index);
					return true;
				}
<<<<<<< HEAD
			}
			
		}
		return false;
	}
=======
			}//end if
			
		}//end while
		return false;
	}//delete book
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	public boolean addUser(User user){
		return userList.add(user);
	}
	
	boolean updateUser(int userId, User user){
		if(user == null){
			return false;
		}
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
				userList.set(index, user);
				return true;
<<<<<<< HEAD
			}
		}
		
		return false;
	}
=======
			}//end if
		}//end while
		
		return false;
	}//update user
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	boolean deleteUser(int userId){
		
		Iterator<User> userItr = userList.iterator();
		int index = -1;
		while(userItr.hasNext()){
			User tempUser = userItr.next();
			index++;
			if(tempUser.getUserId()==userId){
<<<<<<< HEAD
			
=======
				//******************************
				//users who hold rented books can not be deleted.
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
				Iterator<Book> bookItr = bookList.iterator();
				while(bookItr.hasNext()){
					if(bookItr.next().getOwnerId() == userId)
						return false;
<<<<<<< HEAD
				}
			
				userList.remove(index);
				return true;
			}
		}
		return false;
				
	}
=======
				}//end while
				//******************************
				userList.remove(index);
				return true;
			}//end if
		}//end while
		return false;
				
	}//delete user
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	

	ArrayList<User> showUserList(){
		
		return userList;
<<<<<<< HEAD
	}
=======
	}//show all user
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	public ArrayList<Book> showBookList_all(){
		
		return bookList;
<<<<<<< HEAD
	}
=======
	}//show all books
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
	public ArrayList<Book> showBookList_rented(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented() == true){
				tempBookList.add(tempBook);
			}//end if
		}//end while
		
		return tempBookList;
		
	}//
	
	public ArrayList<Book> showBookList_remainder(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented() != true){
				tempBookList.add(tempBook);
<<<<<<< HEAD
			}
		}
=======
			}//end if
		}//end while
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		
		return tempBookList;
	}
	
<<<<<<< HEAD
	public ArrayList<Book> showBookList_BorrowedByCustomer(int customerId){
=======
	ArrayList<Book> showBookList_BorrowedByCustomer(int customerId){
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
	
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getOwnerId()==customerId){
				tempBookList.add(tempBook);
				
<<<<<<< HEAD
			}
		}
=======
			}//end if
		}//end while
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		return tempBookList;	
	}
	
	
	public ArrayList<Book> showBookList_overdue(){
		
		Iterator<Book> bookItr = bookList.iterator();
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.isRented()==true){
				if(tempBook.getLastRented() == null)
					continue;
				if(new Date().getTime() - tempBook.getLastRented().getTime() >=  OverdueTimeLimit)
					tempBookList.add(tempBook);
					
				
				
			}//end if
		}//end while
		
		return tempBookList;
	}
	
	
	public boolean rentBook(int customerId, String isbn){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn) && tempBook.isRented()==false){
				tempBook.setLastRented(new Date());
				tempBook.setRented(true);
				tempBook.setOwnerId(customerId);
				return true;
			}//end if
		}//end while
		return false;
	}
	
<<<<<<< HEAD
	public void returnBook(String isbn){
=======
	void returnBook(String isbn){
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		

		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				tempBook.setRented(false);
				tempBook.setOwnerId(LIBRARY_OWNER_ID);
				
			}//end if
		}//end while

	}
	
	ArrayList<Book> showBookList_preferedCategory(Category[] ctgList){
		
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		Category currentCtg = null;
		for(int i =0;i<ctgList.length;i++){//for each category
			currentCtg = ctgList[i];
			Iterator<Book> bookItr = bookList.iterator();
			while(bookItr.hasNext()){
				Book tempBook = bookItr.next();
				if(tempBook.getCategory()==currentCtg){
					tempBookList.add(tempBook);
					
<<<<<<< HEAD
				}
			}
			
		}
=======
				}//end if
			}//end while
			
		}//end for
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		return tempBookList;
		
	}
	
	ArrayList<Book> showBookList_new(Category[] ctgList){
		
		Date currentDate = new Date(); 
		ArrayList<Book> tempBookList = new ArrayList<Book>();
		Category currentCtg = null;
<<<<<<< HEAD
		for(int i =0;i<ctgList.length;i++){
=======
		for(int i =0;i<ctgList.length;i++){//for each category
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
			currentCtg = ctgList[i];
			Iterator<Book> bookItr = bookList.iterator();
			while(bookItr.hasNext()){
				Book tempBook = bookItr.next();
				if(tempBook.getCategory()==currentCtg){
					
					if(currentDate.getTime() - tempBook.getAddedDate().getTime() < NewbookTimeLimit)
					tempBookList.add(tempBook);
					
<<<<<<< HEAD
				}
			}
			
		}
=======
				}//end if
			}//end while
			
		}//end for
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		return tempBookList;
		
	}
	
	public double fine(String isbn, Date returnDate){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
<<<<<<< HEAD
			
=======
				//this book found
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
				int overdue_time_seconds = (int)(returnDate.getTime() - tempBook.getLastRented().getTime() - OverdueTimeLimit )/1000;
				if (overdue_time_seconds<0)
					overdue_time_seconds=0;
				double fine_amount = overdue_time_seconds*FINE_PER_SECOND;
				return fine_amount;
<<<<<<< HEAD
			}
		}
=======
			}//end if
		}//end while
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		
		return 0.0;
	}
	
	public Book getBookByISBN(String isbn){
		
		Iterator<Book> bookItr = bookList.iterator();
		while(bookItr.hasNext()){
			Book tempBook = bookItr.next();
			if(tempBook.getIsbn().equals(isbn)){
				return tempBook;
<<<<<<< HEAD
			}
			
		}
=======
			}//end if
			
		}//end while
>>>>>>> 5777a24229b2da7e69cf2f5f2a25c29bb0dbbd49
		
		return new Book();
	}
	
		
}
