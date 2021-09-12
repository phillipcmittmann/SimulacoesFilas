package com.company;

import java.util.Arrays;

public class Fila {

    private int tamanhoAtual;
    private int capacidade;
    private double[] estado;
    double[] intervaloAtendimento;

    public Fila(int capacidade, double[] intervaloAtendimento) {
        this.tamanhoAtual = 0;
        this.capacidade = capacidade;
        this.estado = new double[capacidade];

        Arrays.fill(estado, 0.0);

        this.intervaloAtendimento = intervaloAtendimento;
    }

    public void chegada(Escalonador escalonador) {
        escalonador.contabilizaTempo(this);

        if (this.tamanhoAtual >= capacidade) {
            escalonador.setPerdidos(escalonador.getPerdidos() + 1);
        } else {
            this.tamanhoAtual++;

            if (this.tamanhoAtual <= 1) {
                escalonador.agendaSaida(this);
            }

            escalonador.agendaChegada(this);
        }
    }

    public void saida(Escalonador escalonador) {
        escalonador.contabilizaTempo(this);

        this.setTamanhoAtual(this.getTamanhoAtual() - 1);
        if (this.getTamanhoAtual() >= 1) {
            escalonador.agendaSaida(this);
        }
    }

    public int getTamanhoAtual() {
        return tamanhoAtual;
    }

    public void setTamanhoAtual(int tamanhoAtual) {
        this.tamanhoAtual = tamanhoAtual;
    }

    public int getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(int capacidade) {
        this.capacidade = capacidade;
    }

    public double[] getEstado() {
        return estado;
    }

    public void setEstado(double[] estado) {
        this.estado = estado;
    }

    public double[] getIntervaloAtendimento() {
        return intervaloAtendimento;
    }

    public void setIntervaloAtendimento(double[] intervaloAtendimento) {
        this.intervaloAtendimento = intervaloAtendimento;
    }
}
