package org.example.projcrudpoo.dao;

import org.example.projcrudpoo.model.Tarefa;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class TarefaDBDAO extends GenericaDAO implements IConst, TarefaDAO{
    private String sql;
    private PreparedStatement statement;
    private ResultSet result;

    @Override
    public void insere(Tarefa tarefa) throws SQLException {
        open();
        sql = "INSERT INTO tarefa (titulo, descricao, status, id_usuario) VALUES (?,?,?,?)";
        statement = connection.prepareStatement(sql);
        statement.setString(1,tarefa.getTitulo());
        statement.setString(2,tarefa.getDescricao());
        statement.setString(3,tarefa.getStatus());
        statement.setInt(4,tarefa.getIdUsuario());

        statement.executeUpdate();

        close();
    }

    @Override
    public void atualiza(Tarefa tarefa) throws SQLException {
        open();
        sql = "UPDATE tarefa SET titulo=?, descricao=? WHERE id = ?";
        statement = connection.prepareStatement(sql);

        statement.setString(1,tarefa.getTitulo());
        statement.setString(2, tarefa.getDescricao());
        statement.setInt(3,tarefa.getId());
        statement.executeUpdate();

        close();
    }

    @Override
    public void remove(Tarefa tarefa) throws SQLException {
        open();
        sql = "DELETE FROM tarefa WHERE id = ?;";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,tarefa.getId());
        statement.executeUpdate();
        close();
    }

    @Override
    public ArrayList<Tarefa> listTodos(int idUsuario) throws SQLException {
        open();
        sql = "SELECT * FROM tarefa WHERE id_usuario = ? ;";
        statement = connection.prepareStatement(sql);
        statement.setInt(1,idUsuario);
        result = statement.executeQuery();

        ArrayList<Tarefa> tarefas = new ArrayList<>();

        while(result.next()){
            Tarefa tarefa = new Tarefa();
            tarefa.setTitulo(result.getString("titulo"));
            tarefa.setDescricao(result.getString("descricao"));
            tarefa.setStatus(result.getString("status"));
            tarefa.setId(result.getInt("id"));

            tarefas.add(tarefa);
        }
        close();

        return tarefas;
    }

    @Override
    public void marcarComoConcluida(Tarefa tarefa) throws SQLException {
        open();
        sql = "UPDATE tarefa SET status=? WHERE id = ?;";
        statement = connection.prepareStatement(sql);
        statement.setString(1,tarefa.getStatus());
        statement.setInt(2,tarefa.getId());
        statement.executeUpdate();
        close();
    }
}
