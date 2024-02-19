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

        solveDay1Part2();

    }

    public static void solveDay1Part2() {

        String inputFilePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1.txt";
        String outputFilePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1b_modificado.txt";

        try {
            // 1) Open the file for reading
            BufferedReader reader = new BufferedReader(new FileReader(inputFilePath));

            // 2) Open the output file for writing
            BufferedWriter writer = new BufferedWriter(new FileWriter(outputFilePath));

            // 3) declare variables
            String linea;
            List<Integer> numerosDosDigitos = new ArrayList<>();

            // 4) Iterate over each line of the file and replace the words (spelled numbers)
            // with numbers (digits)
            // (in a separate method)
            while ((linea = reader.readLine()) != null) {
                // 4.a) Replace the words with numbers
                linea = reemplazarPalabrasConNumeros(linea).trim();

                // 4.c) Write the modified line to the output file
                writer.write(linea);
                writer.newLine();

                // 5) Find the first digit (number) in each line:
                if (!linea.isEmpty()) { // to avoid processing blank lines

                    // 5.a) First, find the index of the first digit that is a number
                    int indicePrimerDigito = 0;
                    while (indicePrimerDigito < linea.length()
                            && !Character.isDigit(linea.charAt(indicePrimerDigito))) {
                        indicePrimerDigito++;
                        // The loop is executed as long as the index of the character it parses is less
                        // than the length of the line string AND as long as the character is not a
                        // digit.
                    }

                    // 5.b) Then take the value of that index in the chain and store it
                    char primerDigito = linea.charAt(indicePrimerDigito);
                    // // this extracts the character at the position of the first digit found and
                    // stores it in the variable primerDigito.

                    // 6) Find the last digit (number) between the letters
                    // 6.a) First, find the index of the last digit that is a number
                    int indiceUltimoDigito = linea.length() - 1;
                    while (indiceUltimoDigito >= 0 && !Character.isDigit(linea.charAt(indiceUltimoDigito))) {
                        indiceUltimoDigito--;
                    }

                    // 6.b) Then take the value of that index in the chain and store it
                    char ultimoDigito = linea.charAt(indiceUltimoDigito);

                    // 7) Convert characters to digits and create the two-digit number
                    int numeroDosDigitosLinea = Integer.parseInt("" + primerDigito + ultimoDigito);

                    // 8) Store the two-digit numbers in the list
                    numerosDosDigitos.add(numeroDosDigitosLinea);

                    // Displays the two-digit number obtained from the line
                    System.out.println("Número de dos dígitos de la línea: " + numeroDosDigitosLinea);
                }
            }

            // 9) Close resources
            reader.close();
            writer.close();

            // 10) Add two-digit numbers stored in the list
            int suma = 0;
            for (int num : numerosDosDigitos) {
                suma += num;
            }

            System.out.println("Proceso completado. El archivo modificado se encuentra en: " + outputFilePath);

            // 11) Display the total sum of two-digit numbers
            System.out.println("SOLUTION DAY 1, PART 2 EXERCISE: Total sum: " + suma);

        } catch (IOException e) {
            e.printStackTrace();
        }

        throw new UnsupportedOperationException("Unimplemented method 'solveDay1Part2'");
    }

    // 4.b) outside the main class: method to replace words with numbers
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

}
