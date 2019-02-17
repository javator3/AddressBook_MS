package pl.sda.addressbook.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonBar;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

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
    private Button personCancel;

    @FXML
    private ButtonBar personButtonBar;

    private PersonView personView;

public void savePerson(){
    String pt = personTelephon.getText();
    System.out.println(pt);
    String name = personName.getText();
    String lname = personLastName.getText();
    String street = personStreet.getText();
    String city = personCity.getText();
    String postcode = personPostCode.getText();
    String telephone = personTelephon.getText();
    
    this.personView.getPersonList().add(new Person(name,lname,street,city,postcode,telephone));

    for (Person x:this.personView.getPersonList()
    ) {
        System.out.println(x.nameProperty());

    }
}

    public void setPersonView(PersonView personView) {
    this.personView = personView;
    }

    public void cancelPerson(ActionEvent actionEvent) {
    }

}
