/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CinemaTicketBooking;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author ASUS
 */
public class dashboardController implements Initializable {

    @FXML
    private TableColumn<movieData, String> addMovie_Col_date;

    @FXML
    private TableColumn<movieData, String> addMovie_Col_duration;

    @FXML
    private TableColumn<movieData, String> addMovie_Col_genre;

    @FXML
    private TableColumn<movieData, String> addMovie_Col_title;

    @FXML
    private TableView<movieData> addMovie_Table;

    @FXML
    private Button addMovie_clearBtn;

    @FXML
    private Button addMovie_deleteBtn;

    @FXML
    private TextField addMovie_duration;

    @FXML
    private AnchorPane addMovie;

    @FXML
    private AnchorPane addMovie_form;

    @FXML
    private TextField addMovie_genre;

    @FXML
    private ImageView addMovie_image;

    @FXML
    private Button addMovie_import;

    @FXML
    private Button addMovie_insertBtn;

    @FXML
    private TextField addMovie_search;

    @FXML
    private TextField addMovie_title;

    @FXML
    private Button addMovie_updateBtn;

    @FXML
    private Button addmovie_btn;

    @FXML
    private TableColumn<?, ?> availableMovie_Col_date;

    @FXML
    private TableColumn<?, ?> availableMovie_Col_genre;

    @FXML
    private TableColumn<?, ?> availableMovie_Col_title;

    @FXML
    private Spinner<?> availableMovie_Spclass;

    @FXML
    private Label availableMovie_Spclass_price;

    @FXML
    private TableView<?> availableMovie_Table;

    @FXML
    private Button availableMovie_btn;

    @FXML
    private Button availableMovie_buybtn;

    @FXML
    private Button availableMovie_clearbtn;

    @FXML
    private Label availableMovie_date;

    @FXML
    private AnchorPane availableMovie_form;

    @FXML
    private Label availableMovie_genre;

    @FXML
    private ImageView availableMovie_image;

    @FXML
    private Spinner<?> availableMovie_normalclass;

    @FXML
    private Label availableMovie_normalclass_price;

    @FXML
    private Button availableMovie_receiptbtn;

    @FXML
    private Button availableMovie_selectBtn;

    @FXML
    private Label availableMovie_title;

    @FXML
    private Label availableMovie_titleName;

    @FXML
    private Label availableMovie_total;

    @FXML
    private Button close;

    @FXML
    private Button customer_clearbtn;

    @FXML
    private TableColumn<?, ?> customer_col_date;

    @FXML
    private TableColumn<?, ?> customer_col_genre;

    @FXML
    private TableColumn<?, ?> customer_col_ticketNo;

    @FXML
    private TableColumn<?, ?> customer_col_time;

    @FXML
    private TableColumn<?, ?> customer_col_title;

    @FXML
    private Label customer_date;

    @FXML
    private Button customer_deletebtn;

    @FXML
    private AnchorPane customer_form;

    @FXML
    private Label customer_genre;

    @FXML
    private TextField customer_search;

    @FXML
    private TableView<?> customer_table;

    @FXML
    private Label customer_ticketNo;

    @FXML
    private Label customer_time;

    @FXML
    private Label customer_title;

    @FXML
    private Button customers_btn;

    @FXML
    private Label dashboard_AvailableMovies;

    @FXML
    private Label dashboard_TotalEarn;

    @FXML
    private Label dashboard_TotalSold;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private TableColumn<movieData, String> editScreen_col_current;

    @FXML
    private TableColumn<movieData, String> editScreen_col_duration;

    @FXML
    private TableColumn<movieData, String> editScreen_col_genre;

    @FXML
    private TableColumn<movieData, String> editScreen_col_title;

    @FXML
    private ComboBox<?> editScreen_combo;

    @FXML
    private Button editScreen_deletebtn;

    @FXML
    private ImageView editScreen_image;

    @FXML
    private TextField editScreen_search;

    @FXML
    private TableView<movieData> editScreen_table;

    @FXML
    private Label editScreen_title;

    @FXML
    private Button editScreen_updatebtn;

    @FXML
    private Button editScreening_btn;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private Button minus;

    @FXML
    private Button signout;

    @FXML
    private AnchorPane topForm;

    @FXML
    private Label dashBoardusername;

    @FXML
    private DatePicker addMovie_date;

    private Image image;

    private double x = 0;
    private double y = 0;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    
    
    private String[] currentList = {"showing","End showing"};
    
    public void comboBox(){
        
        List<String> listCurrent = new ArrayList<>();
        
        for(String data: currentList){
            
            listCurrent.add(data);
        }
        
             ObservableList listC = FXCollections.observableArrayList(listCurrent) ;
        editScreen_combo.setItems(listC);
        
        
    }
    
    
    
    
 public ObservableList<movieData> editScreeningList(){
     
     ObservableList<movieData> editSList = FXCollections.observableArrayList() ;
     
     String sql = "SELECT * FROM movie ";
     
     connect = database.connectdb();
     
     try{
         
         prepare = connect.prepareStatement(sql);
         result = prepare.executeQuery();
         
         movieData movD;
         
         while(result.next()){
             
             movD = new movieData(result.getInt("id"),
                  result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
             result.getString("current"));

             editSList.add(movD);
             
         }
         
         
         
     }catch(Exception e){
     e.printStackTrace();
     
 }
   return editSList;  
 }
 
 
   private ObservableList<movieData> editScreeningL;
public void showEditScreening(){
    
    editScreeningL = editScreeningList();
    
    editScreen_col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
    editScreen_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
    editScreen_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
    editScreen_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
    
    editScreen_table.setItems(editScreeningL);

    
    
}


 
    
    public void searchAddMovie() {

        FilteredList<movieData> filter = new FilteredList<>(listAddMovies, e -> true);

        addMovie_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMovieData -> {

                if (newValue.isEmpty() || newValue == null) {
                    return true;
                }

                String keySearch = newValue.toLowerCase();
                if (predicateMovieData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;

                } else if (predicateMovieData.getDate().toString().contains(keySearch)) {
                    return true;

                }

                return false;

            });

            SortedList<movieData> sortData = new SortedList<>(filter);
            sortData.comparatorProperty().bind(addMovie_Table.comparatorProperty());

            addMovie_Table.setItems(sortData);
        });

    }

    public void importImage() {

        FileChooser open = new FileChooser();
        open.setTitle("Open image file");
        open.getExtensionFilters().add(new ExtensionFilter("Image file", "*png", "*jpg"));

        Stage stage = (Stage) addMovie.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {
            image = new Image(file.toURI().toString(), 114, 150, false, true);
            addMovie_image.setImage(image);

            getData.path = file.getAbsolutePath();
        }

    }

    public void movieId() {

        String sql = "SELECT count(id) FROM movie";
        connect = database.connectdb();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {

                getData.movieId = result.getInt("count(id)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertAddMovie() {

        String sql1 = "SELECT * FROM movie WHERE movieTitle = '" + addMovie_title.getText() + "'";

        connect = database.connectdb();

        Alert alert;

        try {

            statement = connect.createStatement();
            result = statement.executeQuery(sql1);

            if (result.next()) {
                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovie_title.getText() + "was already exist");
                alert.showAndWait();

            } else {

                if (addMovie_title.getText().isEmpty()
                        || addMovie_genre.getText().isEmpty()
                        || addMovie_duration.getText().isEmpty()
                        || addMovie_image.getImage() == null
                        || addMovie_date.getValue() == null) {

                    alert = new Alert(Alert.AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all blank fields");
                    alert.showAndWait();

                } else {

                    String sql = "INSERT INTO movie (id,movieTitle,genre,duration,image,date) VALUES (?,?,?,?,?,?)";
                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    movieId();

                    String mID = String.valueOf(getData.movieId + 1);

                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, mID);
                    prepare.setString(2, addMovie_title.getText());
                    prepare.setString(3, addMovie_genre.getText());
                    prepare.setString(4, addMovie_duration.getText());
                    prepare.setString(5, uri);
                    prepare.setString(6, String.valueOf(addMovie_date.getValue()));

                    prepare.execute();

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully add new movie");
                    alert.showAndWait();

                    clearAddMovieList();
                    showAddMoviesList();
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAddMovie() {

        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE movie SET movieTitle = '" + addMovie_title.getText()
                + "',genre = '" + addMovie_genre.getText()
                + "',duration ='" + addMovie_duration.getText()
                + "',image = '" + uri
                + "',date = '" + addMovie_date.getValue()
                + "'WHERE id ='" + String.valueOf(getData.movieId) + "'";

        connect = database.connectdb();

        try {
            statement = connect.createStatement();

            Alert alert;

            if (addMovie_title.getText().isEmpty()
                    || addMovie_genre.getText().isEmpty()
                    || addMovie_duration.getText().isEmpty()
                    || addMovie_image.getImage() == null
                    || addMovie_date.getValue() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {

                statement.executeUpdate(sql);
                alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully updated");
                alert.showAndWait();

                showAddMoviesList();
                clearAddMovieList();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAddmovie() {

        String sql = "DELETE FROM movie WHERE movieTitle = '"
                + addMovie_title.getText() + "'";

        connect = database.connectdb();

        try {

            statement = connect.createStatement();
            Alert alert;

            if (addMovie_title.getText().isEmpty()
                    || addMovie_genre.getText().isEmpty()
                    || addMovie_duration.getText().isEmpty()
                    || addMovie_image.getImage() == null
                    || addMovie_date.getValue() == null) {

                alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {

                alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure?");

                Optional<ButtonType> option = alert.showAndWait();

                if (ButtonType.OK.equals(option.get())) {

                    statement.executeUpdate(sql);

                    alert = new Alert(Alert.AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Delete.");
                    alert.showAndWait();

                    showAddMoviesList();

                } else {
                    return;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAddMovieList() {

        addMovie_title.setText("");
        addMovie_genre.setText("");
        addMovie_duration.setText("");
        addMovie_image.setImage(null);
        addMovie_date.setValue(null);

    }

    public ObservableList<movieData> addMoviesList() {

        ObservableList<movieData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";
        connect = database.connectdb();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            movieData movD;

            while (result.next()) {
                movD = new movieData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                result.getString("current"));

                listData.add(movD);

            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;

    }

    public ObservableList<movieData> listAddMovies;

    public void showAddMoviesList() {
        listAddMovies = addMoviesList();

        addMovie_Col_title.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovie_Col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovie_Col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovie_Col_date.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovie_Table.setItems(listAddMovies);

    }

    public void selectAddMovieList() {

        movieData movD = addMovie_Table.getSelectionModel().getSelectedItem();
        int num = addMovie_Table.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        getData.movieId = movD.getId();

        addMovie_title.setText(movD.getTitle());
        addMovie_genre.setText(movD.getGenre());
        addMovie_duration.setText(movD.getDuration());

        String getDate = String.valueOf(movD.getDate());

        String uri = "file:" + movD.getImage();

        image = new Image(uri, 114, 150, false, true);

        addMovie_image.setImage(image);

        addMovie_date.setValue(movD.getDate().toLocalDate());

    }

    public void logout() {
        signout.getScene().getWindow().hide();

        try {
            Parent root = FXMLLoader.load(getClass().getResource("CinemaTicket.fxml"));

            Stage stage = new Stage();
            Scene scene = new Scene(root);

            root.setOnMousePressed((MouseEvent event) -> {
                x = event.getSceneX();
                y = event.getSceneY();

            });

            root.setOnMouseDragged((MouseEvent event) -> {
                stage.setX(event.getScreenX() - x);
                stage.setY(event.getScreenY() - y);

            });
            stage.initStyle(StageStyle.TRANSPARENT);

            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {
            dashboard_form.setVisible(true);
            addMovie_form.setVisible(false);
            availableMovie_form.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:#ae2d3c;");
            addmovie_btn.setStyle("-fx-background-color:transparent;");
            availableMovie_btn.setStyle("-fx-background-color:transparent;");
            editScreening_btn.setStyle("-fx-background-color:transparent;");
            customers_btn.setStyle("-fx-background-color:transparent;");

        } else if (event.getSource() == addmovie_btn) {
            dashboard_form.setVisible(false);
            addMovie_form.setVisible(true);
            availableMovie_form.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent;");
            addmovie_btn.setStyle("-fx-background-color:#ae2d3c;");
            availableMovie_btn.setStyle("-fx-background-color:transparent;");
            editScreening_btn.setStyle("-fx-background-color:transparent;");
            customers_btn.setStyle("-fx-background-color:transparent;");

        } else if (event.getSource() == availableMovie_btn) {
            dashboard_form.setVisible(false);
            addMovie_form.setVisible(false);
            availableMovie_form.setVisible(true);
            editScreening_form.setVisible(false);
            customer_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent;");
            addmovie_btn.setStyle("-fx-background-color:transparent;");
            availableMovie_btn.setStyle("-fx-background-color:#ae2d3c;");
            editScreening_btn.setStyle("-fx-background-color:transparent;");
            customers_btn.setStyle("-fx-background-color:transparent;");

        } else if (event.getSource() == editScreening_btn) {
            dashboard_form.setVisible(false);
            addMovie_form.setVisible(false);
            availableMovie_form.setVisible(false);
            editScreening_form.setVisible(true);
            customer_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent;");
            addmovie_btn.setStyle("-fx-background-color:transparent;");
            availableMovie_btn.setStyle("-fx-background-color:transparent;");
            editScreening_btn.setStyle("-fx-background-color:#ae2d3c;");
            customers_btn.setStyle("-fx-background-color:transparent;");

        } else if (event.getSource() == customers_btn) {
            dashboard_form.setVisible(false);
            addMovie_form.setVisible(false);
            availableMovie_form.setVisible(false);
            editScreening_form.setVisible(false);
            customer_form.setVisible(true);

            dashboard_btn.setStyle("-fx-background-color:transparent;");
            addmovie_btn.setStyle("-fx-background-color:transparent;");
            availableMovie_btn.setStyle("-fx-background-color:transparent;");
            editScreening_btn.setStyle("-fx-background-color:transparent;");
            customers_btn.setStyle("-fx-background-color:ae2d3c;");

        }

    }

    public void displayUsername() {

        dashBoardusername.setText(getData.username);

    }

    public void close() {
        System.exit(0);
    }

    public void minus() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        displayUsername();

        showAddMoviesList();
        
        showEditScreening();
        
        comboBox();

    }

}
