/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.espacopet.controller;


import br.com.espacopet.model.domain.Cliente;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matheus Oliveira
 */
public class FXMLAnchorPaneCadastroClienteDialogController implements Initializable {
    
    
    @FXML
    private Button btCancelar;

    @FXML
    private Button btConfirmar;

    @FXML
    private TextField tfCelular;

    @FXML
    private TextField tfEndereco;

    
    @FXML
    private TextField tfNome;

    @FXML
    private TextField tfNomeTutor;
    
    @FXML
    private DatePicker dtDataRegistro;
           
    
    @FXML
    private TextField tfRaca;
    
    private Stage dialogStage;
    private boolean btConfirmarClicked = false;
    private Cliente cliente;
    
    
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }       

    public boolean isBtConfirmarClicked() {
        return btConfirmarClicked;
    }

    public void setBtConfirmarClicked(boolean btConfirmarClicked) {
        this.btConfirmarClicked = btConfirmarClicked;
    }

    public Stage getDialogStage() {
        return dialogStage;
    }

    public void setDialogStage(Stage dialogStage) {
        this.dialogStage = dialogStage;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
        this.tfNome.setText(this.cliente.getNome());
        this.tfRaca.setText(this.cliente.getRaca());
        this.tfNomeTutor.setText(this.cliente.getNomeTutor());
        this.tfCelular.setText(this.cliente.getCelular());
        this.tfEndereco.setText(this.cliente.getEndereco());
        dtDataRegistro.setValue(this.cliente.getDataRegistro());
    }
    

    @FXML
    public void handleBtConfirmar() {
        if (validarEntradaDeDados()) {
            cliente.setNome(tfNome.getText());
            cliente.setRaca(tfRaca.getText());
            cliente.setCelular(tfCelular.getText());
            cliente.setEndereco(tfEndereco.getText());
            cliente.setNomeTutor(tfNomeTutor.getText());
            cliente.setDataRegistro(dtDataRegistro.getValue());

            btConfirmarClicked = true;
            dialogStage.close();
        }
    }
    
    @FXML
    public void handleBtCancelar() {
        dialogStage.close();
    }
    
    //método para validar a entrada de dados
    private boolean validarEntradaDeDados() {
        String errorMessage = "";
        if (this.tfNome.getText() == null || this.tfNome.getText().length() == 0) {
            errorMessage += "Nome inválido.\n";
        }
        
        if (this.tfNomeTutor.getText() == null || this.tfNomeTutor.getText().length() == 0) {
            errorMessage += "Nome do tutor inválido.\n";
        }
        
        if (this.dtDataRegistro.getValue()== null ) {
            errorMessage += "Data inválida.\n";
        }
        
        if (this.tfCelular.getText() == null || this.tfCelular.getText().length() == 0) {
            errorMessage += "Celular inválido.\n";
        }
        
        if (this.tfRaca.getText() == null || this.tfRaca.getText().length() == 0) {
            errorMessage += "Raça inválida.\n";
        } 
        
        if (this.tfEndereco.getText() == null || this.tfEndereco.getText().length() == 0) {
            errorMessage += "Endereço inválido.\n";
        }
        
        if (errorMessage.length() == 0) {
            return true;
        } else {
            //exibindo uma mensagem de erro
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Erro no cadastro");
            alert.setHeaderText("Corrija os campos inválidos!");
            alert.setContentText(errorMessage);
            alert.show();
            return false;
        }
    }
    
}
