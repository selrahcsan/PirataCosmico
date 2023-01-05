package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    public static final int Tentativas = 6;
    public static final int TamanhoTela = 10;
    public static String Nome;
    public static Scanner EntradaDados = new Scanner(System.in);
    public static int PosicaoXEltron;
    public static int PosicaoYEltron;
    public static int DistanciaEltron;
    public static int PosicaoXJogador;
    public static int PosicaoYJogador;
    public static int DistanciaJogador;
    public static void main(String[] args) {
        MenuInicial();
        Jogadas();
    }

    public static void MenuInicial(){
        System.out.println("Pirata Cósmico");
        System.out.println("Qual o seu nome: ");
        Nome = EntradaDados.nextLine();
        System.out.println("Olá " + Nome +" você tem " + Tentativas + "  tentativas para ganhar!");
        PosicaoEltron();
    }

    public static void PosicaoEltron(){
        Random GeraNumAleatorio = new Random();

        PosicaoXEltron = GeraNumAleatorio.nextInt(TamanhoTela);
        System.out.println(PosicaoXEltron);

        PosicaoYEltron = GeraNumAleatorio.nextInt(TamanhoTela);
        System.out.println(PosicaoYEltron);

        DistanciaEltron = GeraNumAleatorio.nextInt(TamanhoTela);
        System.out.println(DistanciaJogador);
    }
    public static void Jogadas(){

        for (var jogada = 1; jogada <= Tentativas; jogada++){
            System.out.println();
            System.out.println("Tentativa n°:" + jogada);

            String respostaTemp;
            do {
                System.out.println(Nome + ", Escolha uma Posição X (0 a 9) ");
                respostaTemp = EntradaDados.nextLine();
                if (EhNumero(respostaTemp))
                    PosicaoXJogador = Integer.parseInt(respostaTemp);
                else
                    System.out.println("Digite um valor Válido (0 a 9)" );
            }while (PosicaoXJogador == 0);

            do{
                System.out.println(Nome+", Escolha uma Posição Y (0 a 9) ");
                respostaTemp = EntradaDados.nextLine();
                if (EhNumero(respostaTemp))
                    PosicaoYJogador = Integer.parseInt(respostaTemp);
                else
                    System.out.println("Digite um valor Válido (0 a 9)" );
            }while (PosicaoYJogador == 0);


            System.out.println(Nome+", Escolha uma Distancia (0 a 9) ");
            DistanciaJogador = EntradaDados.nextInt();

            if (PosicaoXEltron == PosicaoXJogador && PosicaoYEltron == PosicaoYJogador && DistanciaEltron == DistanciaJogador){
                JogadorGanhou();
                break;
            }

            System.out.print(Nome + ", seu tiro ");

            System.out.println((PosicaoYEltron < PosicaoYJogador) ? "X: Norte " : "X: Sul");
            System.out.println((PosicaoXEltron < PosicaoXJogador) ? "Y:Leste " : "Y:Oeste");
            System.out.println((DistanciaEltron < DistanciaJogador) ? "Distancia: Muito Longe" : "Distancia: Muito Perto");
        }
        JogadorPerdeu();
    }
    public static void JogadorGanhou(){
        System.out.println("Parabens " + Nome +" Voce Ganhou !!");
    }
    public static void JogadorPerdeu(){
        System.out.println("Infelizmente, " + Nome +" Voce Perdeu !!");
    }
    private static boolean EhNumero(String resposta) {
        return resposta != null && resposta.matches("[0-9]*");
    }

}