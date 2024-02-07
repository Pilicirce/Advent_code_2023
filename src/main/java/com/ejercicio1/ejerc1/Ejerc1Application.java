package com.ejercicio1.ejerc1;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Ejerc1Application {

    public static void main(String[] args) {
        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1.txt";

        try {
            // 1) Open the file for reading

            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // 2) declare variables
            String linea;
            List<Integer> numerosDosDigitos = new ArrayList<>();

            // 3) Iterate over each line of the file
            while ((linea = reader.readLine()) != null) {
                linea = linea.trim();

                if (!linea.isEmpty()) { // to avoid processing empty lines
                    // 4) Find the first digit (number) between the letters
                    // 4.a) First find the index of the first digit that is a number
                    int indicePrimerDigito = 0;
                    while (indicePrimerDigito < linea.length()
                            && !Character.isDigit(linea.charAt(indicePrimerDigito))) {
                        indicePrimerDigito++;
                    }

                    // 4.b) Then take the value of that index in the chain and store it
                    char primerDigito = linea.charAt(indicePrimerDigito);
                    // this method takes an index (indicePrimerDigito) and returns the character at
                    // that position within the line string.

                    // 5) Find the last digit (number) between the letters
                    // 5.a) First find the index of the last digit that is a number
                    int indiceUltimoDigito = linea.length() - 1;
                    while (indiceUltimoDigito >= 0 && !Character.isDigit(linea.charAt(indiceUltimoDigito))) {
                        indiceUltimoDigito--;
                    }

                    // 5.b) Then take the value of that index in the chain and store it
                    char ultimoDigito = linea.charAt(indiceUltimoDigito);

                    // 6) Convert characters to digits and create the two-digit number
                    int numeroDosDigitosLinea = Integer.parseInt("" + primerDigito + ultimoDigito);

                    // 7) Store the two-digit number in the list
                    numerosDosDigitos.add(numeroDosDigitosLinea);

                    // Show the two-digit number obtained from the line
                    System.out.println("Número de dos dígitos de la línea: " + numeroDosDigitosLinea);
                }
            }

            // 8) Close the file reader
            reader.close();

            // 9) Suma los números de dos dígitos almacenados en la lista
            int suma = 0;
            for (int num : numerosDosDigitos) {
                suma += num;
            }

            // 10) Add two-digit numbers stored in the list
            System.out.println("Suma total: " + suma);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
