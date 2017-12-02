/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import conversortxtsql.Controler;
import java.util.Scanner;

/**
 *
 * @author marcos
 */
public class Principal {
    static Controler controller;

    public static void main(String[] args) {
        String resp = "";
        do {
            exibirMenu();
            resp = scanf();
            escolherAcao(resp);
        } while (!resp.equals("0"));
    }

    public static void exibirMenu() {
        System.out.println("MENU");
        System.out.println("1 - Adicionar caminho\n"
                + "2 - Ler arquivo de texto e criar SQL\n"
                + "3 - Entrar no facebook\n"
                + "0 - Sair da aplicação");
    }

    private static void escolherAcao(String resp) {
        switch (resp) {
            case "1":
                System.out.println("Caminho: ");
                String cm = scanf();
                controller.setcaminho(cm);
                System.out.println("Caminho adicionado: " +cm);
                break;
            case "2":
                System.out.println("Iniciando leitura...");
                controller.lerlinha();
                break;
            case "3":
                System.out.println("Função ainda não implementada. Aguarde próximas versões");
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
