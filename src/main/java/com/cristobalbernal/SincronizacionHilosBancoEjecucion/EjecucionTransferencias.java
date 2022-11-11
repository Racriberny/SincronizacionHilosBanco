package com.cristobalbernal.SincronizacionHilosBancoEjecucion;

public class EjecucionTransferencias implements Runnable{
    private Banco banco;
    private int daLaCuenta;
    private double cantidadMax;

    public EjecucionTransferencias(Banco banco, int daLaCuenta, double cantidadMax) {
        this.banco = banco;
        this.daLaCuenta = daLaCuenta;
        this.cantidadMax = cantidadMax;
    }

    @Override
    public void run() {
        try {
            while (true){
                int paraLaCuenta = (int)(100*Math.random());
                double cantidad = cantidadMax*Math.random();
                banco.transferencia(daLaCuenta,paraLaCuenta,cantidad);
                Thread.sleep((int)(Math.random()*10));
            }
        }catch (InterruptedException e){

        }

    }
}
