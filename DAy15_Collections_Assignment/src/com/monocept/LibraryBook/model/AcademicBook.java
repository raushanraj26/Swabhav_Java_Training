package com.monocept.LibraryBook.model;

public class AcademicBook extends Book {
	private String subject;
	private int edition;
	
	public  AcademicBook(int id,String title,String author,String subject,int edition) {
		super(id,title,author);
		this.subject=subject;
		this.edition=edition;
		
	}
	@Override
	public String toString() {
	    return super.toString() + ", Subject: " + subject + ", Edition: " + edition;
	}

}
