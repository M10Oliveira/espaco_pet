/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.espacopet.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author letic
 */
public class FXMLAnchorPaneCadastroClienteController implements Initializable {

    @FXML
    private TableView<?> tableViewClientes;
    @FXML
    private TableColumn<?, ?> tableColumnClienteNome;
    @FXML
    private TableColumn<?, ?> tableColumnClienteCelular;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label lbClienteId;
    @FXML
    private Label lbClienteNome;
    @FXML
    private Label lbRaca;
    @FXML
    private Label lbClienteCelular;
    @FXML
    private Label lbClienteDataRegistro;
    @FXML
    private Label lbNomeTutor;
    @FXML
    private Label lbDtNasc;
    @FXML
    private Button btInserir;
    @FXML
    private Button btAlterar;
    @FXML
    private Button btExcluir;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void handleBtInserir() throws IOException {
    }

    @FXML
    private void handleBtAlterar() throws IOException {
    }

    @FXML
    private void handleBtExcluir() throws IOException {
    }
    
}
