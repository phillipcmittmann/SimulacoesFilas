package com.company;

public class Main {
    public static void main(String[] args) {
        int qtdExecucoes = 100000;
        double tempoAtual = 0.0000;
        double[] intervaloAtendimento = new double[]{2.0, 4.0};

        Escalonador escalonador = new Escalonador(3, 11, 4, 7);
        Fila fila = new Fila(5);

        // AGENDAR PRIMEIRA CHEGADA
        escalonador.calculaEvento(TipoEvento.CHEGADA, new double[]{0.0, 3.0}, tempoAtual, fila);
        escalonador.calcularSemente();

        while (qtdExecucoes > 0) {
            if (fila.getTamanhoAtual() < fila.getCapacidade()) {
                fila.setTamanhoAtual(fila.getTamanhoAtual() + 1);

                if (fila.getTamanhoAtual() <= 1) {
                    // agenda saida
                    escalonador.calculaEvento(TipoEvento.SAIDA, intervaloAtendimento, tempoAtual, fila);
                    fila.setTamanhoAtual(fila.getTamanhoAtual() - 1);
                }

                // agenda chegada
                escalonador.calcularSemente();
                escalonador.calculaEvento(TipoEvento.CHEGADA, intervaloAtendimento, tempoAtual, fila);
                qtdExecucoes++;
            }
        }
    }
}
