/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.hlc.ej2_servidoryclienteweb;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 *
 * @author Dam
 */
public class Servidor {

    public static void main(String[] args) throws IOException {
        int puerto = 90;
        
        ServerSocket servidor = new ServerSocket(puerto);
        
        for (int i = 1; ; i++) {
            System.out.println("Escuchando en " + servidor.getLocalPort());
            
            Socket cliente = servidor.accept();
            
            HiloServidor hilo = new HiloServidor(i, cliente);
            hilo.start();
        }
    }
}