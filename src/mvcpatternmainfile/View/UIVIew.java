package mvcpatternmainfile.View;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Mahir
 */
public class UIVIew {
        public String currentuser;
        public VBox left = new VBox(10);
        public Scene scene = new Scene(left, 300, 250);
        public Label usern = new Label("Username:");
        public TextField namef = new TextField();
        public Label userp = new Label("Password:");
        public PasswordField passf = new PasswordField();
        public Button signin = new Button("Sign In");
        public Label lwarning = new Label("Username and Password combination wrong please try again");
        public Label lsuccess = new Label("Success!");
        public VBox gpage = new VBox(10);
        public Scene mainpage = new Scene(gpage,300,300);
        public Button ngame = new Button("New Game");
        public Button lback = new Button("Go Back");
        public Label newuser = new Label("New here? Create an account:");
        public Button signup = new Button("Signup");
        public VBox supage = new VBox(10);
        public Scene signuppage = new Scene(supage,400,400);
        public Label luser = new Label("Enter your username");
        public TextField suser = new TextField();
        public Label lpass = new Label("Enter your pass, minimum 8 characters, and a capital letter and an integer");
        public PasswordField spass = new PasswordField();
        public Label confirmpass = new Label("Re-enter to confirm");
        public PasswordField spass2 = new PasswordField();
        public Button creatacc = new Button("Create your profile");
        public Label swarning1 = new Label("Password must be of 8 characaters, a capital letter and an integer, please try again");
        public Label swarning2 = new Label("Passwords don't match");
        public Label swarning3 = new Label("User already exists please use a new name");
        public Label swarning4 = new Label("Username cannot be empty");
        public Label ssuccess = new Label("Success!");
        public StackPane s= new StackPane();
        public Button back = new Button("Go back");
        public Button forgetpass = new Button("Forgot Password?");
        public VBox fpass = new VBox(10);
        public Scene fpscene = new Scene(fpass,300,300);
        public Label fpassu = new Label("Enter Username");
        public TextField fpassue = new TextField();
        public Label fpassp = new Label("Enter New Pass, minimum 8 characters, and a capital letter and an integer");
        public PasswordField fpasspe = new PasswordField();
        public Label fpasscp = new Label("Confirm New Pass");
        public PasswordField fpasscpe = new PasswordField();
        public Button confirm = new Button("Confirm");
        public Button goback= new Button("Go Back");
        public Label fwarning = new Label("User doesnot exist!");
        public Label fwarning1 = new Label("Password already exists, try again.");
        public Label fwarning2 = new Label("Password must have minimum 8 characters, and a capital letter and an integer");
        public Label fwarning3 = new Label("Paswords don't match please try again");
        public Label fsuccess = new Label("Success!");
        public StackPane s1=new StackPane();
        public StackPane s2 = new StackPane();
        public VBox pbox = new VBox(10);
        public Button rbutton = new Button("Exit");
        public Scene pscene = new Scene(pbox,300,300);
}
