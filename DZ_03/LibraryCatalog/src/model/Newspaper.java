package model;

import model.Genre.GenreCollection;
import service.newspaper.NewspaperFullImpl;
import service.newspaper.NewspaperPrintable;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Newspaper extends Composition
{
    private String Release;
    private List<String> Headers;
    private NewspaperPrintable newspaperPrintable;

    public Newspaper(String title,
                     String release,
                     List<String> headers,
                     NewspaperPrintable newspaperPrintable){
        super(title);
        this.Release = release;
        this.Headers = headers;
        this.newspaperPrintable = newspaperPrintable;
    }

    public Newspaper(NewspaperPrintable newspaperPrintable){
        this.newspaperPrintable = newspaperPrintable;
        this.Headers =  new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Title: ");
        this.Title = scanner.nextLine();
        System.out.println("Release: ");
        this.Release = scanner.nextLine();

        String header;
        do {
            System.out.println("Enter header (0 - to exit): ");
            header = scanner.nextLine();
            if(!header.equals("0")){
                Headers.add(header);
            }
        }while (!header.equals("0"));
    }

    public String getRelease(){
        return Release;
    }

    public List<String> getHeaders(){
        return Headers;
    }

    public void setRelease(String release) {
        Release = release;
    }

    public void setHeaders(List<String> headers) {
        Headers = headers;
    }

    public void setNewspaperPrintable(NewspaperPrintable newspaperPrintable) {
        this.newspaperPrintable = newspaperPrintable;
    }

    @Override
    public void print(){ newspaperPrintable.printNewspaper(this);}
}
