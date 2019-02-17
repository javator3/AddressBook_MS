package pl.sda.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.paint.Color;
import pl.sda.addressbook.model.Person;
import pl.sda.addressbook.view.PersonView;

import java.awt.*;


public class Main extends Application {

    public static void main(String[] args) {
        //kazdy projekt FX musi rozszerzac klase Application !!
        // i overrridowac start ...
            launch();
            // odpala cala aplikacje fxowoa , metoda start jest odpalana przez launch ..
        }

        //definiujemy stage, plik FXML uprzednio wrzucacmy do resources

        @Override
        public void start(Stage primaryStage) throws Exception {

            PersonView personView = new PersonView(primaryStage);

            personView.loadView();

            for (Person x:personView.getPersonList()
                 ) {
                System.out.println(x.nameProperty());

            }
          // primaryStage.show();



        }
        //ile plkow fxml - tyle kontrolerow

    }
