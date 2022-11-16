package com.cristobalbernal.SincronizacionHilosBancoEjecucion;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Banco {
    private final double[] cuentas;
    private final Lock cierreBanco = new ReentrantLock();

    public Banco(){
        cuentas = new double[100];

        for (int i = 0; i <cuentas.length ; i++) {
            cuentas[i] = 2000;
        }
    }

    public void transferencia(int cuentaOrigen, int cuentaDestino, double cantidad){

        cierreBanco.lock();

        try {
            if (cuentas[cuentaOrigen] < cantidad) {
                System.out.println("---------------------CANTIDAD INSUFICIENTE: " + cuentaOrigen + " SAlDO: " + cuentas[cuentaOrigen] + ".... " + cantidad);
                return;
            }else {
                System.out.println("-----------TRANFERENCIA OK----------" + cuentas[cuentaOrigen]);
            }
            System.out.println(Thread.currentThread());

            cuentas[cuentaOrigen] -= cantidad; //Este es el dinero que sale de la cuenta

            System.out.printf("%10.2f de %d para %d", cantidad, cuentaOrigen, cuentaDestino);

            cuentas[cuentaDestino] += cantidad; //Suba la cantidad de dinero a la cuenta destino.

            System.out.println("Saldo total: " + getSaldoCuenta());
        }finally {
            cierreBanco.unlock();
        }
    }
    public double getSaldoCuenta(){
        double suma_cuenta = 0;

        for (double a:cuentas){
            suma_cuenta+=a;
        }
        return suma_cuenta;
    }

}
