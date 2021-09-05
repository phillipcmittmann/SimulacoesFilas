package com.company;

public class Escalonador {
    private int valorA;
    private int valorM;
    private int valorC;
    private int semente;

    public Escalonador(int valorA, int valorM, int valorC, int sementeInicial) {
        this.valorA = valorA;
        this.valorM = valorM;
        this.valorC = valorC;
        this.semente = sementeInicial;
    }

    public void calcularSemente() {
        int novaSemente = ((getValorA() * getSemente()) + getValorC()) % getValorM();

        setSemente(novaSemente);
    }

    public void calculaEvento(TipoEvento tipoEvento, double[] intervaloAtendimento, double tempoAtual, Fila fila) {
        fila.getEventos().add(new Evento(tipoEvento, (((intervaloAtendimento[1] - intervaloAtendimento[0]) * getSemente()) + intervaloAtendimento[0]) + tempoAtual));
    }
    
    public int getValorA() {
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

    public int getValorC() {
        return valorC;
    }

    public void setValorC(int valorC) {
        this.valorC = valorC;
    }

    public int getSemente() {
        return semente;
    }

    public void setSemente(int semente) {
        this.semente = semente;
    }
}
