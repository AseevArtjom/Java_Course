package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Book {
    private String Title;
    private String Author;
    private Date Release;
    private String Publisher;
    private String Genre;
    private int PagesCount;

    public Book(){}

    public void Input(){
        Scanner scanner = new Scanner(System.in);

        System.out.print("Title : ");
        this.Title = scanner.nextLine();

        System.out.print("Author : ");
        this.Author = scanner.nextLine();

        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        formatter.setLenient(false);
        while (true) {
            System.out.print("Release (dd-MM-yyyy): ");
            String dateInput = scanner.nextLine();
            try {
                this.Release = formatter.parse(dateInput);
                break;
            } catch (ParseException e) {
                System.out.println("Wrong date format!");
            }
        }

        System.out.print("Publisher : ");
        this.Publisher = scanner.nextLine();

        System.out.print("Genre : ");
        this.Genre = scanner.nextLine();

        System.out.print("PagesCount : ");
        this.PagesCount = scanner.nextInt();
    }

    public void Print() {
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        String releaseDate = (Release != null) ? formatter.format(Release) : "N/A";

        System.out.print(
                "{"
                        + "Title - " + Title + ", "
                        + "Author - " + Author + ", "
                        + "Release - " + releaseDate + ", "
                        + "Publisher - " + Publisher + ", "
                        + "Genre - " + Genre + ", "
                        + "PagesCount - " + PagesCount
                + "}\n"
        );
    }

    public String getTitle() {
        return Title;
    }

    public String getAuthor() {
        return Author;
    }

    public Date getRelease() {
        return Release;
    }

    public int getPagesCount() {
        return PagesCount;
    }

    public String getGenre() {
        return Genre;
    }

    public String getPublisher() {
        return Publisher;
    }

    public void setAuthor(String author) {
        Author = author;
    }

    public void setGenre(String genre) {
        Genre = genre;
    }

    public void setPagesCount(int pagesCount) {
        PagesCount = pagesCount;
    }

    public void setPublisher(String publisher) {
        Publisher = publisher;
    }

    public void setRelease(Date release) {
        Release = release;
    }

    public void setTitle(String title) {
        Title = title;
    }
}
