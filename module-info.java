module org.example.musicselectorwithjava {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens org.example.musicselectorwithjava to javafx.fxml;
    exports org.example.musicselectorwithjava;
}