package br.com.espacopet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class FXMLVBoxMainAppController implements Initializable {
    
    
    @FXML
    private MenuItem menuItemAgendamentos;

    @FXML
    private MenuItem menuItemCadastroCliente;
    
     @FXML
    private MenuItem menuItemControleCaixa;

    @FXML
    private MenuItem menuItemSobre;

    @FXML
    private MenuItem menuItemVenda;
    
    @FXML
    private MenuItem menuItemCadastroProduto;
    
     
        
    @FXML
    private AnchorPane anchorPane;
    
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }  
    
    @FXML
    public void handleMenuItemCadastroCliente() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemCadastroProduto() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroProduto.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemControleCaixa() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }@FXML
    public void handleMenuItemVenda() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroCliente.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    @FXML
    public void handleMenuItemAgendamentos() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneCadastroMarca.fxml"));
        anchorPane.getChildren().setAll(a);
    }
    
    @FXML
    public void handleMenuItemSobre() throws IOException {
        AnchorPane a = (AnchorPane)FXMLLoader.load(getClass().getResource("../view/FXMLAnchorPaneSobre.fxml"));
        anchorPane.getChildren().setAll(a);
        
        
    }
    

}
