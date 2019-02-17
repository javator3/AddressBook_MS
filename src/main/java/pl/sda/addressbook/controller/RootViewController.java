package pl.sda.addressbook.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.model.PersonHelp;
import pl.sda.addressbook.view.PersonView;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.Arrays;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;


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
    private Button importContact;

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


        personTableView.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            if (newSelection != null) {
                Person person = personTableView.getSelectionModel().getSelectedItem();
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
        this.personTableView.refresh();

    }


    public void setNewContact(ActionEvent actionEvent) {
        PersonView personView = new PersonView();
        personView.loadNewPerson();
    }

    public void editContact(ActionEvent actionEvent) {


        int index = personTableView.getSelectionModel().getFocusedIndex();
        Person person = personTableView.getSelectionModel().getSelectedItem();
        personView.loadPersonEdit(person,index);

        this.personTableView.refresh();

//
//        for (Person x:personView.getPersonList()
//        ) {
//            System.out.println(x.nameProperty());
//
//        }




    }

    public void deleteContact(ActionEvent actionEvent) {

       int index = personTableView.getSelectionModel().getFocusedIndex();
       this.personView.deletePerson(index);
    }

    public void saveContact(ActionEvent actionEvent) {

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("contacts.json");

        try {
            mapper.writeValue(file,personView.getPersonList());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void importContact(ActionEvent actionEcent){

        ObjectMapper mapper = new ObjectMapper();
        File file = new File("contacts.json");

        List<PersonHelp> kontakty = null;

        try {
            PersonHelp[] jsonabkontaktow = mapper.readValue(file,PersonHelp[].class);
            kontakty = Arrays.asList(jsonabkontaktow);


           // for (PersonHelp s:kontakty
           // ) {System.out.println(s.getName() + " " + s.getLastname());
           // }


           } catch (IOException e) {
            e.printStackTrace();
        }

        for (PersonHelp x:kontakty
        ) {

            this.personView.getPersonList().add(new Person(x.getName(),x.getLastname(),x.getStreet(),x.getCity(),x.getPostalCode(),x.getTelephone()));

                    }


        this.personTableView.refresh();

        for (Person y:this.personView.getPersonList()
        ) {
            System.out.println(" aa:" + y.nameProperty());

        }



    }

    public void selectedOnMouse(MouseEvent mouseEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();


        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalcodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());

    }

    public void selectedOnKeyReleased(KeyEvent keyEvent) {
        Person person = personTableView.getSelectionModel().getSelectedItem();

        nameLabel.setText(person.getName());
        lastnameLabel.setText(person.getLastname());
        streetLabel.setText(person.getStreet());
        cityLabel.setText(person.getCity());
        postalcodeLabel.setText(person.getPostalCode());
        telephoneLabel.setText(person.getTelephone());


    }

}
