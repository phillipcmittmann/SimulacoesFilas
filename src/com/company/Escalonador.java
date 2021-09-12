package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Escalonador{
    private int valorA;
    private int valorM;
    private int valorC;
    private double semente;
    double tempoAtual;
    double ultimoEvento;
    public ArrayList<Evento> eventos = new ArrayList<>();

    private int perdidos;

    public Escalonador(int valorA, int valorM, int valorC, int sementeInicial) {
        this.valorA = valorA;
        this.valorM = valorM;
        this.valorC = valorC;
        this.semente = sementeInicial;
        this.tempoAtual = 0.0D;
        this.ultimoEvento = 0.0D;
    }

    // Execucao da simulacao
    public void executa(Fila fila) {
        Evento evento = eventos.remove(0);

        this.ultimoEvento = this.tempoAtual;
        this.tempoAtual = evento.getTempoExecucao();

        if (evento.getTipoEvento() == TipoEvento.CHEGADA) {
            fila.chegada(this);
        }

        if (evento.getTipoEvento() == TipoEvento.SAIDA) {
            fila.saida(this);
        }
    }

    // Calcula o proximo numero aleatorio, de acordo com os valores fornecidos
    public void calcularSemente() {
        double novaSemente = ((getValorA() * getSemente()) + getValorC()) % getValorM();

        setSemente(novaSemente);
    }

    public void agendaChegadaInicial(double delay) {
        Evento evento = new Evento();
        evento.setTempoExecucao(delay);
        evento.setTipoEvento(TipoEvento.CHEGADA);

        eventos.add(evento);
    }

    // Agenda a chegada de um cliente na fila
    public void agendaChegada(Fila fila) {
        this.calcularSemente();
        Evento evento = new Evento();
        evento.setTempoExecucao(this.calculaDelay(fila));
        evento.setTipoEvento(TipoEvento.CHEGADA);

        eventos.add(evento);
        Collections.sort(eventos, Comparator.comparing(Evento::getTempoExecucao));
    }

    // Agenda a saida de um cliente da fila
    public void agendaSaida(Fila fila) {
        this.calcularSemente();
        Evento evento = new Evento();
        evento.setTempoExecucao(this.calculaDelay(fila));
        evento.setTipoEvento(TipoEvento.SAIDA);

        eventos.add(evento);
        Collections.sort(eventos, Comparator.comparing(Evento::getTempoExecucao));
    }

    // Calcula o tempo que o cliente leva sair da fila
    public double calculaDelay(Fila fila) {
        return ((fila.getIntervaloAtendimento()[1] - fila.getIntervaloAtendimento()[0]) * getSemente() + fila.getIntervaloAtendimento()[0]) + this.tempoAtual;
    }

    // Calcula o tempo em relacao a quantidade de clientes na fila
    public void contabilizaTempo(Fila fila) {
        double[] estadoFila = fila.getEstado();

        estadoFila[fila.getTamanhoAtual()] = this.tempoAtual - this.ultimoEvento;

        fila.setEstado(estadoFila);

        this.ultimoEvento = this.tempoAtual;
    }
    
    public double getValorA() {
        return valorA;
    }

    public void setValorA(int valorA) {
        this.valorA = valorA;
    }

    public int getValorM() {
        return valorM;
    }

    public void setValorM(int valorM) {
        this.valorM = valorM;
    }

    public double getValorC() {
        return valorC;
    }

    public void setValorC(int valorC) {
        this.valorC = valorC;
    }

    public double getSemente() {
        return semente;
    }

    public void setSemente(double semente) {
        this.semente = semente;
    }

    public int getPerdidos() {
        return perdidos;
    }

    public void setPerdidos(int perdidos) {
        this.perdidos = perdidos;
    }
}
