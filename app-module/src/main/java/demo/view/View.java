package demo.view;

import demo.http.RestController;
import demo.model.Contract;
import demo.utils.DateHelper;
import javafx.application.Platform;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.CheckBoxTableCell;

import java.io.IOException;

public class View {

    @FXML
    private TableView<Contract> tableView;

    @FXML
    private TableColumn<Contract, Boolean> activeColumn;

    @FXML
    private TableColumn<Contract, String> contractsColumn;

    @FXML
    private TableColumn<Contract, String> dateColumn;

    @FXML
    private TableColumn<Contract, String> lastUpdateColumn;

    @FXML
    private TableColumn<Contract, Integer> numberColumn;

    @FXML
    private Button refreshButton;

    @FXML
    void initialize() {
        contractsColumn.setCellValueFactory(cf -> new SimpleStringProperty(cf.getValue().getName()));
        dateColumn.setCellValueFactory(cf -> new SimpleStringProperty(DateHelper.convertDate(cf.getValue().getDate())));
        lastUpdateColumn.setCellValueFactory(cf -> new SimpleStringProperty(DateHelper.convertDateTime(cf.getValue().getLastUpdate())));
        numberColumn.setCellValueFactory(cf -> new SimpleIntegerProperty(cf.getValue().getNumber()).asObject());
        activeColumn.setCellValueFactory(param -> new SimpleBooleanProperty(param.getValue().isActive()));
        activeColumn.setCellFactory(c -> {
            CheckBoxTableCell<Contract, Boolean> cell = new CheckBoxTableCell<>();
            cell.setAlignment(Pos.CENTER);
            return cell;
        });

        Platform.runLater(this::updateTable);

        refreshButton.setOnAction(actionEvent -> updateTable());
    }

    private void updateTable() {
        try {
            tableView.setItems(FXCollections.observableArrayList(RestController.getObjects(Contract.class)));
        } catch (IOException e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Error");
            alert.setHeaderText(null);
            alert.setContentText("Нет подключения к серверу");
            alert.showAndWait();
        }
    }

}
