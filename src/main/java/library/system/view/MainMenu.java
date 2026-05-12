package library.system.view;
import library.system.dao.BookDAO;
import library.system.model.Book;
import library.system.model.User;

import java.util.Scanner;

public class MainMenu {
    Scanner scanner = new Scanner(System.in);

    private int option = 0;

    public void startMainMenu(User user) {
        while (option != 5) {
            System.out.println("-----Library System-----");
            System.out.println("1- Register Book");
            System.out.println("2- List All Books");
            System.out.println("3- Check Out Book");
            System.out.println("4- Return Book");
            System.out.println("5- Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option){
                case 1:
                    System.out.print("ISBN: ");
                    String isbn = scanner.nextLine();
                    BookDAO dao = new BookDAO();
                    if (dao.existentISBN(isbn)){
                        System.err.println("Error: A book with this ISBN already exists!");
                        break;
                    }
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Author: ");
                    String author = scanner.nextLine();
                    System.out.print("Publication Year: ");
                    int publicationYear = Integer.parseInt(scanner.nextLine());
                    Book newBook = new Book(title, author, isbn, publicationYear);
                    dao.registerBook(newBook);
                    break;
            }
        }
    }
}
