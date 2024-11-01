package service.almanac;

import model.Almanac;
import model.Book;

public class AlmanacPrintableFullImpl implements AlmanacPrintable
{
    @Override
    public void printAlmanac(Almanac almanac) {
        System.out.println("___________Full print___________");
        System.out.println("Title: " + almanac.getTitle());
        System.out.print("Books: ");
        System.out.print("[");
        int i = 0;
        for(Book book : almanac.getBooks()){
            System.out.print(book.getTitle());
            if (i < almanac.getBooks().size() - 1) {
                System.out.print(",");
            }
            i++;
        }
        System.out.print("]\n");
        System.out.println("________________________________");
    }
}
