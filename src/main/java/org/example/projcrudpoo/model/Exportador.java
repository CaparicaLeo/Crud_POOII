package org.example.projcrudpoo.model;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ArrayList;

public class Exportador {
    /*
        2° Refatoração
        Autor: Leonardo Caparica
        Criação de atributo estático para pasta de relatorio.
        Objetivo: para melhor manutenabilidade para a criação dos relatorios
     */

    private static final String pasta = "C:\\Users\\Pardal\\Faculdade\\TRABALHO_POOII\\Relatorios";

    public String getPasta() {
        return pasta;
    }


    // Método para exportar as tarefas para um arquivo TXT
    public boolean exportar(ArrayList<Tarefa> tarefas, Usuario usuarioAtual) {
        // Definir a pasta onde o arquivo será salvo// Pasta relativa ao diretório onde o programa está sendo executado
        File pasta = new File(getPasta());

        // Gerar o nome do arquivo com o nome do usuário e a data/hora
        String nomeArquivo = pasta + "/Relatorio_tarefas_" + usuarioAtual.getNome() + "_" +
                obterDataHoraAtual() + ".txt";

        // Tentar escrever no arquivo
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nomeArquivo))) {
            writer.write("RELATORIO DE TAREFAS");
            writer.newLine();
            writer.write("DATA: " + mostrarData());
            writer.newLine();
            writer.write("USUARIO: " + usuarioAtual.getNome());
            writer.newLine();
            writer.write("=====================");
            writer.newLine();

            writer.write("-------------TAREFAS-------------");
            writer.newLine();

            // Escrever os detalhes das tarefas
            for (Tarefa tarefa : tarefas) {
                writer.write("=====================");
                writer.newLine();
                writer.write("ID: " + tarefa.getId());
                writer.newLine();
                writer.write("Titulo: " + tarefa.getTitulo());
                writer.newLine();
                writer.write("Descrição: " + tarefa.getDescricao());
                writer.newLine();
                writer.write("Status: " + tarefa.getStatus());
                writer.newLine();
            }
            writer.write("=====================");
            writer.newLine();
            return true;
        } catch (IOException e) {
            // Em caso de erro, retorna false
            return false;
        }
    }

    // Método para obter a data e hora atual no formato desejado
    private String obterDataHoraAtual() {
        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy_HHmmss");
        return sdf.format(new Date());
    }

    private String mostrarData() {
        String dataHora = obterDataHoraAtual();
        String data = "";

        data += dataHora.substring(0, 2);
        data += "/";
        data += dataHora.substring(2, 4);
        data += "/";
        data += dataHora.substring(4, 8);

        return data;
    }

}
