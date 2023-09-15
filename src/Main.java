import java.util.Scanner;

public class Main {
    public static Scanner keyboard = new Scanner(System.in);

    public static void main(String[] args) {

        Generator generator = new Generator(keyboard);
        mainLoop();
    }

    public static void mainLoop(){
        System.out.println("Welcome!");
        printMenu();
        String userOption = "-1";
        while(!userOption.equals("4")) {
            userOption = keyboard.next();
            Generator g = new Generator();
            switch (userOption) {
                case "1" -> {
                    g.requestPassword();
                }
                case "2" -> {
                    g.checkPassword();
                }
                case "3" -> {
                    printUsefulInfo();
                }
                case "4" -> {
                    printQuitMessage();
                }
                default -> {
                    System.out.println();
                    System.out.println("Select one of the available commands");
                    printMenu();
                }
            }
        }
    }

    public static void printMenu(){
        System.out.println();
        System.out.println("Enter 1 - Password Generator");
        System.out.println("Enter 2 - Password Strength Check");
        System.out.println("Enter 3 - Useful Information");
        System.out.println("Enter 4 - Quit");
        System.out.print("Choice:");
    }

    private static void printQuitMessage() {
        System.out.println("Closing the program. Until next time.");
    }

    private static void printUsefulInfo() {
        System.out.println();
        System.out.println("Use a minimum password length of 8 or more characters if permitted");
        System.out.println("Include lowercase and uppercase alphabetic characters, numbers and symbols if permitted");
        System.out.println("Generate passwords randomly where feasible");
        System.out.println("Avoid using the same password twice (e.g., across multiple user accounts and/or software systems)");
        System.out.println("Avoid character repetition, letter or number sequences, relative or pet names, romantic links (current or past) and biographical information (e.g., ID numbers, ancestors' names or dates).");
    }
}