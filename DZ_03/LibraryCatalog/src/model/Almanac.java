package model;

import model.Genre.GenreCollection;
import service.almanac.AlmanacPrintable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Almanac extends Composition
{
    private List<Book> Books;
    private AlmanacPrintable almanacPrintable;

    public Almanac(String title,List<Book> books,AlmanacPrintable almanacPrintable){
        super(title);
        this.almanacPrintable = almanacPrintable;
        this.Books = books;
    }

    public Almanac(AlmanacPrintable almanacPrintable){
        this.almanacPrintable = almanacPrintable;
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        this.Title = scanner.nextLine();
        Books = new ArrayList<>();
    }

    public List<Book> getBooks() {
        return Books;
    }

    public void setBooks(List<Book> books) {
        Books = books;
    }

    public void setTitle(String title){
        this.Title = title;
    }

    public void setAlmanacPrintable(AlmanacPrintable almanacPrintable) { this.almanacPrintable = almanacPrintable; }
    @Override
    public void print() { almanacPrintable.printAlmanac(this); }
}
