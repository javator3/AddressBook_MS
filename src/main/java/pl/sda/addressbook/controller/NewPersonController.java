package pl.sda.addressbook.controller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.io.IOException;

public class NewPersonController {

    @FXML
    private TextField personName;

    @FXML
    private TextField personLastName;

    @FXML
    private TextField personStreet;

    @FXML
    private TextField personCity;

    @FXML
    private TextField personPostCode;

    @FXML
    private TextField personTelephon;

    @FXML
    private Button personSave;

    @FXML
    private Button personNewSave;

    @FXML
    private Button personCancel;

    @FXML
    private ButtonBar personButtonBar;

    private PersonView personView;

    private int indeks = -1;

    public void savePerson(){

    String pt = personTelephon.getText();
    String name = personName.getText();
    String lname = personLastName.getText();
    String street = personStreet.getText();
    String city = personCity.getText();
    String postcode = personPostCode.getText();
    String telephone = personTelephon.getText();


    ObservableList<Person> personList;
    personList = this.personView.getPersonList();

    int indeks = this.getIndeks();
    Person edytowana = personList.get(indeks);
    edytowana = new Person(name,lname,street,city,postcode,telephone);
    personList.set(indeks,edytowana);

    this.personView.setPersonList(personList);
    this.setIndex(-1);

        Stage stage = (Stage) personSave.getScene().getWindow();
        stage.close();


}

    public void saveNewPerson(){

        String pt = personTelephon.getText();
        String name = personName.getText();
        String lname = personLastName.getText();
        String street = personStreet.getText();
        String city = personCity.getText();
        String postcode = personPostCode.getText();
        String telephone = personTelephon.getText();

        ObservableList<Person> personList;
        personList = this.personView.getPersonList();

        System.out.println(" START0");
        for (Person x:this.personView.getPersonList()
        ) {
            System.out.println(x.nameProperty());
        }
        System.out.println(" KONIEC0");


        //this.personView.getPersonList().add(new Person(name,lname,street,city,postcode,telephone));

        personList.add(new Person(name,lname,street,city,postcode,telephone));

        this.personView.setPersonList(personList);

        System.out.println(" START");
        for (Person x:this.personView.getPersonList()
        ) {
            System.out.println(x.nameProperty());

        }
        System.out.println(" KONIEC");
        // this.personView.setPersonList(per);

        Stage stage = (Stage) personNewSave.getScene().getWindow();
        stage.close();

    }


    public void setPersonView(PersonView personView) {
    this.personView = personView;
    }

    public void cancelPerson(ActionEvent actionEvent) {

        Stage stage = (Stage) personCancel.getScene().getWindow();
        //gdzie personCancel to nazwa buttona
        stage.close();


        // personView.getNewPersonStage().close();

    }



    public void editPerson(Person person,int index){

        personName.setText(person.getName());
        personLastName.setText(person.getLastname());
        personStreet.setText(person.getStreet());
        personCity.setText(person.getCity());
        personPostCode.setText(person.getPostalCode());
        personTelephon.setText(person.getTelephone());



    }

    public void setIndex(int index){
        this.indeks = index;
    }

    public int getIndeks() {
        return indeks;
    }


}
