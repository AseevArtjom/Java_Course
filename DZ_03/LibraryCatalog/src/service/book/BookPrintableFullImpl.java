package service.book;

import model.Book;

public class BookPrintableFullImpl implements BookPrintable {
    @Override
    public void printBook(Book book) {
        System.out.println("___________Full print___________");
        System.out.println("Title: " + book.getTitle());
        System.out.println("Author: " + book.getAuthor());

        String Genre;
        if(book.getGenre() != null){
            Genre = "Genre: " + book.getGenre().getName();
        }
        else{
            Genre = "Genre: not stated";
        }
        System.out.println(Genre);
        System.out.println("________________________________");
    }
}
