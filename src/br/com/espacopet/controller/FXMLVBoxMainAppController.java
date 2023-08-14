package br.com.espacopet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

public class FXMLVBoxMainAppController implements Initializable {
    
    
    @FXML
    private MenuItem menuItemAgendamentos;

    @FXML
    private MenuItem menuItemCadastroCliente;
    
    @FXML
    private AnchorPane anchorPane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void handleMenuItemCadastroCliente() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroCliente.fxml"));;
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemAgendamentos() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroMarca.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    

}
