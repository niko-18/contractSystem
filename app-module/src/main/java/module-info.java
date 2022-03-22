module demo {
    requires javafx.graphics;
    requires javafx.fxml;
    requires javafx.controls;
    requires org.apache.httpcomponents.httpclient;
    requires static lombok;
    requires gson;
    requires org.apache.httpcomponents.httpcore;
    requires java.sql;


    opens demo to javafx.fxml;
    opens demo.view to javafx.fxml;
    opens demo.model to gson;
    exports demo.view;
    exports demo;
}