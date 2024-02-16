package com.adventcode2023.day1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Day1_Part2 {

    public static void main(String[] args) {
        String inputFilePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1.txt";
        String outputFilePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1b_modificado.txt";

        try {
            // 1) Abre el archivo para lectura
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            // 2) Abre el archivo de salida para escritura
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            // 3) Declara variables
            String linea;
            List<Integer> numerosDosDigitos = new ArrayList<>(); // Lista para almacenar los números de dos dígitos en un array

            // 4) Itera sobre cada línea del archivo y reemplaza las palabras por números (en un método a parte)
            while ((linea = reader.readLine()) != null) {
                // 4.a) Reemplaza las palabras con números
                linea = reemplazarPalabrasConNumeros(linea).trim(); // Elimina los espacios en blanco al inicio y al final de la línea

                // 4.c) Escribe la línea modificada en el archivo de salida
                writer.write(linea);
                writer.newLine(); // Añade una nueva línea después de cada línea modificada

                
                // 5) Encuentra el primer dígito (número) en cada línea: 
                if (!linea.isEmpty()) { // para evitar procesar líneas en blanco

                   // 5.a) Primero, encuentra el índice del primer dígito que sea un número
                    int indicePrimerDigito = 0;
                    while (indicePrimerDigito < linea.length() && !Character.isDigit(linea.charAt(indicePrimerDigito))) {
                        indicePrimerDigito++;
                        // esto verifica si el carácter en la posición actual (indicePrimerDigito) de la cadena linea es un dígito o no. Character.isDigit() es un método que devuelve
                        // true si el carácter proporcionado es un dígito, y false de lo contrario. Pero como he puesto un (!), es al reves. Entonces, el bucle se ejecuta mientras en
                        // indice del caracter que analizo sea menor que la lingitud del string linea Y mientras que el caracter no sea un dígito.
                    }

                    //5.b) Luego coge el valor de ese índice en la cadena y lo almacenamos
                    char primerDigito = linea.charAt(indicePrimerDigito);
                    // este método coge un índice (indicePrimerDigito) y devuelve el carácter en esa posición dentro de la cadena linea. En términos sencillos, esto extrae el
                    // carácter en la posición del primer dígito encontrado y lo guarda en la variable primerDigito.

                    // 6) Encuentra el último dígito (número) entre las letras
                    //6.a) Primero, encuentra el índice del último dígito que sea un número
                    int indiceUltimoDigito = linea.length() - 1;
                    while (indiceUltimoDigito >= 0 && !Character.isDigit(linea.charAt(indiceUltimoDigito))) {
                        indiceUltimoDigito--;
                        // esto es lo mismo que con el primer dígito, pero empieza por atras (lenth-1) y se va restando índices hasta que llega a 0.
                        // porque en realidad, estoy recorriendo el string otra vez, pero de atras para alante
                    }

                    //6.b) Luego coge el valor de ese índice en la cadena y lo almacenamos
                    char ultimoDigito = linea.charAt(indiceUltimoDigito);


                    // 7) Convierte los caracteres a dígitos y crea el número de dos dígitos
                    int numeroDosDigitosLinea = Integer.parseInt("" + primerDigito + ultimoDigito);

                    // 8) Almacena el número de dos dígitos en la lista
                    numerosDosDigitos.add(numeroDosDigitosLinea);


                // Muestra el número de dos dígitos obtenido de la línea
                System.out.println("Número de dos dígitos de la línea: " + numeroDosDigitosLinea);
            }
    }

            //9)  Cierra los recursos
            reader.close();
            writer.close();

            // 10) Suma los números de dos dígitos almacenados en la lista
            int suma = 0;
            for (int num : numerosDosDigitos) {
                suma += num;
            }

             System.out.println("Proceso completado. El archivo modificado se encuentra en: " + outputFilePath);

            // 11) Muestra la suma total de los números de dos dígitos
            System.out.println("Suma total: " + suma);

            

        } catch (IOException e) {
            e.printStackTrace();
        }
    }



    // 4.b) fuera de la clase main: metodo para reemplazar palabras por numeros
    private static String reemplazarPalabrasConNumeros(String linea) {
        return linea.replaceAll("one", "o1e")
                .replaceAll("two", "t2o")
                .replaceAll("three", "t3e")
                .replaceAll("four", "f4r")
                .replaceAll("five", "f5e")
                .replaceAll("six", "s6x")
                .replaceAll("seven", "s7n")
                .replaceAll("eight", "e8t")
                .replaceAll("nine", "n9e");
    }

    // private static int encontrarPrimerDigito(String linea) {
    //     for (char c : linea.toCharArray()) {
    //         if (Character.isDigit(c)) {
    //             return Character.getNumericValue(c);
    //         }
    //     }
    //     return 0; // Retorna 0 si no se encuentra ningún dígito
    // }

    // private static int encontrarUltimoDigito(String linea) {
    //     for (int i = linea.length() - 1; i >= 0; i--) {
    //         char c = linea.charAt(i);
    //         if (Character.isDigit(c)) {
    //             return Character.getNumericValue(c);
    //         }
    //     }
    //     return 0; // Retorna 0 si no se encuentra ningún dígito
    // }

    // private static int obtenerNumeroDosDigitos(int primerDigito, int ultimoDigito) {
    //     return primerDigito * 10 + ultimoDigito;
    // }
}

