package my.library;
import my.library.connection.*;
import my.library.view.*;

import java.sql.Connection;


public class Main {
    public static void main(String[] args) {
        try (Connection conexao = MakeConection.getConnection()) {
            if (conexao != null) {
                System.out.println("Successfully Connected!");
            }
        } catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }
        LoginMenu loginMenu = new LoginMenu();
        loginMenu.startLogin();
        //MainMenu mainMenu = new MainMenu();
       // mainMenu.startMainMenu();
   }
}
