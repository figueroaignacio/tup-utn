package Parte2;

import java.io.*;

public class DemoParte2 {

    public static void run() {
        System.out.println("=== PARTE 2: EXCEPCIONES ===");

        // División segura
        try {
            int a = 10;
            int b = 0;
            int resultado = a / b;
            System.out.println("Resultado: " + resultado);
        } catch (ArithmeticException e) {
            System.out.println("Error: División por cero.");
        }

        // Conversión de cadena a número
        try {
            String texto = "abc";
            int numero = Integer.parseInt(texto);
        } catch (NumberFormatException e) {
            System.out.println("Error: El texto no es un número.");
        }

        // Lectura de archivo
        try {
            BufferedReader br = new BufferedReader(new FileReader("archivo.txt"));
        } catch (FileNotFoundException e) {
            System.out.println("Error: El archivo no existe.");
        }

        // Excepción personalizada
        try {
            validarEdad(-5);
        } catch (EdadInvalidaException e) {
            System.out.println("Edad inválida: " + e.getMessage());
        }

        // try-with-resources
        try (BufferedReader br = new BufferedReader(new FileReader("archivo.txt"))) {
            System.out.println("Contenido: " + br.readLine());
        } catch (IOException e) {
            System.out.println("Error leyendo el archivo (try-with-resources).");
        }

        System.out.println();
    }

    private static void validarEdad(int edad) throws EdadInvalidaException {
        if (edad < 0 || edad > 120) {
            throw new EdadInvalidaException("La edad debe estar entre 0 y 120.");
        }
    }
}
