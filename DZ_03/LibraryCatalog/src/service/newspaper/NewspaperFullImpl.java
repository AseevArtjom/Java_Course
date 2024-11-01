package service.newspaper;

import model.Newspaper;

public class NewspaperFullImpl implements NewspaperPrintable
{
    @Override
    public void printNewspaper(Newspaper newspaper) {
        System.out.println("___________Full print___________");
        System.out.println("Title: " + newspaper.getTitle());
        System.out.println("Release: " + newspaper.getRelease());
        var headers = newspaper.getHeaders();
        System.out.print("Headers: ");
        System.out.print("[");
        for (int i = 0; i < headers.size(); i++) {
            System.out.print(headers.get(i));
            if (i < headers.size() - 1) {
                System.out.print(", ");
            }
        }
        System.out.print("]\n");
        System.out.println("________________________________");
    }
}
