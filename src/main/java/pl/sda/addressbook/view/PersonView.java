package pl.sda.addressbook.view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import pl.sda.addressbook.controller.NewPersonController;
import pl.sda.addressbook.controller.RootViewController;
import pl.sda.addressbook.model.Person;

import java.io.IOException;
import java.util.Queue;

public class PersonView {

    private Stage stage;

   public static ObservableList<Person> personList = FXCollections.observableArrayList();

    public PersonView(Stage stage) {
        this.stage = stage;
        personList.add(new Person("Jan","Kowalski","Warszawska","Torun","86-233","789789789"));
        personList.add(new Person("Katarzyna","Nowak","Mickiewicza","Gdansk","87-100","456456456"));
        personList.add(new Person("Izabela","Jankowska","Słoneczna","Warszawa","12-123","123123123"));
        personList.add(new Person("Marian","Lewandowski","Ksiezycowa","Warszawa","12-123","123123123"));
        personList.add(new Person("Paweł","Tatarata","Słoneczna","Warszawa","12-123","123123123"));
    }

    public PersonView() {
    }

    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public Stage getStage() {
        return stage;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void setPersonList(ObservableList<Person> personList) {
        this.personList = personList;
    }

    public void loadView(){
        //zaladowac i wyswietlic widok rootview

        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/root.fxml"));


        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        stage.setScene(new Scene(parent,600,400));
        stage.setTitle("Address book");

        RootViewController rootViewController = loader.getController();

        rootViewController.setPersonView(this);


        stage.show();
    }

    public void loadNewPerson(){

        // personView.loadNewPersonView();
        // 1 zaladowac fxml
        // 2 stworzyc kontroler
        // 3 wyswietlic widok
        // w klasie NewPersonController stworzyc funkcje savePerson
        // savePerson ma bnc wuwolywana w molmencie kierdu klikanimemy w button save
        // nowy Person ustawiamy wartosci tekst Field
        // dodanie obiektu na liscie


        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(getClass().getResource("/newperson.fxml"));

        Stage stage1 = new Stage();

        try {
            loader.load();
        } catch (IOException e) {
            e.printStackTrace();
        }

        Parent parent = loader.getRoot();

        stage1.setScene(new Scene(parent,600,400));
        stage1.setTitle("New person");
        stage1.show();

        NewPersonController newPersonController = loader.getController();
        newPersonController.setPersonView(this);

    }



}
