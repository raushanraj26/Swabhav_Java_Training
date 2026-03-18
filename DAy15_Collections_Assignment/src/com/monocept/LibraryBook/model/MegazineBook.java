package com.monocept.LibraryBook.model;

 
public class MegazineBook extends Book {
	//private  int issueNumber;
	private Month month;
//	private static int counter = 1; //give system generated unique nuber;
//	
	public  MegazineBook(int id,String title,String author,Month month) {
		super(id,title,author);
		this.month=month;
//		this.issueNumber = counter;
//		counter++;
	}
	@Override
	public String toString() {
	    return super.toString() + ", Month: " + month;
	}

}
