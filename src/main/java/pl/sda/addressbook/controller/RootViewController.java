package pl.sda.addressbook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.net.URL;
import java.util.ResourceBundle;
import java.util.concurrent.atomic.AtomicInteger;

public class RootViewController implements Initializable {



    @FXML
    private ButtonBar brbar;


    @FXML
    private Button newContact;

    @FXML
    private Button editContact;

    @FXML
    private Button deleteContact;

    @FXML
    private Button saveContact;


    @FXML
    private Label nameLabel;

    @FXML
    private Label lastnameLabel;

    @FXML
    private Label streetLabel;

    @FXML
    private Label cityLabel;

    @FXML
    private Label postalcodeLabel;

    @FXML
    private Label telephoneLabel;

    @FXML
    private TableView<Person> personTableView;

    @FXML
    private TableColumn<Person, String> nameCol;

    @FXML
    private TableColumn<Person, String> lastnameCol;

    @FXML
    private ImageView image;



    private PersonView personView;


    public void setPersonView(PersonView personView){
        this.personView = personView;
        personTableView.setItems(personView.getPersonList());
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {


        PersonView personView = new PersonView();
        personTableView.setItems(personView.getPersonList());


        String nm;
        personTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                System.out.println(newSelection.nameProperty());
            }
        });

        nameLabel.setText("asd");
        lastnameLabel.setText(" ... ");
        streetLabel.setText(" ... ");
        cityLabel.setText(" ... ");
        postalcodeLabel.setText(" ... ");
        telephoneLabel.setText(" ... ");

        nameCol.setCellValueFactory(c -> c.getValue().nameProperty());
        lastnameCol.setCellValueFactory(c -> c.getValue().lastnameProperty());

    }


    public void setNewContact(ActionEvent actionEvent) {
        PersonView personView = new PersonView();
        personView.loadNewPerson();
    }

    public void editContact(ActionEvent actionEvent) {
        this.personTableView.refresh();
        System.out.println("TEST");

        for (Person x:personView.getPersonList()
        ) {
            System.out.println(x.nameProperty());

        }
    }

    public void deleteContact(ActionEvent actionEvent) {
    }

    public void saveContact(ActionEvent actionEvent) {
    }
}
