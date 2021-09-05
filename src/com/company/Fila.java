package com.company;

import java.util.ArrayList;

public class Fila {

    private int tamanhoAtual;
    private int capacidade;
    private double[] estado;
    ArrayList<Evento> eventos;

    public Fila(int capacidade) {
        this.tamanhoAtual = 0;
        this.capacidade = capacidade;
        this.estado = new double[capacidade];
        this.eventos = new ArrayList<>();
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

    public ArrayList<Evento> getEventos() {
        return eventos;
    }

    public void setEventos(ArrayList<Evento> eventos) {
        this.eventos = eventos;
    }
}
