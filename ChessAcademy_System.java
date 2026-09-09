package com.mycompany.chessacademy_system;

import java.io.*;
import java.util.Scanner;

public class ChessAcademy_System {
    // Single admin credentials
    private static final String ADMIN_USERNAME = "ChessAcademy";
    private static final String ADMIN_PASSWORD = "password123";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Main program loop
        while (true) {
            System.out.println("\n===== Login Screen =====");
            System.out.println("1. Login");
            System.out.println("2. Exit");
            System.out.print("Enter your choice: ");

            try {
                int loginChoice = scanner.nextInt();
                scanner.nextLine(); // Consume newline

                switch (loginChoice) {
                    case 1:
                        if (login(scanner)) {
                            displayMenu(scanner);
                        }
                        break;
                    case 2:
                        System.out.println("Exiting the program. Goodbye!");
                        scanner.close();
                        return;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                        break;
                }
            } catch (Exception e) {
                System.out.println("Invalid input. Please enter a number.");
                scanner.nextLine(); // Clear invalid input
            }
        }
    }

    private static boolean login(Scanner scanner) {
        while (true) {
            System.out.print("Enter username: ");
            String username = scanner.nextLine().trim();

            System.out.print("Enter password: ");
            String password = scanner.nextLine().trim();

            if (ADMIN_USERNAME.equals(username) && ADMIN_PASSWORD.equals(password)) {
                System.out.println("\nLogin successful! Welcome to Chess Academy.");
                return true;
            }
            System.out.println("\nIncorrect username or password. Please try again.");
        }
    }

    // Display menu and handle user choices
    private static void displayMenu(Scanner scanner) {
        while (true) {
            System.out.println("\n===== Chess Academy Admin Menu =====");
            System.out.println("1. Add New Player");
            System.out.println("2. Display Players");
            System.out.println("3. Search Players");
            System.out.println("4. Add Tournament");
            System.out.println("5. Display Tournaments");
            System.out.println("6. Search Tournaments");
            System.out.println("7. Help");
            System.out.println("8. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addPlayer(scanner);
                    break;
                case 2:
                    displayPlayers();
                    break;
                case 3:
                    searchPlayers(scanner);
                    break;
                case 4:
                    addTournament(scanner);
                    break;
                case 5:
                    displayTournaments();
                    break;
                case 6:
                    searchTournaments(scanner);
                    break;
                case 7:
                    displayHelp();
                    break;
                case 8:
                    if (logout(scanner)) {
                        return;
                    }
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    break;
            }
        }
    }

    // Add a new player
    private static void addPlayer(Scanner scanner) {
        System.out.println("Enter player Registration Number:");
        String regNum = scanner.nextLine();

        System.out.println("Enter First Name:");
        String firstName = scanner.nextLine();

        System.out.println("Enter Last Name:");
        String lastName = scanner.nextLine();

        String dob;
        while (true) {
            System.out.println("Enter Date of Birth (DD/MM/YYYY):");
            dob = scanner.nextLine();
            if (dob.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            }
            System.out.println("Invalid date format. Please use DD/MM/YYYY format.");
        }

        System.out.println("Enter Rating:");
        String rating = scanner.nextLine();

        String playerData = regNum + "," + firstName + "," + lastName + "," + dob + "," + rating;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("data.txt", true))) {
            writer.write(playerData);
            writer.newLine();
            System.out.println("Player added successfully and saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving player data.");
        }
    }

    // Display all players
    private static void displayPlayers() {
        System.out.println("\n===== Players =====");
        System.out.println("Reg No | First Name | Last Name | DOB | Rating");

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading player data.");
        }
    }

    // Search for a player by registration number
    private static void searchPlayers(Scanner scanner) {
        System.out.println("Enter registration number to search:");
        String regNum = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("data.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(regNum + ",")) {
                    System.out.println("Player found: " + line);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Player not found.");
        } catch (IOException e) {
            System.out.println("Error reading player data.");
        }
    }

    // Add a new tournament
    private static void addTournament(Scanner scanner) {
        System.out.println("Enter Tournament Name:");
        String name = scanner.nextLine();

        String date;
        while (true) {
            System.out.println("Enter Tournament Date (DD/MM/YYYY):");
            date = scanner.nextLine();
            if (date.matches("\\d{2}/\\d{2}/\\d{4}")) {
                break;
            }
            System.out.println("Invalid date format. Please use DD/MM/YYYY format.");
        }

        System.out.println("Enter Tournament Location:");
        String location = scanner.nextLine();

        String tournamentData = name + "," + date + "," + location;

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("tournaments.txt", true))) {
            writer.write(tournamentData);
            writer.newLine();
            System.out.println("Tournament added successfully and saved to file!");
        } catch (IOException e) {
            System.out.println("Error saving tournament data.");
        }
    }

    // Display all tournaments
    private static void displayTournaments() {
        System.out.println("\n===== Tournaments =====");
        System.out.println("Name | Date | Location");

        try (BufferedReader br = new BufferedReader(new FileReader("tournaments.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }
        } catch (IOException e) {
            System.out.println("Error reading tournament data.");
        }
    }

    // Search for a tournament by name
    private static void searchTournaments(Scanner scanner) {
        System.out.println("Enter tournament name to search:");
        String name = scanner.nextLine();

        try (BufferedReader br = new BufferedReader(new FileReader("tournaments.txt"))) {
            String line;
            boolean found = false;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(name + ",")) {
                    System.out.println("Tournament found: " + line);
                    found = true;
                    break;
                }
            }
            if (!found) System.out.println("Tournament not found.");
        } catch (IOException e) {
            System.out.println("Error reading tournament data.");
        }
    }

    // Display help information
    private static void displayHelp() {
        System.out.println("\n===== Help Information =====");
        System.out.println("1. Add New Player - Register new players to the system");
        System.out.println("2. Display Players - View all registered players");
        System.out.println("3. Search Players - Find players by registration number");
        System.out.println("4. Add Tournament - Create new chess tournaments");
        System.out.println("5. Display Tournaments - View all tournaments");
        System.out.println("6. Search Tournaments - Find tournaments by name");
        System.out.println("7. Help - Show this information");
        System.out.println("8. Logout - Exit to login screen");
    }

    // Logout with confirmation
    private static boolean logout(Scanner scanner) {
        System.out.println("Are you sure you want to log out? (yes/no)");
        String confirmation = scanner.nextLine().trim().toLowerCase();

        if (confirmation.equals("yes")) {
            System.out.println("Logging out...");
            System.out.println("You have been successfully logged out.");
            return true;
        } else {
            System.out.println("Logout canceled. Returning to the main menu.");
            return false;
        }
    }
}