package org.example.projcrudpoo.main;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Principal extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        // Carregar o arquivo FXML
        FXMLLoader loader = new FXMLLoader(carregarPagina());
        Parent root = loader.load();
        // Configurar a cena
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Login - Gerenciador de Tarefas");
        primaryStage.setResizable(false);
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args); // Inicia a aplicação JavaFX
    }

    /* 1 Refatoração
        Autor: Leonardo Caparica
        Criação de metodo para o carregamento da view
        Objetivo: Facilitar edição do caminho caso necessária alteração futura
     */
    private java.net.URL carregarPagina(){
        return this.getClass().getResource("/org/example/projcrudpoo/view/LoginView.fxml");
    }
}