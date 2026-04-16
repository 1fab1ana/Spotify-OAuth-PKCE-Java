package org.example.musicselectorwithjava;

import java.awt.Desktop;
import javax.swing.*;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;

public class AppSpotify {
    public static void main (String[] args){

        // Instanciamos objeto ventana
        JFrame ventana = new JFrame("Conector de Spotify");

        ventana.setSize(400, 200);
        // Cerramos el objeto para evitar que consuma RAM en segundo plano
        ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        // Instanciamos el objeto botón
        JButton botonLogin = new JButton("Conectar con Spotify");

        // Añadimos el botón a la ventana
        ventana.add(botonLogin);

        // Creamos el sensor de eventos del botón
        botonLogin.addActionListener(e -> {

            // Instanciamos el proceso para obtener verificador/challenge en cada vez
            AutenticadorSpotify auth = new AutenticadorSpotify();

            // Invocamos al metodo que obtiene la url parametrada
            String urlString = auth.obtenerURL();
            try {
                // String a un obteto URI (lanza excepcion si es invalido el string)
                URI uri = new URI(urlString);

                // Si la integracion es soportado por el sistema operativo
                if(Desktop.isDesktopSupported()){
                    // Delegamos al navegador la apertura de la url
                    Desktop.getDesktop().browse(uri);
                }

            } catch (URISyntaxException | IOException ex) {

                // Se imprime el error para la depuración
                ex.printStackTrace();
            }

        });
        ventana.setVisible(true);
    }
}


