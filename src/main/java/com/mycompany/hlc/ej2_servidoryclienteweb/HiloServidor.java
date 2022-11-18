/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.hlc.ej2_servidoryclienteweb;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.URL;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dam
 */
class HiloServidor extends Thread {
    private Socket cliente;
    private DataInputStream flujoEntrada;
    private DataOutputStream flujoSalida;
    private File archivo;

    public HiloServidor(Socket cliente) throws IOException {
        this.cliente = cliente;
        
        flujoEntrada = new DataInputStream(cliente.getInputStream());
        flujoSalida = new DataOutputStream(cliente.getOutputStream());
    }

    @Override
    public void run() {
        try {
            String url = flujoEntrada.readUTF();
            String path = "";
            
            String[] separadosPorBarras = url.split("/");
            
            path = separadosPorBarras[3];
            
            if (separadosPorBarras.length > 3) {
                for (int i = 4; i < separadosPorBarras.length; i++) {
                    path += "/" + separadosPorBarras[i];
                }
            }
            
            
            try {
                URL urlArchivo = getClass().getResource(path);
                archivo = new File(urlArchivo.getPath());
                flujoSalida.writeUTF("200");
                String texto = "";
                
                Scanner myReader = new Scanner(archivo);
                while (myReader.hasNextLine()) {
                    texto += "\n" + myReader.nextLine();
                }
                myReader.close();
                System.out.println(texto);
                flujoSalida.writeUTF(texto);
            } catch (Exception e) {
                flujoSalida.writeUTF("404");
            }
            
        } catch (IOException ex) {
            Logger.getLogger(HiloServidor.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}