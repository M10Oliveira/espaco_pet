/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package br.com.espacopet.controller;

import br.com.espacopet.model.dao.ClienteDAO;
import br.com.espacopet.model.database.Database;
import br.com.espacopet.model.database.DatabaseFactory;
import br.com.espacopet.model.domain.Cliente;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author Matheus Oliveira
 */
public class FXMLAnchorPaneCadastroClienteController implements Initializable {

    @FXML
    private TableView<Cliente> tableViewClientes;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteNome;
    @FXML
    private TableColumn<Cliente, String> tableColumnClienteCelular;
    @FXML
    private AnchorPane anchorPane;
    @FXML
    private Label lbClienteId;
    @FXML
    private Label lbClienteNome;
    @FXML
    private Label lbEndereco;
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
    
    private List<Cliente> listaClientes;
    private ObservableList<Cliente> observableListClientes;
    
    private final Database database = DatabaseFactory.getDatabase("mysql");
    private final Connection connection = database.conectar();
    private final ClienteDAO clienteDAO = new ClienteDAO();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        clienteDAO.setConnection(connection);
        carregarTableViewCliente();
        
        tableViewClientes.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selecionarItemTableViewClientes(newValue));
    }      
    
    public void selecionarItemTableViewClientes(Cliente cliente) {
        if (cliente != null) {
            lbClienteId.setText(String.valueOf(cliente.getId())); 
            lbClienteNome.setText(cliente.getNome());
            lbNomeTutor.setText(cliente.getNomeTutor());
            lbRaca.setText(cliente.getRaca());
            lbClienteCelular.setText(cliente.getCelular());
            lbEndereco.setText(cliente.getEndereco());
            lbClienteDataRegistro.setText(String.valueOf(
                    cliente.getDataRegistro().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"))));
        } else {
            lbClienteId.setText(""); 
            lbClienteNome.setText("");
            lbNomeTutor.setText("");
            lbRaca.setText("");
            lbClienteCelular.setText("");
            lbEndereco.setText("");
            lbClienteDataRegistro.setText("");
        }
        
    }
    public void carregarTableViewCliente() {
        tableColumnClienteNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
        tableColumnClienteCelular.setCellValueFactory(new PropertyValueFactory<>("celular"));
        
        listaClientes = clienteDAO.listar();
        
        observableListClientes = FXCollections.observableArrayList(listaClientes);
        tableViewClientes.setItems(observableListClientes);
    }

    @FXML
    public void handleBtInserir() throws IOException {
        Cliente cliente = new Cliente();
        boolean btConfirmarClicked = showFXMLAnchorPaneCadastroClienteDialog(cliente);
        if (btConfirmarClicked) {
            clienteDAO.inserir(cliente);
            carregarTableViewCliente();
        } 
    }
    
    @FXML 
    public void handleBtAlterar() throws IOException {
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            boolean btConfirmarClicked = showFXMLAnchorPaneCadastroClienteDialog(cliente);
            if (btConfirmarClicked) {
                clienteDAO.alterar(cliente);
                carregarTableViewCliente();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Esta operação requer a seleção \nde um Cliente na tabela ao lado");
            alert.show();
        }
    }

    @FXML
    public void handleBtExcluir() throws IOException {
        Cliente cliente = tableViewClientes.getSelectionModel().getSelectedItem();
        if (cliente != null) {
            clienteDAO.remover(cliente);
            carregarTableViewCliente();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText("Esta operação requer a seleção \nde uma Cliente na tabela ao lado");
            alert.show();
        }
    }

    
    
    private boolean showFXMLAnchorPaneCadastroClienteDialog(Cliente cliente) throws IOException {
        FXMLLoader loader = new FXMLLoader();
        loader.setLocation(FXMLAnchorPaneCadastroClienteController.class.getResource("../view/FXMLAnchorPaneCadastroClienteDialog.fxml"));
        AnchorPane page = (AnchorPane) loader.load();
        
        //criação de um estágio de diálogo (StageDialog)
        Stage dialogStage = new Stage();
        dialogStage.getIcons().add(new Image(getClass().getResourceAsStream("../icon/icon.png")));
        dialogStage.setTitle("Cadastro de Cliente");
        Scene scene = new Scene(page);
        dialogStage.setScene(scene);
        
        //enviando o obejto cliente para o controller
        FXMLAnchorPaneCadastroClienteDialogController controller = loader.getController();
        controller.setDialogStage(dialogStage);
        controller.setCliente(cliente);
        
        //apresenta o diálogo e aguarda a confirmação do usuário
        dialogStage.showAndWait();
        
        return controller.isBtConfirmarClicked();
    }
    
}
