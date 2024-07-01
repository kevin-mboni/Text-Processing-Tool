module com.example.textprocessing_data {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.textprocessing_data to javafx.fxml;
    exports com.example.textprocessing_data;
}