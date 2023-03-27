package ru.porochok.diplomproject;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;

import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
import ru.porochok.diplomproject.POJO.Person;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.Date;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class PersonLayoutController {

    @FXML
    private AnchorPane anchorPaneNewPerson;

    @FXML
    private Button btnInsertNewPerson;

    @FXML
    private Button btnDeletePerson;

    @FXML
    private Button btnUpdateNewPerson;

    @FXML
    private TableColumn<Person, LocalDate> col_born;

    @FXML
    private TableColumn<Person, String> col_family_state;

    @FXML
    private TableColumn<Person, Integer> col_id;

    @FXML
    private TableColumn<Person, Integer> col_inn;

    @FXML
    private TableColumn<Person, String> col_live_place;

    @FXML
    private TableColumn<Person, String> col_name;

    @FXML
    private TableColumn<Person, String> col_partific;

    @FXML
    private TableColumn<Person, Long> col_pasport_number;

    @FXML
    private TableColumn<Person, String> col_phone_number;

    @FXML
    private TableColumn<Person, String> col_post;

    @FXML
    private TableColumn<Person, String> col_surname;

    @FXML
    private TableColumn<Person, Double> col_time_work;

    @FXML
    private ComboBox<String> comboBoxPersonFamylePosition;

    @FXML
    private ComboBox<String> comboBoxPersonPost;

    @FXML
    private DatePicker newPersDataBorn;

    @FXML
    private TextField newPersInn;

    @FXML
    private TextField newPersLivePlace;

    @FXML
    private TextField newPersName;

    @FXML
    private TextField newPersPasportNumbers;

    @FXML
    private TextField newPersPatrocifik;

    @FXML
    private TextField newPersPhoneNumber;

    @FXML
    private TextField deletedIdPerson;

    @FXML
    private TextField newPersSurName;

    @FXML
    private TextField newPersWorkTime;

    @FXML
    private TableView<Person> table_person;

    @FXML
    private ImageView btnExportWord;

    @FXML
    private ImageView btnExportOneWord;

    @FXML
    private ImageView btnBackSerch;

    @FXML
    private Button btnSerchPerson;

    @FXML
    private TextField serchTextPerson;

    @FXML
    private TextField textPrintPerson;

    public DbPerson dbPerson;
    ObservableList<Person> personObservableList;

    ObservableList<Person> targetPersonObservableList;
    ObservableList<Person> personObservableSearchList;

    public void initialize() {
        dbPerson = new DbPerson();

        comboBoxPersonPost.setItems(DbPerson.getListPosts());
        comboBoxPersonFamylePosition.setItems(DbPerson.getListFamilyState());
        comboBoxPersonPost.setValue(DbPerson.getListPosts().get(0));
        comboBoxPersonFamylePosition.setValue(DbPerson.getListFamilyState().get(0));

        col_id.setCellValueFactory(new PropertyValueFactory<>("id"));
        col_surname.setCellValueFactory(new PropertyValueFactory<>("surname"));
        col_name.setCellValueFactory(new PropertyValueFactory<>("name"));
        col_partific.setCellValueFactory(new PropertyValueFactory<>("patronymic"));
        col_post.setCellValueFactory(new PropertyValueFactory<>("post"));
        col_time_work.setCellValueFactory(new PropertyValueFactory<>("workExperience"));
        col_pasport_number.setCellValueFactory(new PropertyValueFactory<>("passportNumber"));
        col_inn.setCellValueFactory(new PropertyValueFactory<>("inn"));
        col_family_state.setCellValueFactory(new PropertyValueFactory<>("familyComposition"));
        col_born.setCellValueFactory(new PropertyValueFactory<>("dateBorn"));
        col_live_place.setCellValueFactory(new PropertyValueFactory<>("placeToLive"));
        col_phone_number.setCellValueFactory(new PropertyValueFactory<>("phoneNumber"));

        personObservableList = DbPerson.getPersons();

        table_person.setItems(personObservableList);

        btnInsertNewPerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                dbPerson.insertPersons(new Person(
                        0,
                        newPersSurName.getText(),
                        newPersName.getText(),
                        newPersPatrocifik.getText(),
                        comboBoxPersonPost.getValue(),
                        Double.parseDouble(newPersWorkTime.getText()),
                        Long.parseLong(newPersPasportNumbers.getText()),
                        Long.parseLong(newPersInn.getText()),
                        comboBoxPersonFamylePosition.getValue(),
                        newPersDataBorn.getValue(),
                        newPersLivePlace.getText(),
                        newPersPhoneNumber.getText()
                ));
                clearEdit();
            } catch (ClassNotFoundException | SQLException e) {
                e.printStackTrace();
            }
        });

        btnUpdateNewPerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            personObservableList = DbPerson.getPersons();

            table_person.setItems(personObservableList);
        });

        btnExportWord.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {

            personObservableList = DbPerson.getPersons();

            Date date = new Date();
            String listString = personObservableList.stream().map(Object::toString)
                    .collect(Collectors.joining("\n"));

            String dataOfCreated = date.toString() + "\n";
            String enter = "\n\n";
            String interval = "=========================================================================";

            String folder = "C:\\Users\\pmayk\\OneDrive\\Документы\\Отчёты Сотрудников";

            String fileName = "Otchet " + date.getHours() + "." + date.getMinutes() + ".doc";

            // Dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Файл создан!");
            alert.setHeaderText("Результат:");
            alert.setContentText("Файл сохранен в папке: Отчёты Сотрудников!");


            //
            File file = new File(folder);
            if (file.exists()) {
                alert.showAndWait();
                System.out.println("Файл создан " + folder);
            }

            try {
                FileOutputStream out = new FileOutputStream(folder + fileName);
                out.write(interval.getBytes());
                out.write(dataOfCreated.getBytes());
                out.write(interval.getBytes());
                out.write(enter.getBytes());
                out.write(listString.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        });

        btnDeletePerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                dbPerson.deletePerson(Integer.parseInt(deletedIdPerson.getText()));
                deletedIdPerson.clear();
            } catch (SQLException | ClassNotFoundException e) {
                e.printStackTrace();
            }
        });

        btnSerchPerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            personObservableSearchList = DbPerson.searchPersonForPassport(serchTextPerson.getText());
            table_person.setItems(personObservableSearchList);
        });

        btnBackSerch.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            personObservableList = DbPerson.getPersons();
            table_person.setItems(personObservableList);
        });

        btnExportOneWord.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            /*textPrintPerson*/
            targetPersonObservableList = DbPerson.getTargetPerson(textPrintPerson.getText());

            Date date = new Date();
            String listString = targetPersonObservableList.stream().map(Object::toString)
                    .collect(Collectors.joining("\n"));

            String dataOfCreated = date.toString() + "\n";
            String enter = "\n\n";
            String interval = "=========================================================================";

            String folder = "C:\\Users\\pmayk\\OneDrive\\Документы\\Отчёты Сотрудников";

            String fileName = "Solo Otchet " + date.getHours() + "." + date.getMinutes() + ".doc";

            File file = new File(folder);
            // Dialog
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Файл создан!");
            alert.setHeaderText("Результат:");
            alert.setContentText("Файл сохранен в папке: Отчёты Сотудников!");

            //

            if (file.exists()) {
                alert.showAndWait();
                System.out.println("Файл создан " + folder);
            }

            try {
                FileOutputStream out = new FileOutputStream(folder + fileName);
                out.write(interval.getBytes());
                out.write(dataOfCreated.getBytes());
                out.write(interval.getBytes());
                out.write(enter.getBytes());
                out.write(listString.getBytes());
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    public void clearEdit() {
        newPersSurName.clear();
        newPersName.clear();
        newPersPatrocifik.clear();
        comboBoxPersonPost.getEditor().clear();
        newPersWorkTime.clear();
        newPersPasportNumbers.clear();
        newPersInn.clear();
        comboBoxPersonFamylePosition.getEditor().clear();
        newPersDataBorn.getEditor().clear();
        newPersLivePlace.clear();
        newPersPhoneNumber.clear();
    }

}