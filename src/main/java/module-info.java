module com.vladickgeyinc.tic_tac_toe {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;


    opens com.vladickgeyinc.tic_tac_toe to javafx.fxml;
    exports com.vladickgeyinc.tic_tac_toe;
}