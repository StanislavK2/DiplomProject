package ru.porochok.diplomproject;

import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.porochok.diplomproject.POJO.Person;
import ru.porochok.diplomproject.POJO.Timesheet;

public class TimesheetLayoutController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnDelet;

    @FXML
    private Button btnDeleteTimesheet;

    @FXML
    private Button btnInsertTimesheet;

    @FXML
    private Button btnUpdate;

    @FXML
    private Button btnSearch;

    @FXML
    private Button btnUpdateForDelet;

    @FXML
    private Button btnUpdateForSearch;

    @FXML
    private TableColumn<Timesheet, LocalDate> col_date_end;

    @FXML
    private TableColumn<Timesheet, LocalDate> col_date_start;

    @FXML
    private TableColumn<Timesheet, Integer> col_id;

    @FXML
    private TableColumn<Timesheet, Integer> col_id_person;

    @FXML
    private TableColumn<Timesheet, Integer> col_number_days_work;

    @FXML
    private TableColumn<Timesheet, Integer> col_number_medical;

    @FXML
    private TableColumn<Timesheet, Integer> col_number_vacation;

    @FXML
    private TableColumn<Timesheet, Integer> col_number_weekends;

    @FXML
    private ComboBox<String> comboBoxIdPerson;

    @FXML
    private DatePicker dateEndPeriod;

    @FXML
    private DatePicker dateStartPeriod;

    @FXML
    private TextField edTextDeletedTimesheet;

    @FXML
    private TextField numberDaysForWork;

    @FXML
    private TextField numberMedical;

    @FXML
    private TextField numberOfWeekends;

    @FXML
    private TextField numberVacation;

    @FXML
    private TableView<Timesheet> table_timesheet;

    @FXML
    private TextField textDeletedIdTimesheet;

    @FXML
    private TextField textSearchPerson;

    public DbTimesheet dbTimesheet;
    public ObservableList<Timesheet> timesheetObservableList;

    @FXML
    void initialize() {
        dbTimesheet = new DbTimesheet();

        comboBoxIdPerson.setItems(dbTimesheet.getIdPersons());
        comboBoxIdPerson.setValue(dbTimesheet.getIdPersons().get(0));

        /*col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));*/
        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_id_person.setCellValueFactory(new PropertyValueFactory<>("idPerson"));
        col_date_start.setCellValueFactory(new PropertyValueFactory<>("startPeriod"));
        col_date_end.setCellValueFactory(new PropertyValueFactory<>("endPeriod"));
        col_number_days_work.setCellValueFactory(new PropertyValueFactory<>("numberDaysForWork"));
        col_number_weekends.setCellValueFactory(new PropertyValueFactory<>("numberWeekends"));
        col_number_vacation.setCellValueFactory(new PropertyValueFactory<>("numberVacation"));
        col_number_medical.setCellValueFactory(new PropertyValueFactory<>("numberMedical"));

        timesheetObservableList = DbTimesheet.getTimesheet();
        table_timesheet.setItems(timesheetObservableList);

        btnInsertTimesheet.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                dbTimesheet.insertTimesheet(new Timesheet(
                        0,
                        Integer.parseInt(comboBoxIdPerson.getValue()),
                        dateStartPeriod.getValue(),
                        dateEndPeriod.getValue(),
                        Integer.parseInt(numberDaysForWork.getText()),
                        Integer.parseInt(numberOfWeekends.getText()),
                        Integer.parseInt(numberVacation.getText()),
                        Integer.parseInt(numberMedical.getText())
                ));
                clearEdit();
                timesheetObservableList = DbTimesheet.getTimesheet();
                table_timesheet.setItems(timesheetObservableList);
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });

        btnDeleteTimesheet.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (!edTextDeletedTimesheet.getText().isEmpty()) {
                System.out.println("0");
                try {
                    dbTimesheet.deleteTimesheet(Integer.parseInt(edTextDeletedTimesheet.getText()));
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
                edTextDeletedTimesheet.clear();
                timesheetObservableList = DbTimesheet.getTimesheet();
                table_timesheet.setItems(timesheetObservableList);
            }
            System.out.println("1");

        });


    }




    public void clearEdit() {
        dateStartPeriod.getEditor().clear();
        dateEndPeriod.getEditor().clear();
        numberDaysForWork.clear();
        numberOfWeekends.clear();
        numberVacation.clear();
        numberMedical.clear();

    }

}
