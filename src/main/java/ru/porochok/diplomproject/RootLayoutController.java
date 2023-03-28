package ru.porochok.diplomproject;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.input.MouseEvent;
import javafx.scene.text.Text;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class RootLayoutController {

    @FXML
    private Button btnGoEmploumentContract;

    @FXML
    private Button btnGoTimeSheet;

    @FXML
    private Button btnGoNewPerson;

    @FXML
    private Text textViewNowData;

    @FXML
    private Button btnGoDismissal;

    @FXML
    private Button btnGoDepartment;
    @FXML
    private Button btnGoContract;

    public void initialize() {
        btnGoNewPerson.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("person_layout.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1576, 625);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Сотрудники");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnGoTimeSheet.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("time_sheet_layout.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1570, 572);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Табель рабочего времени");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnGoDismissal.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("dismissal_layout.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1424, 572);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Увольнение");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnGoDepartment.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("deportament.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 723, 572);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Отдел");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });

        btnGoContract.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("employment_contract.fxml"));
                Scene scene = new Scene(fxmlLoader.load(), 1582, 625);
                Stage stage = new Stage();
                stage.setResizable(false);
                stage.setTitle("Трудовой договор");
                stage.setScene(scene);
                stage.show();
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}
