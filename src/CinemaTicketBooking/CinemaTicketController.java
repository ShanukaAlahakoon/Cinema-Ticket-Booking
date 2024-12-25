package CinemaTicketBooking;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.sql.Connection;
import java.sql.Statement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class CinemaTicketController {

    @FXML
    private Button signin_close;

    @FXML
    private Hyperlink signin_createAccount;

    @FXML
    private AnchorPane signin_form;

    @FXML
    private Button signin_loginbtn;

    @FXML
    private Button signin_minus;

    @FXML
    private TextField signin_password;

    @FXML
    private TextField signin_userName;

    @FXML
    private Hyperlink signup_alreadyHave;

    @FXML
    private Button signup_btn;

    @FXML
    private Button signup_close;

    @FXML
    private TextField signup_email;

    @FXML
    private AnchorPane signup_form;

    @FXML
    private Button signup_minus;

    @FXML
    private TextField signup_password;

    @FXML
    private TextField signup_userName;

    //Tools for database
    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public boolean validEmail() {

        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9._]*@[a-zA-Z0-9._]+([.][a-zA-Z]+)+");

        Matcher match = pattern.matcher(signup_email.getText());
        Alert alert;

        if (match.find() && match.group().matches(signup_email.getText())) {

            return true;
        } else {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid email");
            alert.showAndWait();

            return false;
        }
    }

    public void signup() {
        String sql = "INSERT INTO admin (email,username,password) VALUES (?,?,?)";

        String sql1 = "SELECT username FROM admin";

        connect = database.connectdb();

        try {
            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signup_email.getText());
            prepare.setString(2, signup_userName.getText());
            prepare.setString(3, signup_password.getText());

            Alert alert;

            if (signup_email.getText().isEmpty() || signup_userName.getText().isEmpty() || signup_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (signup_password.getText().length() < 8) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Invalid Password");
                alert.showAndWait();
            } else {

                if (validEmail()) {

                    prepare = connect.prepareStatement(sql1);
                    result = prepare.executeQuery();

                    if (result.next()) {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText(signup_userName.getText() + "was already exist!");
                        alert.showAndWait();
                    } else {

                        prepare.execute();

                        alert = new Alert(AlertType.INFORMATION);
                        alert.setTitle("Impormation message");
                        alert.setHeaderText(null);
                        alert.setContentText("Successfully Create a new account");
                        alert.showAndWait();

                        //clear textfeilds
                        signup_email.setText("");
                        signup_userName.setText("");
                        signup_password.setText("");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void signin() {
        String sql = "SELECT * FROM admin WHERE username=? and password = ?";

        connect = database.connectdb();

        try {

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, signin_userName.getText());
            prepare.setString(2, signin_password.getText());

            result = prepare.executeQuery();

            Alert alert;

            //Check if the username ,password is empty..
            if (signin_userName.getText().isEmpty() || signin_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();

            } else {
                if (result.next()) {
                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Impormation message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    //To hide login form after login..
                    signin_loginbtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource("dashboard.fxml"));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong username or password");
                    alert.showAndWait();

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == signin_createAccount) {
            signin_form.setVisible(false);
            signup_form.setVisible(true);

        } else if (event.getSource() == signup_alreadyHave) {
            signin_form.setVisible(true);
            signup_form.setVisible(false);
        }

    }

    public void signIn_close() {
        System.exit(0);
    }

    public void signIn_minus() {
        Stage stage = (Stage) signin_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signUp_close() {
        System.exit(0);
    }

    public void signUp_minus() {
        Stage stage = (Stage) signup_form.getScene().getWindow();
        stage.setIconified(true);
    }

}
