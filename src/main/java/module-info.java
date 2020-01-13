module com.mycompany.pongfx {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pongfx to javafx.fxml;
    exports com.mycompany.pongfx;
}