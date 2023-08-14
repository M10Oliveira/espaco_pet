/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package br.com.espacopet.mainapp;

import java.io.IOException;
import javafx.application.Application;
//import static javafx.application.Application.launch;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

/**
 *
 * @author mpisc
 */
public class MainApp extends Application {
    
    
    @Override
    public void start(Stage primaryStage) {
        Parent root = null;
        try {
          
            root = FXMLLoader.load(getClass().getResource("../view/FXMLVBoxMainApp.fxml"));
        } catch (IOException ex) {
            System.out.println("Nao foi possivel carregar o formulario");
        }
        
        Scene scene = new Scene(root, 600, 400);
        
        primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("../icon/icon.png")));
        primaryStage.setTitle("Espaço Pet");
        primaryStage.setScene(scene);
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
