/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hlc.ej2_servidoryclienteweb;

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
        String host = "localhost";
        int puertoRemoto = 6007;

        Socket cliente = new Socket(host, puertoRemoto);

        //hacer que se pida una url con un scanner y que esa url la separe por barras y puntos con split que te lo separa en arrays

        System.out.println("Introduzca una url");
        String url = leer.next();
        
        cliente.close();
    }
}
