public class AdventCodeApp {

    //this is the main class of the project. It indicates which Day and Part of the Adven Code must run
    public static void main(String[] args) {
        if (args.length != 2) {
            System.out.println("Use: java AdventCodeApp <Day> <Part>");
            return;
        }

        int day = Integer.parseInt(args[0]);
        int part = Integer.parseInt(args[1]);

        switch (day) {
            case 1:
                if (part == 1) {
                    Day1Part1.solve();
                } else if (part == 2) {
                    Day1Part2.solve();
                } else {
                    System.out.println("Invalid Part");
                }
                break;
//            case 2:
//                // Lógica para el día 2
//                break;
            // Otros casos para diferentes días
            default:
                System.out.println("Invalid Day");
        }
    }
    
}
