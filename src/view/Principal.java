/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class Principal {

    public static void main(String[] args) {
        String resp = "";
        do {
            exibirMenu();
            resp = scanf();
        } while (!resp.equals("0"));
    }

    public static void exibirMenu() {
        System.out.println("MENU");
        System.out.println("1 - Ler arquivo de texto e criar SQL\n"
                + "0 - Sair da aplicação\n"
                + "3 - Entrar no facebook");
    }
    
    private static void escolherAcao(String resp){
        switch (resp) {
            case "1":
                break;
            case "3":
                System.out.println("Função ainda não implementada. Aguarde proximas versões");
                break;
            case "4":
                System.out.println("OI");
                break;
            default:
                break;
        }
    }

    private static String scanf() {
        return new Scanner(System.in).nextLine();
    }
}
