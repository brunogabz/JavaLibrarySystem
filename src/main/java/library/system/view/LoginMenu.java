package library.system.view;
import java.util.Scanner;
import library.system.dao.UserDAO;
import library.system.dao.*;
import library.system.model.User;


public class LoginMenu {
    Scanner scanner = new Scanner(System.in);
    private int option = 0;

    public void startLoginMenu() {
        while (option != 3) {
            System.out.println("-----Library System-----");
            System.out.println("1- Login");
            System.out.println("2- Sign Up");
            System.out.println("3- Exit");
            System.out.print("Choose an option: ");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    doLogin();
                    break;
                case 2:
                    doSignUp();
                    break;
                case 3:
                    System.exit(0);
            }
        }
    }

    private void doLogin(){
        System.out.print("Email: ");
        String email = scanner.nextLine();
        System.out.print("Password: ");
        String password = scanner.nextLine();
        UserDAO dao = new UserDAO();
        User loggedUser = dao.login(email, password);
        if (loggedUser != null){
            System.out.println("Login succeeded! Welcome, " + loggedUser.getName());
            MainMenu mainMenu = new MainMenu();
            mainMenu.startMainMenu(loggedUser);
        } else
            System.err.println("Error: Invalid email or password!");
    }

    private void doSignUp() {
        System.out.print("Email: ");
        String email = scanner.nextLine();
        UserDAO dao = new UserDAO();
        while (dao.existentEmail(email)) {
            System.err.println("Error: There is already a user with this email!");
            System.out.println("Please enter another email: ");
            email = scanner.nextLine();
        }
        System.out.print("Password: ");
        String password = scanner.nextLine();
        System.out.print("Name: ");
        String name = scanner.nextLine();
        User newUser = new User(name, email, password);
        dao.registerUser(newUser);
        doLogin();
    }
}