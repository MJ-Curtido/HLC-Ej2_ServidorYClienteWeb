/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hlc.ej2_servidoryclienteweb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Dam
 */
public class Cliente {
    public static void main(String[] args) throws IOException {
        Scanner leer = new Scanner(System.in);
        
        System.out.println("Introduzca una url");
        String url = leer.next();
        
        url = url.trim();
        
        String[] separadosPorBarras = url.split("/");
        
        String host = separadosPorBarras[2].split(":")[0];
        int puertoRemoto = Integer.parseInt(separadosPorBarras[2].split(":")[1]);

        Socket cliente = new Socket(host, puertoRemoto);
        
        DataOutputStream msgCliente = new DataOutputStream(cliente.getOutputStream());
        msgCliente.writeUTF(url);
        
        DataInputStream msgServer = new DataInputStream(cliente.getInputStream());
        System.out.println(msgServer.readUTF());
        
        msgCliente.close();
        msgServer.close();
        cliente.close();
    }
}
