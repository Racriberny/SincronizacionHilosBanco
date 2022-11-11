package com.cristobalbernal.SincronizacionHilosBancoEjecucion;

public class Main {
    public static void main(String[] args) {
        Banco banco = new Banco();

        for (int i = 0; i <100 ; i++) {

            EjecucionTransferencias ejecucionTransferencias = new EjecucionTransferencias(banco,i,2000);

            Thread thread = new Thread(ejecucionTransferencias);

            thread.start();
        }
    }
}
