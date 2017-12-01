/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package conversortxtsql;

/**
 *
 * @author alyso
 */
public class Questao {
    private String nome;
    private String enunciado;
    private String respostaA;
    private String respostaB;
    private String respostaC;
    private String respostaD;
    private String respostaE;
    private String respostaCorreta;
    private int cont;
    
    public Questao(){
        nome = "";
        enunciado = "";
        respostaA = "";
        respostaB = "";
        respostaC = "";
        respostaD = "";
        respostaE = "";
        respostaCorreta = "";
        cont = 0;
    }
    
    public int getCont(){
        return cont;
    }
    
    public void incrementaCont(){
        cont++;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = this.nome + nome;
    }

    public String getEnunciado() {
        return enunciado;
    }

    public void setEnunciado(String enunciado) {
        this.enunciado = this.enunciado + enunciado;
    }

    public String getRespostaA() {
        return respostaA;
    }

    public void setRespostaA(String respostaA) {
        this.respostaA = this.respostaA + respostaA;
    }

    public String getRespostaB() {
        return respostaB;
    }

    public void setRespostaB(String respostaB) {
        this.respostaB = this.respostaB + respostaB;
    }

    public String getRespostaC() {
        return respostaC;
    }

    public void setRespostaC(String respostaC) {
        this.respostaC = this.respostaC + respostaC;
    }

    public String getRespostaD() {
        return respostaD;
    }

    public void setRespostaD(String respostaD) {
        this.respostaD = this.respostaD + respostaD;
    }

    public String getRespostaE() {
        return respostaE;
    }

    public void setRespostaE(String respostaE) {
        this.respostaE = this.respostaE + respostaE;
    }

    public String getRespostaCorreta() {
        return respostaCorreta;
    }

    public void setRespostaCorreta(String respostaCorreta) {
        this.respostaCorreta = respostaCorreta;
    }
    
    
    
}
