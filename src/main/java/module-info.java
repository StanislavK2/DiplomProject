module ru.porochok.diplomproject {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens ru.porochok.diplomproject to javafx.fxml;
    exports ru.porochok.diplomproject;
    exports ru.porochok.diplomproject.POJO;
    opens ru.porochok.diplomproject.POJO to javafx.fxml;
    exports ru.porochok.diplomproject.dismissal;
    opens ru.porochok.diplomproject.dismissal to javafx.fxml;
}