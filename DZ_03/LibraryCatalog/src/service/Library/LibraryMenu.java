package service.Library;

import model.Almanac;
import model.Book;
import model.Composition;
import model.Genre.Genre;
import model.Genre.GenreCollection;
import model.Newspaper;
import service.almanac.AlmanacPrintableFullImpl;
import service.book.BookPrintable;
import service.book.BookPrintableFullImpl;
import service.newspaper.NewspaperFullImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LibraryMenu
{
    private List<Composition> Compositions = new ArrayList<>();

    public void addComposition(Composition composition)
    {
        Compositions.add(composition);
    }

    void print(List<Composition> compositions) {
        int i = 0;
        if(compositions.isEmpty()){
            System.out.println("Empty");
            return;
        }
        for (Composition composition : compositions) {
            System.out.println(i + ".");
            composition.print();
            i++;
        }
    }

    public void Menu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("0 - Books,1 - Newspapers,2 - Almanacs,3 - Genres");
            choice = scanner.nextInt();
        }while (choice < 0 || choice > 3);
        switch (choice){
            case 0:
                PrintBookMenu();
                break;
            case 1:
                PrintNewspaperMenu();
                break;
            case 2:
                PrintAlmanacMenu();
                break;
            case 3:
                PrintGenreMenu();
        }
    }

    public void PrintBookMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("0 - add,1 - delete,2 - show books");
            choice = scanner.nextInt();
        }while (choice < 0 || choice > 2);

        List<Composition> books = new ArrayList<>();
        for (Composition composition : Compositions){
            if(composition instanceof Book){
                books.add(composition);
            }
        }

        switch (choice){
            case 0:
                BookPrintableFullImpl bookPrintableFull = new BookPrintableFullImpl();
                Book newBook = new Book(bookPrintableFull);
                addComposition(newBook);
                Menu();
                break;
            case 1:
                int choice2 = -1;
                int i = 0;
                do {
                    print(books);
                    System.out.print("Choose book to deletion : ");
                    choice2 = scanner.nextInt();
                }while (choice2 < 0 || choice > books.size());
                Compositions.remove(books.get(choice2));
                Menu();
                break;
            case 2:
                print(books);
                Menu();
        }
    }

    public void PrintNewspaperMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("0 - add,1 - delete,2 - show newspapers");
            choice = scanner.nextInt();
        }while (choice < 0 || choice > 2);

        List<Composition> newspapers = new ArrayList<>();
        for (Composition composition : Compositions){
            if(composition instanceof Newspaper){
                newspapers.add(composition);
            }
        }

        switch (choice){
            case 0:
                NewspaperFullImpl newspaperFull = new NewspaperFullImpl();
                Newspaper newNewspaper = new Newspaper(newspaperFull);
                addComposition(newNewspaper);
                Menu();
                break;
            case 1:
                int choice2 = -1;
                int i = 0;
                do {
                    print(newspapers);
                    System.out.print("Choose newspaper to deletion : ");
                    choice2 = scanner.nextInt();
                }while (choice2 < 0 || choice > newspapers.size());
                Compositions.remove(newspapers.get(choice2));
                Menu();
                break;
            case 2:
                print(newspapers);
                Menu();
        }
    }

    public void PrintAlmanacMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("0 - add,1 - delete,2 - show almanacs");
            choice = scanner.nextInt();
        }while (choice < 0 || choice > 2);

        List<Composition> almanacs = new ArrayList<>();
        for (Composition composition : Compositions){
            if(composition instanceof Almanac){
                almanacs.add(composition);
            }
        }

        switch (choice){
            case 0:
                AlmanacPrintableFullImpl almanacPrintableFull = new AlmanacPrintableFullImpl();
                Almanac almanac = new Almanac(almanacPrintableFull);

                List<Composition> books = new ArrayList<>();
                for (Composition composition : Compositions){
                    if(composition instanceof Book){
                        books.add(composition);
                    }
                }

                List<Book> AlmanacBooks = new ArrayList<>();
                int BookChoice;
                do {
                    print(books);
                    System.out.println("Enter BookChoice (-1 - to exit): ");
                    BookChoice = scanner.nextInt();
                    if(!(BookChoice == -1)){
                        AlmanacBooks.add((Book)books.get(choice));
                        books.remove(books.get(choice));
                    }
                }while (!(BookChoice == -1));

                almanac.setBooks(AlmanacBooks);
                addComposition(almanac);
                Menu();
                break;
            case 1:
                int choice2 = -1;
                int i = 0;
                do {
                    print(almanacs);
                    System.out.print("Choose almanac to deletion : ");
                    choice2 = scanner.nextInt();
                }while (choice2 < 0 || choice > almanacs.size());
                Compositions.remove(almanacs.get(choice2));
                Menu();
                break;
            case 2:
                print(almanacs);
                Menu();
        }
    }
    public void PrintGenreMenu(){
        Scanner scanner = new Scanner(System.in);
        int choice = -1;
        do {
            System.out.println("0 - add,1 - delete,2 - show genres");
            choice = scanner.nextInt();
        }while (choice < 0 || choice > 2);

       var Genres = GenreCollection.getInstance().getGenres();

       switch (choice){
            case 0:
                scanner = new Scanner(System.in);
                System.out.print("Enter new genre: ");
                String genre_name = scanner.nextLine();
                Genre NewGenre = new Genre(genre_name);
                GenreCollection.getInstance().addGenre(NewGenre);
                Menu();
                break;
            case 1:
                for (int i = 0; i < Genres.size(); i++) {
                    System.out.println(i + "." + Genres.get(i).getName());
                }
                int genre_choice = -1;
                do {
                    System.out.print("Choose genre to deletion: ");
                    genre_choice = scanner.nextInt();
                }while (genre_choice < 0 || genre_choice > Genres.size());
                GenreCollection.getInstance().removeGenre(Genres.get(genre_choice));
                Menu();
                break;
            case 2:
                for (int i = 0; i < Genres.size(); i++) {
                    System.out.println(i + "." + Genres.get(i).getName());
                }
                Menu();
        }
    }
}
