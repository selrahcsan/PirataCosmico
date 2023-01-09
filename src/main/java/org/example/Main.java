package org.example;

import java.util.Random;
import java.util.Scanner;

public class Main {
    private static final int _tentativas = 6;
    private static final int _tamanhoTela = 10;
    private static String _nome;
    private static final Scanner _entradaDados = new Scanner(System.in);
    private static int _posicaoXEltron;
    private static int _posicaoYEltron;
    private static int _distanciaEltron;
    private static int _posicaoXJogador;
    private static int _posicaoYJogador;
    private static int _distanciaJogador;

    public static void main(String[] args) {
        MenuInicial();
        Jogadas();
    }

    private static void MenuInicial(){
        System.out.println("Pirata Cósmico");
        String respostaTemp;
        do {
            System.out.print("Qual é o seu nome: ");
            respostaTemp = _entradaDados.nextLine();
            if (NomeEhValido(respostaTemp))
                _nome = respostaTemp;
            else
                System.out.println("Nome, deve ter mais de 3 Caracteres!");
        }while (!NomeEhValido(respostaTemp));

        System.out.println("Olá " + _nome +" você tem " + _tentativas + "  tentativas para ganhar!");
        PosicaoEltron();
    }

    private static void PosicaoEltron(){
        Random GeraNumAleatorio = new Random();

        _posicaoXEltron = GeraNumAleatorio.nextInt(_tamanhoTela);
        _posicaoYEltron = GeraNumAleatorio.nextInt(_tamanhoTela);
        _distanciaEltron = GeraNumAleatorio.nextInt(_tamanhoTela);

    }
    private static void Jogadas(){

        int _jogadas;
        for (_jogadas = 0; _jogadas <= _tentativas; _jogadas++){
            System.out.println();
            System.out.println("Tentativa n°:" + _jogadas);

            String respostaTemp;
            do {
                System.out.println(_nome + ", Escolha uma Posição X (0 a 9) ");
                respostaTemp = _entradaDados.nextLine();
                if (EhNumero(respostaTemp))
                    _posicaoXJogador = Integer.parseInt(respostaTemp);
                else
                    System.out.println("Digite um valor Válido (0 a 9)" );
            }while (!EhNumero(respostaTemp));

            do{
                System.out.println(_nome +", Escolha uma Posição Y (0 a 9) ");
                respostaTemp = _entradaDados.nextLine();
                if (EhNumero(respostaTemp))
                    _posicaoYJogador = Integer.parseInt(respostaTemp);
                else
                    System.out.println("Digite um valor Válido (0 a 9)" );
            }while (!EhNumero(respostaTemp));

            do{
                System.out.println(_nome +", Escolha uma Distancia (0 a 9) ");
                respostaTemp = _entradaDados.nextLine();
                if (EhNumero(respostaTemp))
                    _distanciaJogador = Integer.parseInt(respostaTemp);
                else
                    System.out.println("Digite um valor Válido (0 a 9)" );
            }while (!EhNumero(respostaTemp));

            if (_posicaoXEltron == _posicaoXJogador && _posicaoYEltron == _posicaoYJogador && _distanciaEltron == _distanciaJogador){
                JogadorGanhou();
                break;
            }

            System.out.print(_nome + ", seu tiro ");

            System.out.println((_posicaoYEltron < _posicaoYJogador) ? "X: Norte " : "X: Sul");
            System.out.println((_posicaoXEltron < _posicaoXJogador) ? "Y:Leste " : "Y:Oeste");
            System.out.println((_distanciaEltron > _distanciaJogador) ? "Distancia: Muito Longe" : "Distancia: Muito Perto");
        }
        JogadorPerdeu();
    }
    private static void JogadorGanhou(){
        System.out.println("Parabens " + _nome +" Voce Ganhou !!");
    }
    private static void JogadorPerdeu(){
        System.out.println("Infelizmente, " + _nome +" Voce Perdeu !!");
    }
    private static boolean EhNumero(String resposta) {
        return resposta != null && resposta.matches("[0-9]*");
    }
    private static boolean NomeEhValido(String nome){
        return nome.length() > 3;
    }
}