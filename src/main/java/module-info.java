module com.corretinhoscorp {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.corretinhoscorp to javafx.fxml;
    exports com.corretinhoscorp;
}
