package ru.porochok.diplomproject.department;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import ru.porochok.diplomproject.POJO.Department;

import java.sql.SQLException;

public class DeportmentLayoutController {

    @FXML
    private TableColumn<Department, String> col_name;

    @FXML
    private TableView<Department> table_dismissal;

    private DbDepartment dbDepartment;

    @FXML
    private Button btnInsert;

    @FXML
    private Button dtnDelete;

    @FXML
    private TextField textDelete;

    @FXML
    private TextField textTitleDeportment;


    public void initialize() {

        dbDepartment = new DbDepartment();
        col_name.setCellValueFactory(new PropertyValueFactory<>("title"));
        table_dismissal.setItems(DbDepartment.getDepartment());

        btnInsert.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (textTitleDeportment.getText() != null) {
                try {
                    dbDepartment.insertDepartment(new Department(textTitleDeportment.getText()));
                    table_dismissal.setItems(DbDepartment.getDepartment());
                    textTitleDeportment.clear();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

        dtnDelete.addEventHandler(MouseEvent.MOUSE_CLICKED, mouseEvent -> {
            if (textDelete.getText() != null) {
                try {
                    dbDepartment.deletePerson(textDelete.getText());
                    table_dismissal.setItems(DbDepartment.getDepartment());
                    textDelete.clear();
                } catch (SQLException | ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        });

    }

}
