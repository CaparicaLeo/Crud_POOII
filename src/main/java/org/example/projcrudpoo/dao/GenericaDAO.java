package org.example.projcrudpoo.dao;

import java.sql.Connection;
import java.sql.SQLException;

/*
    3° Refatoração
    Autor: Leonardo Caparica
    Generalização das classes DBDAO
    Objetivo: Encapsular e gerar herança nos metodos de abertura e fechamento do banco de dados
    para melhor flexibilidade em caso de modificações
 */

public class GenericaDAO implements IConst {
    protected Connection connection;
    protected void open() throws SQLException {
        connection = Conexao.getConexao(Conexao.stringDeConexao, Conexao.usuario, Conexao.senha);
    }
    protected void close() throws SQLException {
        connection.close();
    }
}
