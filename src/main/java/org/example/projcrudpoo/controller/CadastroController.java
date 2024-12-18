package org.example.projcrudpoo.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import org.example.projcrudpoo.dao.UsuarioDBDAO;
import org.example.projcrudpoo.model.Usuario;

import java.io.IOException;
import java.sql.SQLException;

public class CadastroController {

    @FXML
    private TextField emailField;
    @FXML
    private PasswordField passwordField;
    @FXML
    private TextField usernameField;
    @FXML
    void cadastrar(ActionEvent event) throws SQLException {
        Usuario usuario = new Usuario(emailField.getText(),usernameField.getText(),passwordField.getText());
        UsuarioDBDAO usuarioDAO = new UsuarioDBDAO();
        usuarioDAO.cadastrar(usuario);
        alertaSucesso("Usuário cadastrado com sucesso!");
    }

    @FXML
    void voltarLogin(ActionEvent event) throws IOException {
        FXMLLoader loader= new FXMLLoader(retornaCaminho());
        Parent login = loader.load();

        Stage stage = (Stage) usernameField.getScene().getWindow();

        stage.setScene(new Scene(login));
        stage.setTitle("Login - Gerenciador de Tarefas");
        stage.show();
    }
    /*
        1 Refatoração
        Autor: Leonardo Caparica
        Uso de metodo para retornar caminho da pasta para carregamento do LoginView.fxml
        Objetivo: Facilitar mudanças do código caso necessário
     */
    private java.net.URL retornaCaminho(){
        return this.getClass().getResource("/org/example/projcrudpoo/view/LoginView.fxml");
    }

    /*
        3 Refatoração
        Autor: Leonardo Caparica
        Uso de metodo para imprimir a mensagem de erro
        Objetivo: Facilitar leitura do codigo
     */
    public void alertaSucesso(String mensagem){
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Sucesso");
        alert.setHeaderText(null);
        alert.setContentText(mensagem);
        alert.showAndWait();
    }


}
