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
                    if(emQuestao == true){
                        emQuestao = false;
                        salvaSQL(questao);
                        emQuestao = true;
                    }
                    questao = new Questao();
                    questao.setNome(linha);
                } else if (primeiro.equals("#")) {
                    txtQ = false;
                    txtE = true;
                    txtR = false;
                }else if(primeiro.equals("&")){
                    txtQ = false;
                    txtE = false;
                    txtR = true;
                }else if(primeiro.equals("§")){
                    questao.setRespostaCorreta(linha.replace("§", "").trim());
                    txtQ = false;
                    txtE = false;
                    txtR = false;
                    emQuestao = false;
                }
                
                if(txtQ == true){
                    questao.setNome(linha.replace("#", ""));
                }
                
                linha = lerArq.readLine(); // lê da segunda até a última linha
            }

            arq.close();
        } catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: Faz isso comigo não carai\n",
                    e.getMessage());
        }

        System.out.println();
    }
    
    private void salvaSQL(Questao questao){
        
    }
}
