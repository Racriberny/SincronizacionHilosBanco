package com.cristobalbernal.SincronizacionHilosBanco;

public class Banco {
    private final double[] cuentas;

    public Banco(){
        cuentas = new double[100];

        for (int i = 0; i <cuentas.length ; i++) {
            cuentas[i] = 2000;
        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad){
        if (cuentas[cuentaOrigen]< cantidad){
            return;
        }
        System.out.println(Thread.currentThread());

        cuentas[cuentaOrigen]-=cantidad; //Este es el dinero que sale de la cuenta

        System.out.printf("%10.2f de %d para %d",cantidad,cuentaOrigen,cuentaDestino);

        cuentas[cuentaDestino] += cantidad; //Suba la cantidad de dinero a la cuenta destino.

        System.out.println("Saldo total: " + getSaldoCuenta());
    }
    public double getSaldoCuenta(){
        double suma_cuenta = 0;

        for (double a:cuentas){
            suma_cuenta+=a;
        }
        return suma_cuenta;
    }
}
