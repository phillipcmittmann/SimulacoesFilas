package com.company;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int qtdExecucoes = 0;
        double[] intervaloAtendimento = new double[]{2.0, 4.0};

        Scanner reader = new Scanner(System.in);

        // Inicializacao do ambiente
        System.out.println("Digite o valor de A:");
        int valorA = reader.nextInt();

        System.out.println("Digite o valor de M:");
        int valorM = reader.nextInt();

        System.out.println("Digite o valor de C:");
        int valorC = reader.nextInt();

        System.out.println("Digite o valor da semente:");
        int semente = reader.nextInt();

        System.out.println("Digite a capacidade da fila:");
        int capacidade = reader.nextInt();

        System.out.println("Digite a quantidade de execucoes:");
        int execucoes = reader.nextInt();

        Escalonador escalonador = new Escalonador(valorA, valorM, valorC, semente);
        Fila fila = new Fila( capacidade + 1, intervaloAtendimento);

        // Agenda primeira chegada, populando a fila
        escalonador.calcularSemente();
        escalonador.agendaChegadaInicial(intervaloAtendimento[0]);

        // Execucao da simulacao
        while (qtdExecucoes < execucoes) {
            escalonador.executa(fila);

            qtdExecucoes++;
        }

        // Mostra na tela o tempo e quantidade de clientes que a fila teve ao longo da execucao
        for (int i = 0; i < fila.getCapacidade(); i++) {
            System.out.println("Quantidade " + i + " - Tempo total: " + fila.getEstado()[i]);
        }

        System.out.println("Perdas: " + escalonador.getPerdidos());
    }
}