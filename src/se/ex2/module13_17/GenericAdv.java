package se.ex2.module13_17;

class Book<T>{
	T price;
	public static void show(Book<? extends Number> b){
		System.out.println("書籍定價為：" + b.price);
	}
}


public class GenericAdv {
	public static void main(String[] args){
		Book<Integer> book = new Book<Integer>();
		book.price = 580;
		Book.show(book);
	}
}
