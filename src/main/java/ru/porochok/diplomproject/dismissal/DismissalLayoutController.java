package ru.porochok.diplomproject.dismissal;

import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import ru.porochok.diplomproject.POJO.Dismissal;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

public class DismissalLayoutController {

    @FXML
    private ImageView btnAllExportWord;

    @FXML
    private ImageView btnExportOneWord;

    @FXML
    private Button btnInsert;

    @FXML
    private Button btnSearchDismissalForIdPerson;

    @FXML
    private Button btnSearchForIdDismissal;

    @FXML
    private Button btnUpdateForSearch;

    @FXML
    private Button btnUpdateForSearch3;

    @FXML
    private Button btnSort;

    @FXML
    private TableColumn<Dismissal, LocalDate> col_date_create;

    @FXML
    private TableColumn<Dismissal, LocalDate> col_date_dismissal;

    @FXML
    private TableColumn<Dismissal, String> col_footing;

    @FXML
    private TableColumn<Dismissal, ?> col_id;

    @FXML
    private TableColumn<Dismissal, ?> col_id_person;

    @FXML
    private TableColumn<Dismissal, ?> col_number_pay_for_person;

    @FXML
    private ComboBox<String> comboBoxFootingDismissal;

    @FXML
    private ComboBox<String> comboBoxIdPerson;

    @FXML
    private ComboBox<String> comboBoxFootingDismissalForSeartch;

    @FXML
    private DatePicker dateCreatedDismissal;

    @FXML
    private DatePicker dateDoneDismissal;

    @FXML
    private TextField numberPayForPerson;

    @FXML
    private TableView<Dismissal> table_dismissal;

    @FXML
    private TextField textExportOnePerson;

    @FXML
    private TextField textSeartchDismissallForId;

    @FXML
    private TextField textSeartchDismissallForIdPerson;

    private DbDismissal dbDismissal;

    private ObservableList<Dismissal> dismissalObservableList;
    private ObservableList<Dismissal> dismissalSearcthForIdObservableList;
    private ObservableList<Dismissal> dismissalSearcthForIdPersonObservableList;

    public void initialize() {

        dbDismissal = new DbDismissal();

        comboBoxIdPerson.setItems(DbDismissal.getListIdPerson());
        comboBoxIdPerson.setValue(DbDismissal.getListIdPerson().get(0));

        comboBoxFootingDismissal.setItems(DbDismissal.getListFooting());
        comboBoxFootingDismissal.setValue(DbDismissal.getListFooting().get(0));

        comboBoxFootingDismissalForSeartch.setItems(DbDismissal.getListFooting());
        comboBoxFootingDismissalForSeartch.setValue(DbDismissal.getListFooting().get(0));

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_id_person.setCellValueFactory(new PropertyValueFactory<>("idPerson"));
        col_date_create.setCellValueFactory(new PropertyValueFactory<>("dateCreatedDismissal"));
        col_date_dismissal.setCellValueFactory(new PropertyValueFactory<>("dateDoneDismissal"));
        col_footing.setCellValueFactory(new PropertyValueFactory<>("footing"));
        col_number_pay_for_person.setCellValueFactory(new PropertyValueFactory<>("sumToPayPerson"));
        dismissalObservableList = DbDismissal.getDismissals();
        table_dismissal.setItems(dismissalObservableList);

        btnInsert.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (dateCreatedDismissal.getValue() != null &&
                dateDoneDismissal.getValue() != null &&
                numberPayForPerson.getText() != null)  {
                try {
                    dbDismissal.insertDismissal(
                            new Dismissal(
                                    0,
                                    dateCreatedDismissal.getValue(),
                                    dateDoneDismissal.getValue(),
                                    Integer.parseInt(comboBoxIdPerson.getValue()),
                                    comboBoxFootingDismissal.getValue(),
                                    Double.valueOf(numberPayForPerson.getText())
                            )
                    );

                    dismissalObservableList = DbDismissal.getDismissals();
                    table_dismissal.setItems(dismissalObservableList);
                    dbDismissal.deletePerson(Integer.parseInt(comboBoxIdPerson.getValue()));
                    comboBoxIdPerson.setItems(DbDismissal.getListIdPerson());
                    comboBoxIdPerson.setValue(DbDismissal.getListIdPerson().get(0));
                } catch (SQLException | ClassNotFoundException e) {
                    throw new RuntimeException(e);
                }
            }
        });

        btnSort.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            table_dismissal.setItems(DbDismissal.getSortedForFooting(comboBoxFootingDismissalForSeartch.getValue()));
        });

        btnUpdateForSearch3.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            dismissalObservableList = DbDismissal.getDismissals();
            table_dismissal.setItems(dismissalObservableList);
        });

        btnAllExportWord.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            dismissalObservableList = DbDismissal.getDismissals();
            Date date = new Date();
            String listString = dismissalObservableList.stream().map(Object::toString)
                    .collect(Collectors.joining("\n"));

            String dataOfCreated = date.toString() + "\n";
            String enter = "\n\n";
            String interval = "=========================================================================";

            String folder = "C:\\Users\\pmayk\\OneDrive\\Документы\\Увольнение сотрудников\\";

            String fileName = "Увольнения " + date.getHours() + "." + date.getMinutes() + ".doc";

            // Dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Файл создан!");
            alert.setHeaderText("Результат:");
            alert.setContentText("Файл сохранен в папке: Увольнение сотрудников!");


            //
            File file = new File(folder);
            if (file.exists()) {
                alert.showAndWait();
                System.out.println("Файл создан " + folder);
            }

            try {
                FileOutputStream out = new FileOutputStream(folder + fileName);

                out.write(dataOfCreated.getBytes());
                out.write(interval.getBytes());
                out.write(enter.getBytes());
                out.write(listString.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });

        btnUpdateForSearch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            dismissalObservableList = DbDismissal.getDismissals();
            table_dismissal.setItems(dismissalObservableList);
        });

        btnSearchForIdDismissal.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (textSeartchDismissallForId.getText() != null) {
                dismissalSearcthForIdObservableList = DbDismissal.searchDismissalForDismissalId(Integer.parseInt(textSeartchDismissallForId.getText()));
                table_dismissal.setItems(dismissalSearcthForIdObservableList);
            }
        });

        btnSearchDismissalForIdPerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (textSeartchDismissallForIdPerson.getText() != null) {
                dismissalSearcthForIdPersonObservableList = DbDismissal.searchDismissalForPersonId(Integer.parseInt(textSeartchDismissallForIdPerson.getText()));
                table_dismissal.setItems(dismissalSearcthForIdPersonObservableList);
            }
        });
    }




}
