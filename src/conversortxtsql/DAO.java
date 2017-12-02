/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversortxtsql;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author marcos
 */
public class DAO {

    private static BufferedWriter buffWrite;

    public static void gerarInsert(Questao q) {
        String query = gerarQuery(q);
        escreverArquivo(query, q.getNome());
    }

    private static String gerarQuery(Questao q) {
        String qu = "INSERT INTO public.questao (idusuario,"
                + "idprova,"
                + "idareaconhecimento,"
                + "enunciado,"
                + "questaooficial,"
                + "respostaa,"
                + "respostab,"
                + "respostac,"
                + "respostad,"
                + "respostae,"
                + "respostacorreta) VALUES(' ',' ','" + q.getEnunciado() + "',"
                + "'OFICIAL','" + q.getRespostaA() + "',"
                + "'" + q.getRespostaB() + "',"
                + "'" + q.getRespostaC() + "',"
                + "'" + q.getRespostaD() + "',"
                + "'" + q.getRespostaE() + "',"
                + "'" + q.getRespostaCorreta() + "');";

        return qu;
    }

    private static void escreverArquivo(String text, String nomeQuestao) {
        if (buffWrite == null) {
            System.out.println("Coloque o arquivo de saida primeiro");
            return;
        }
        try {
            buffWrite.append("-------------------------------- BEGIN " + nomeQuestao+" --------------------------------\n");
            buffWrite.append(text + "\n");
            buffWrite.append("-------------------------------- END " + nomeQuestao+" --------------------------------\n\n");
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void setArqSaida(String arq) {
        try {
            buffWrite = new BufferedWriter(new FileWriter(arq));
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void closeFile() {
        try {
            buffWrite.close();
        } catch (IOException ex) {
            Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
