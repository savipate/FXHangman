package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.event.*;
import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Main extends Application {

    static Socket socket;
    static DataInputStream in;
    static DataOutputStream out;


    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Hangman");
        primaryStage.setScene(new Scene(root, 594, 400));
        primaryStage.show();
    }


    public static void main(String[] args) throws Exception {

        launch(args);
    }
}

