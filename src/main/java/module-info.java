module com.corretinhoscorp {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;

    opens com.corretinhoscorp to javafx.fxml;
    exports com.corretinhoscorp;
}
