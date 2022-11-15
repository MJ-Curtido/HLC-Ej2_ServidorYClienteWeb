/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hlc.ej2_servidoryclienteweb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
class HiloServidor extends Thread {
    private Socket cliente;
    private DataInputStream msgCliente;
    private DataOutputStream msgServer;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
        
        msgCliente = new DataInputStream(cliente.getInputStream());
        msgServer = new DataOutputStream(cliente.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String url = msgCliente.readUTF();
            String path = "";
            
            String[] separadosPorBarras = url.split("/");
            
            for (int i = 3; i < separadosPorBarras.length; i++) {
                path += "\\" + separadosPorBarras[i];
            }
            
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}