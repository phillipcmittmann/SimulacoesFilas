package com.company;

public class Evento implements Comparable<Evento>, Cloneable {
    private TipoEvento tipoEvento;
    private double tempoExecucao;

    public Evento() { }

    public TipoEvento getTipoEvento() {
        return tipoEvento;
    }

    public void setTipoEvento(TipoEvento tipoEvento) {
        this.tipoEvento = tipoEvento;
    }

    public double getTempoExecucao() {
        return tempoExecucao;
    }

    public void setTempoExecucao(double tempoExecucao) {
        this.tempoExecucao = tempoExecucao;
    }

    @Override
    public int compareTo(Evento o) {
        return 0;
    }
}
