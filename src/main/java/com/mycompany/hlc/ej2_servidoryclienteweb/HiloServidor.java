/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hlc.ej2_servidoryclienteweb;

import java.net.Socket;

/**
 *
 * @author Dam
 */
class HiloServidor extends Thread {
    Socket cliente;
    int i;

    public HiloServidor(int i, Socket cliente) {
        this.i = i;
        this.cliente = cliente;
    }

    @Override
    public void run() {
        
    }
    
}