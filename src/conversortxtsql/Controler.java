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
        System.out.printf("\nConteúdo do arquivo texto:\n");
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
                System.out.printf("\n" + linha);
                primeiro = linha.substring(0);
                if (primeiro.equals("$")) {
                    System.out.println("uma questao");
                    if(emQuestao == true){
                        System.out.println("nova questao");
                        emQuestao = false;
                        salvaSQL(questao);
                        emQuestao = true;
                    }
                    questao = new Questao();
                    questao.setNome(linha);
                } else if (primeiro.equals("#")) {
                    System.out.println("um enunciado");
                    txtQ = false;
                    txtE = true;
                    txtR = false;
                }else if(primeiro.equals("&")){
                    System.out.println("uma resposta");
                    txtQ = false;
                    txtE = false;
                    txtR = true;
                    questao.incrementaCont();
                }else if(primeiro.equals("§")){
                    System.out.println("a resposta correta");
                    questao.setRespostaCorreta(linha.replace("§", "").trim());
                    txtQ = false;
                    txtE = false;
                    txtR = false;
                }
                
                if(txtQ == true){
                    questao.setNome(linha.replace("$", ""));
                }else if(txtR = true){
                    if(questao.getCont() == 1){
                        System.out.println("1 questao");
                        questao.setRespostaA(linha.replace("&", ""));
                    }else if(questao.getCont() == 2){
                        System.out.println("2 questao");
                        questao.setRespostaB(linha);
                    }else if(questao.getCont() == 3){
                        System.out.println("3 questao");
                        questao.setRespostaC(linha);
                    }else if(questao.getCont() == 4){
                        System.out.println("4 questao");
                        questao.setRespostaD(linha);
                    }else if(questao.getCont() == 5){
                        System.out.println("5 questao");
                        questao.setRespostaE(linha);
                    }else{
                        System.out.println("Algo de errado em inserir questao");
                    }
                }else if(txtE == true){
                    System.out.println("um enunciado add");
                    questao.setEnunciado(linha.replace("#", ""));
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
