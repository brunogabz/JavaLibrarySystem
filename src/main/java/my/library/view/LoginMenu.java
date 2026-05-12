package my.library.view;
import java.util.Scanner;
import my.library.dao.*;
import my.library.model.User;


public class LoginMenu {
    Scanner scanner = new Scanner(System.in);
    private int option = 0;

    public void startLogin() {
        while (option != 3) {
            System.out.println("-----Library System-----");
            System.out.println("1- Login");
            System.out.println("2- Sign Up");
            System.out.println("3- Exit");

            option = scanner.nextInt();
            scanner.nextLine();

            switch (option) {
                case 1:
                    doLogin();
                    break;
                case 2:
                    //doSignUp();
                    break;
                case 3:
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
        }
        System.err.println("Error: Invalid email or password!");
    }
}