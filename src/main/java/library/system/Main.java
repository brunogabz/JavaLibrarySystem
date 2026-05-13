package library.system;
import library.system.connection.MakeConection;
import library.system.view.LoginMenu;
import library.system.connection.*;
import library.system.view.*;

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
        loginMenu.startLoginMenu();
        //MainMenu mainMenu = new MainMenu();
       // mainMenu.startMainMenu();
   }
}
