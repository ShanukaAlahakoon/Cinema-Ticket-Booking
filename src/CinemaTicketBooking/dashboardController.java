/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package CinemaTicketBooking;

import de.jensd.fx.glyphs.fontawesome.FontAwesomeIcon;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

/**
 *
 * @author ASUS
 */
public class dashboardController implements Initializable {
    
    @FXML
    private TableColumn<?, ?> addMovie_Col_date;
    
    @FXML
    private TableColumn<?, ?> addMovie_Col_duration;
    
    @FXML
    private TableColumn<?, ?> addMovie_Col_genre;
    
    @FXML
    private TableColumn<?, ?> addMovie_Col_title;
    
    @FXML
    private TableView<?> addMovie_Table;
    
    @FXML
    private Button addMovie_clearBtn;
    
    @FXML
    private TextField addMovie_date;
    
    @FXML
    private Button addMovie_deleteBtn;
    
    @FXML
    private TextField addMovie_duration;
    
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
    private TableColumn<?, ?> editScreen_col_current;
    
    @FXML
    private TableColumn<?, ?> editScreen_col_duration;
    
    @FXML
    private TableColumn<?, ?> editScreen_col_genre;
    
    @FXML
    private TableColumn<?, ?> editScreen_col_title;
    
    @FXML
    private ComboBox<?> editScreen_combo;
    
    @FXML
    private Button editScreen_deletebtn;
    
    @FXML
    private ImageView editScreen_image;
    
    @FXML
    private TextField editScreen_search;
    
    @FXML
    private TableView<?> editScreen_table;
    
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
    private FontAwesomeIcon signout;
    
    public void close() {
        System.exit(0);
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
    
}
