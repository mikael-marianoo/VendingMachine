import java.util.Scanner;

/**
 * Runs the whole program.
 * <p>
 * Contains the main menu for all features.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */
public class Driver {
    /**
     * Function from where all features are run from.
     * @param args used to run main
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        VendingMachineFactory factory = new VendingMachineFactory();

        boolean exitProgram = false;

        while (!exitProgram) {
            System.out.println("------ Vending Machine Factory Simulator ------");
            System.out.println("1. Create a Vending Machine");
            System.out.println("2. Test a Vending Machine");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    factory.createVendingMachine();
                    break;
                case 2:
                    factory.testVendingMachine();
                    break;
                case 3:
                    exitProgram = true;
                    break;
                default:
                    System.out.println("Invalid choice!");
                    break;
            }
        }

        scanner.close();
    }
}