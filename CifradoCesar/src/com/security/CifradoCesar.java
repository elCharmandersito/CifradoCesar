package com.security;

public class CifradoCesar {
    public static void main(String[] args) {
        Cifrado cifrado = new Cifrado();
        String mensaje = "silasgotasdelluvia";

        String encriptado = cifrado.encriptar(mensaje, 5);
        System.out.println("Mensaje encriptado generado -> " + encriptado);

        String desencriptado = cifrado.desencriptar(encriptado, 5);
        System.out.println("Resultado de la desencriptación -> " + desencriptado);
    }
}
