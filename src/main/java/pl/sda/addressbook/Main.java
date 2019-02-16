package pl.sda.addressbook;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;


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
            Parent root = FXMLLoader.load(
                    getClass()
                            .getResource("/root.fxml"));
            primaryStage.setScene(new Scene(root,600,350));
            primaryStage.show();
        }
        //ile plkow fxml - tyle kontrolerow

    }
