package ru.porochok.diplomproject;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import ru.porochok.diplomproject.POJO.EmploymentContract;
import ru.porochok.diplomproject.POJO.PersonTwoFeild;
import ru.porochok.diplomproject.contract.DbEmploymentContract;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class ContractLayoutController {

    @FXML
    private AnchorPane anchorPaneNewPerson;

    @FXML
    private ImageView btnAllExportWord;

    @FXML
    private ImageView btnClearTable;

    @FXML
    private Button btnDelete;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnSearchForNameDeportment;

    @FXML
    private Button btnSearchForNamePerson;

    @FXML
    private Button btnSortPlaceWork;

    @FXML
    private Button btnSortTermContract;
    @FXML
    private TextField textDelet;

    @FXML
    private TextField textSalary;

    @FXML
    private TextField textSearchForNameDeportment;

    @FXML
    private TextField textSearchForNamePerson;

    @FXML
    private TableColumn<EmploymentContract, LocalDate> col_date_create_contract;

    @FXML
    private TableColumn<EmploymentContract, LocalDate> col_date_done_contract;

    @FXML
    private TableColumn<EmploymentContract, String> col_deportment;

    @FXML
    private TableColumn<EmploymentContract, Integer> col_id;

    @FXML
    private TableColumn<EmploymentContract, String> col_mode_to_work;

    @FXML
    private TableColumn<EmploymentContract, String> col_person;

    @FXML
    private TableColumn<EmploymentContract, String> col_place_to_work;

    @FXML
    private TableColumn<EmploymentContract, Integer> col_salary;

    @FXML
    private TableColumn<EmploymentContract, String> col_tern_contract;

    @FXML
    private TableColumn<EmploymentContract, Integer> col_test_period;

    @FXML
    private ComboBox<String> comboBoxModeWork;

    @FXML
    private ComboBox<String> comboBoxNameAndIdPerson;

    @FXML
    private ComboBox<String> comboBoxNameDeportment;

    @FXML
    private ComboBox<String> comboBoxPlaceToWork;

    @FXML
    private ComboBox<String> comboBoxSortPlaceToWork;

    @FXML
    private ComboBox<String> comboBoxSortTermContract;

    @FXML
    private ComboBox<String> comboBoxTermContract;

    @FXML
    private ComboBox<String> comboBoxTestPeriod;

    @FXML
    private DatePicker dateCreateContract;

    @FXML
    private DatePicker dateDoneContract;

    @FXML
    private TableView<EmploymentContract> table_contract;

    private DbEmploymentContract dbEmploymentContract;
    private ObservableList<EmploymentContract> employmentContractObservableList;

    public void initialize() {
        dbEmploymentContract = new DbEmploymentContract();

        comboBoxNameAndIdPerson.setItems();

        col_id.setCellValueFactory(new PropertyValueFactory<>("idContract"));
        col_deportment.setCellValueFactory(new PropertyValueFactory<>("nameDeportment"));
        col_date_create_contract.setCellValueFactory(new PropertyValueFactory<>("dateCreateContract"));
        col_date_done_contract.setCellValueFactory(new PropertyValueFactory<>("dateDoneContract"));
        col_person.setCellValueFactory(new PropertyValueFactory<>("idAndNamePerson"));
        col_salary.setCellValueFactory(new PropertyValueFactory<>("salary"));
        col_test_period.setCellValueFactory(new PropertyValueFactory<>("testPeriod"));
        col_tern_contract.setCellValueFactory(new PropertyValueFactory<>("termOfTheContract"));
        col_place_to_work.setCellValueFactory(new PropertyValueFactory<>("placeToWork"));
        col_mode_to_work.setCellValueFactory(new PropertyValueFactory<>("modeToWork"));
        table_contract.setItems(DbEmploymentContract.getAllContracts());

        btnInsert.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

        });
    }
}
