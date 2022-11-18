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
        int puerto = 6007;
        
        ServerSocket servidor = new ServerSocket(puerto);
        
        while (true) {
            System.out.println("\n\nEscuchando en " + servidor.getLocalPort());
            
            Socket cliente = servidor.accept();
            
            HiloServidor hilo = new HiloServidor(cliente);
            hilo.start();
        }
    }
}