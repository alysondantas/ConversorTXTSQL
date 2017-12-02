/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversortxtsql;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 *
 * @author alyso
 */
public class Controler {

    private String caminho = "";

    public void setcaminho(String str) {
        this.caminho = str;
        DAO.setArqSaida("povoamento.sql");
    }

    public void lerlinha() {
        try {
            FileReader arq = new FileReader(caminho);
            BufferedReader lerArq = new BufferedReader(arq);

            String linha = lerArq.readLine(); 
            String primeiro;
            boolean emQuestao = false;
            boolean txtQ = false;
            boolean txtE = false;
            boolean txtR = false;
            Questao questao = null;
            while (linha != null) {
                
                System.out.println(" o conteudo da linha é " + linha);
                if(!linha.equals("")){
                    primeiro = linha.substring(0,1);
                }else{
                    System.out.println("Vazio");
                    primeiro = "";
                }
                System.out.println("O conteudo do primeiro caractere é " + primeiro);
                if (primeiro.equals("$")) {
                    System.out.println("uma questao");
                    txtQ = true;
                    txtE = false;
                    txtR = false;
                    if(emQuestao == true){
                        System.out.println("nova questao");
                        emQuestao = false;
                        salvaSQL(questao);
                    }
                    questao = new Questao();
                    questao.setNome(linha.replace("$", ""));
                } else if (primeiro.equals("#")) {
                    System.out.println("um enunciado");
                    txtQ = false;
                    txtR = false;
                    txtE = true;
                }else if(primeiro.equals("&")){
                    System.out.println("uma resposta");
                    txtQ = false;
                    txtE = false;
                    txtR = true;
                    questao.incrementaCont();
                }else if(primeiro.equals("§")){
                    System.out.println("a resposta correta deve dar erro a seguir");
                    questao.setRespostaCorreta(linha.replace("§", "").trim());
                    txtQ = false;
                    txtE = false;
                    txtR = false;
                    emQuestao = true;
                    //salvaSQL(questao);
                    //questao = new Questao();
                }
                
                if(txtQ == true){
                    questao.setNome(linha.replace("$", ""));
                }else if(txtE == true){
                    System.out.println("uma parte do enunciado add");
                    questao.setEnunciado(linha.replace("#", ""));
                }else if(txtR = true){
                    System.out.println("Add uma questao");
                    if(questao.getCont() == 1){
                        System.out.println("1 resposta");
                        questao.setRespostaA(linha.replace("&", ""));
                    }else if(questao.getCont() == 2){
                        System.out.println("2 resposta");
                        questao.setRespostaB(linha.replace("&", ""));
                    }else if(questao.getCont() == 3){
                        System.out.println("3 resposta");
                        questao.setRespostaC(linha.replace("&", ""));
                    }else if(questao.getCont() == 4){
                        System.out.println("4 resposta");
                        questao.setRespostaD(linha.replace("&", ""));
                    }else if(questao.getCont() == 5){
                        System.out.println("5 resposta");
                        questao.setRespostaE(linha.replace("&", ""));
                    }else{
                        System.out.println("Algo de errado em inserir resposta");
                    }
                }else{
                    System.out.println("Erro " + "Questao:" + txtQ + " Enunciado:" + txtE + " Resposta:" + txtR + "|" + questao.getCont());
                }
                
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }
            salvaSQL(questao);

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: Faz isso comigo não carai\n",
                    e.getMessage());
        }

        System.out.println();
    }
    
    private void salvaSQL(Questao questao){
        DAO.gerarInsert(questao);
    }
}
