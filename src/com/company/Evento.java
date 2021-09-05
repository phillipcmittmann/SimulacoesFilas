package com.company;

public class Evento {
    private TipoEvento tipoEvento;
    private double tempoExecucao;

    public Evento(TipoEvento tipoEvento, double tempoExecucao) {
        this.tipoEvento = tipoEvento;
        this.tempoExecucao = tempoExecucao;
    }

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
}
