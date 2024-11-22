package org.example.projcrudpoo.dao;

import org.example.projcrudpoo.model.Usuario;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;


public class UsuarioDBDAO extends GenericaDAO implements UsuarioDAO, IConst {
    private String sql;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void cadastrar(Usuario usuario) throws SQLException {
        open();
        sql = "INSERT INTO usuario (nome,email,senha) VALUES (?,?,?);";
        statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getEmail());
        statement.setString(3, usuario.getSenha());
        statement.executeUpdate();
        close();
        
    }
    @Override
    public boolean verificarEntrada(Usuario usuario) throws SQLException {
        open();
        sql = "SELECT * FROM usuario WHERE nome = ? AND senha = ?;";
        statement = connection.prepareStatement(sql);
        statement.setString(1, usuario.getNome());
        statement.setString(2, usuario.getSenha());

        result = statement.executeQuery();

        close();
        // Se a consulta retornar um registro, o login é válido.
        return result.next();
    }

    public int buscaId(Usuario usuario) throws SQLException {
        int id = -1;  // Inicializa com um valor padrão indicando "não encontrado"
        open();  // Abre a conexão

        try {
            sql = "SELECT id FROM usuario WHERE nome = ? AND senha = ?;";
            statement = connection.prepareStatement(sql);
            statement.setString(1, usuario.getNome());
            statement.setString(2, usuario.getSenha());

            result = statement.executeQuery();

            // Move o cursor para a primeira linha
            if (result.next()) {
                id = result.getInt("id");  // Obtém o ID
            }
        } finally {
            close();  // Fecha a conexão, independente do que aconteceu
        }

        return id;  // Retorna o ID encontrado ou -1 se não encontrado
    }


    public UsuarioDBDAO(){
    }
}
