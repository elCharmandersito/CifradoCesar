package com.security;

public class Cifrado {

    public Cifrado() {
    }

    /*METODO UTILIZADO PARA LA SCRIPTACION DEL MENSAJE DADO UNA CANTIDAD X DE DESPLAZAMIENTOS*/
    public String encriptar(String mensaje, int desplazamiento) {

        // EN CASO DE QUE EL DEZPLAMIENTO SUPERE LAS 26 POSIBLES COMBINACIONES DE TABLA
        // SE CALCULA EL MOD 26 PARA OBTENER EL DESPLAZAMIENTO ORIGINAL
        if (desplazamiento > 26) {
            desplazamiento = desplazamiento % 26; // ALMACENA EL DESPLAZAMIENTO LUEGO DE REALIZAR EL MOD 26
        } else if (desplazamiento < 0) {
            desplazamiento = (desplazamiento % 26) + 26; // En caso de ser negativo lo deja positivo
        }

        String textoCifrado = "";

        int length = mensaje.length();
        for (int i = 0 ; i < length ; i++) {

            // OBTIENE CADA UNO DE LOS CHAR DEL MENSAJE
            char caracter = mensaje.charAt(i);

            // COMPRUEBA QUE EL CARACTER OBTENIDO SEA UNA LETRA
            if (Character.isLetter(caracter)) {

                // SE COMPRUEBA PRIMERO SI EL CARACTER ESTA EN MINUSCULA
                if (Character.isLowerCase(caracter)) {

                    // OBTIENE EL CARACTER A PARTIR DEL DESPLAZAMIENTO GENERADO
                    char newCaracter = (char)(caracter + desplazamiento);

                    //Revisa el bucle de los caracteres desde a-z para evitar outOfBourder
                    //Es decir, una vez que revisa los caracteres y llega a la z lo reseta para empezar desde la a
                    if (newCaracter > 'z') {

                        // RECUPERA EL CARACTER DEL ALBABETO DADO UN DESPLAMIENTO
                        textoCifrado += (char)(caracter - (26 - desplazamiento));
                    } else {

                        // UNE LOS CARACTERES EN LA VARIABLE
                        textoCifrado += newCaracter;
                    }

                    // EN CASO DE QUE EL CARACTER SEA MAYUSCULA, REALIZA LO MISMO QUE EL CASO ANTERIOR
                } else if (Character.isUpperCase(caracter)) {

                    char newCaracter = (char)(caracter + desplazamiento); // obtiene el caracter a partir del desplazamiento generado

                    if (newCaracter > 'Z') {

                        //Revisa el bucle de los caracteres desde a-z para evitar outOfBourder
                        //Es decir, una vez que revisa los caracteres y llega a la z lo reseta para empezar desde la a
                        textoCifrado += (char)(caracter - (26 - desplazamiento));
                    } else {
                        textoCifrado += newCaracter;
                    }
                }
            } else {
                textoCifrado += caracter;
            }
        } return textoCifrado;
    }

    // EL METODO PARA DESENCRIPTAR ES LA MISMA LOGICA QUE EL METODO ANTERIOR, LA UNICA DIFERENCIA
    // ES QUE LA BUSQUEDA DEL CARACTER ES EN REVERSA, ES DECIR
    // EN VEZ DE SUMAR LOS DESPLAZAMIENTO SE RESTAN
    public String desencriptar(String mensaje, int desplazamiento) {
        if (desplazamiento > 26) {
            desplazamiento = desplazamiento % 26; // Reseta los desplazamientos
        } else if (desplazamiento < 0) {
            desplazamiento = (desplazamiento % 26) + 26; // En caso de ser negativo lo deja positivo
        }

        String textoCifrado = "";

        int length = mensaje.length();
        for (int i = 0 ; i < length ; i++) {
            char caracter = mensaje.charAt(i);
            if (Character.isLetter(caracter)) {
                if (Character.isLowerCase(caracter)) {
                    char newCaracter = (char)(caracter - desplazamiento);
                    if (newCaracter < 'a') {
                        textoCifrado += (char)(caracter + (26 - desplazamiento));
                    } else {
                        textoCifrado += newCaracter;
                    }
                } else if (Character.isUpperCase(caracter)) {
                    char newCaracter = (char)(caracter - desplazamiento);
                    if (newCaracter < 'A') {
                        textoCifrado += (char)(caracter + (26 - desplazamiento));
                    } else {
                        textoCifrado += newCaracter;
                    }
                }
            } else {
                textoCifrado += caracter;
            }
        }
        return textoCifrado;
    }
}
