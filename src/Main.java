import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        PasswordManager manager = new PasswordManager();
        manager.loadFromFile("accounts.txt");
        boolean running = true;

        while (running) {
            System.out.println("\n--- Password Manager ---");
            System.out.println("1. Add account");
            System.out.println("2. View accounts");
            System.out.println("3. Delete account");
            System.out.println("0. Exit");
            System.out.print("Your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter service name: ");
                    String service = scanner.nextLine();
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();

                    Account existing = manager.getAccountByService(service);
                    if (existing != null) {
                        System.out.println("An account for this service already exists:");
                        System.out.println(existing);
                        System.out.print("Do you want to replace it? (y/n): ");
                        String confirm = scanner.nextLine();
                        if (confirm.equalsIgnoreCase("y")) {
                            manager.deleteAccount(service);
                            manager.addAccount(service, username, password);
                            System.out.println("Account replaced.");
                        } else {
                            System.out.println("Operation cancelled.");
                        }
                    } else {
                        manager.addAccount(service, username, password);
                        System.out.println("Account added.");
                    }
                    manager.saveToFile("accounts.txt");
                    break;

                case 2:
                    System.out.print("Show passwords? (y/n): ");
                    String show = scanner.nextLine();
                    boolean showPw = show.equalsIgnoreCase("y");
                    manager.listAccounts(showPw);
                    break;
                case 3:
                    System.out.println("Enter service name: ");
                    String serviceName = scanner.nextLine();
                    manager.deleteAccount(serviceName);
                    manager.saveToFile("accounts.txt");
                    break;
                case 0:
                    running = false;
                    manager.saveToFile("accounts.txt");
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice.");
            }
        }

        scanner.close();
    }
}
