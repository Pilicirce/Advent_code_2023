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
        // SpringApplication.run(Ejerc1Application.class, args);
        String filePath = "C:\\Users\\msolisma\\Desktop\\PILI\\CURSOS\\AdventCode\\ejercicioDia1.txt";

        try {
            // 1) Abre el archivo para lectura
            // BufferedReader: es una clase que proporciona una forma eficiente de leer el
            // texto de un flujo de entrada (archivo)
            // new BufferedReades: crea una nueva instancia de BufferedReader y recibe como
            // argumento el FileReader
            // FileReader es una nueva instancia que apunta al archivo de la ruta
            // reader es la variable (de tipo BufferedReader)s
            BufferedReader reader = new BufferedReader(new FileReader(filePath));

            // 2) declara variables y crea arrays
            String linea;
            List<Integer> numerosDosDigitos = new ArrayList<>(); // Lista para almacenar los números de dos dígitos en
                                                                 // un array

            // 3) Itera sobre cada línea del archivo
            while ((linea = reader.readLine()) != null) {
                // Elimina los espacios en blanco al inicio y al final de la línea
                linea = linea.trim();

                if (!linea.isEmpty()) { // para evitar procesar líneas en blanco
                    // 4) Encuentra el primer dígito (número) entre las letras
                    // 4.a) Primero encuentra el índice del primer dígito que sea un número
                    int indicePrimerDigito = 0;
                    while (indicePrimerDigito < linea.length()
                            && !Character.isDigit(linea.charAt(indicePrimerDigito))) {
                        indicePrimerDigito++;
                        // esto verifica si el carácter en la posición actual (indicePrimerDigito) de la
                        // cadena linea es un dígito o no. Character.isDigit() es un método que devuelve
                        // true si el carácter proporcionado es un dígito, y false de lo contrario. Pero
                        // como he puesto un (!), es al reves. Entonces, el bucle se ejecuta mientras en
                        // indice del caracter que analizo sea menor que la longitud del string linea Y
                        // mientras que el caracter no sea un dígito.
                    }

                    // 4.b) Luego coge el valor de ese índice en la cadena y lo almacenamos
                    char primerDigito = linea.charAt(indicePrimerDigito);
                    // este método coge un índice (indicePrimerDigito) y devuelve el carácter en esa
                    // posición dentro de la cadena linea. En términos sencillos, esto extrae el
                    // carácter en la posición del primer dígito encontrado y lo guarda en la
                    // variable primerDigito.

                    // 5) Encuentra el último dígito (número) entre las letras
                    // 5.a) Primero, encuentra el índice del último dígito que sea un número
                    int indiceUltimoDigito = linea.length() - 1;
                    while (indiceUltimoDigito >= 0 && !Character.isDigit(linea.charAt(indiceUltimoDigito))) {
                        indiceUltimoDigito--;
                        // esto es lo mismo que con el primer dígito, pero empieza por atras (lenth-1) y
                        // se va restando índices hasta que llega a 0.

                        // NO me FALTA la parte en que si no hay último número que coja el primero,
                        // porque en realidad, estoy recorriendo el string otra vez, pero de atras para
                        // alante
                    }

                    // 5.b) Luego coge el valor de ese índice en la cadena y lo almacenamos
                    char ultimoDigito = linea.charAt(indiceUltimoDigito);

                    // 6) Convierte los caracteres a dígitos y crea el número de dos dígitos
                    int numeroDosDigitosLinea = Integer.parseInt("" + primerDigito + ultimoDigito);

                    // 7) Almacena el número de dos dígitos en la lista
                    numerosDosDigitos.add(numeroDosDigitosLinea);

                    // Muestra el número de dos dígitos obtenido de la línea
                    System.out.println("Número de dos dígitos de la línea: " + numeroDosDigitosLinea);
                }
            }

            // 8) Cierra el lector de archivo
            reader.close();

            // 9) Suma los números de dos dígitos almacenados en la lista
            int suma = 0;
            for (int num : numerosDosDigitos) {
                suma += num;
            }

            // 10) Muestra la suma total de los números de dos dígitos
            System.out.println("Suma total: " + suma);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
