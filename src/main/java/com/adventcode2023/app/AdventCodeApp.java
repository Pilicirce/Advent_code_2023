package com.adventcode2023.app;

import com.adventcode2023.day1.Day1_Part1;
import com.adventcode2023.day1.Day1_Part2;

public class AdventCodeApp {

    // this is the main class of the project. It indicates which Day and Part of the
    // Adven Code must run
    public static void main(String[] args) {

        // Aquí puedes llamar a los métodos de tus ejercicios según sea necesario
        Day1_Part1.solveDay1Part1();
        Day1_Part2.solveDay1Part2();
        // Agrega llamadas para otros días y partes según sea necesario

        // ESTO ES PARA QUE EL USUARIO INTRODUZCA LO QUE QUIERE QUE SE EJECUTE (POR
        // CONSOLA)
        // Scanner scanner = new Scanner(System.in);

        // System.out.print("Introduce what DAY of the Adven Code Calendar would you
        // like to run (for example, 1): ");
        // int day = scanner.nextInt();

        // System.out.print("Introduce what PART of the exercise would you like to run
        // (1 o 2): ");
        // int part = scanner.nextInt();

        // ESTO ES PARA EJECUTARLO YO, ESCRIBIENDO EL DAY Y LA PART POR COMANDO
        // if (args.length != 2) {
        // System.out.println("Use: java AdventCodeApp <Day> <Part>");
        // return;
        // }

        // int day = Integer.parseInt(args[0]);
        // int part = Integer.parseInt(args[1]);

        // switch (day) {
        // case 1:
        // if (part == 1) {
        // Day1Part1.solve();
        // } else if (part == 2) {
        // Day1Part2.solve();
        // } else {
        // System.out.println("Invalid Part");
        // }
        // break;

        // case 2:
        // if (part == 1) {
        // Day2Part1.solve();
        // } else if (part == 2) {
        // Day2Part2.solve();
        // } else {
        // System.out.println("Invalid Part");
        // }
        // break;

        // case 3:
        // // Lógica para el día 2
        // break;

        // Otros casos para diferentes días
        // default:
        // System.out.println("Invalid Day");
        // }

        // // scanner.close();
        // }

    }
}