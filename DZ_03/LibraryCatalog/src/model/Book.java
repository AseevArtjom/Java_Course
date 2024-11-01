package model;

import model.Genre.Genre;
import model.Genre.GenreCollection;
import service.book.BookPrintable;

import java.util.Scanner;

public class Book extends Composition{
    private String Author;
    private Genre Genre;
    private BookPrintable bookPrintable;

    public Book(String title,
                String author,
                Genre genre,
                BookPrintable bookPrintable){
        super(title);
        this.Author = author;
        this.Title = title;
        this.Genre = genre;
        this.bookPrintable = bookPrintable;
    }

    public Book(BookPrintable bookPrintable){
        this.bookPrintable = bookPrintable;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        this.Title = scanner.nextLine();
        System.out.println("Author: ");

        this.Author = scanner.nextLine();
        var genres = GenreCollection.getInstance().getGenres();
        int choice = -1;
        do {
            for (int i = 0; i < genres.size(); i++) {
                System.out.println(i + "." + genres.get(i).getName());
            }
            choice = scanner.nextInt();
        }while (choice < 0 || choice > genres.size());
        this.Genre = genres.get(choice);
    }

    public String getAuthor() {
        return Author;
    }
    public Genre getGenre() {
        return Genre;
    }


    public void setTitle(String title) {
        Title = title;
    }

    public void setGenre(Genre genre) {
        this.Genre = genre;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setBookPrintable(BookPrintable bookPrintable) {
        this.bookPrintable = bookPrintable;
    }

    @Override
    public void print() {
        bookPrintable.printBook(this);
    }
}
