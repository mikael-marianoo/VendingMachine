import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Contains methods where vending machines are instantiated.
 * <p>
 * Has a list of vending machines and a scanner for input.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */
public class VendingMachineFactory {
    private List<VendingMachine> vendingMachines;
    private Scanner scanner;

    /**
     * Constructor for the VendingMachineFactory datatype.
     */
    public VendingMachineFactory() {
        vendingMachines = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    /**
     * Instantiates new vending machine on input.
     * <p>
     * Exits program without instantiating a vending machine if inputted data is not 1 or 2.
     * </p>
     */
    public void createVendingMachine() {
        System.out.println("------ Create a Vending Machine ------");
        System.out.println("1. Regular Vending Machine");
        System.out.println("2. Special Vending Machine");
        System.out.print("Enter your choice: ");
        int choice = scanner.nextInt();

        VendingMachine vendingMachine;
        if (choice == 1) {
            vendingMachine = new RegularVendingMachine();
        } else if (choice == 2) {
            vendingMachine = new SpecialVendingMachine();
        } else {
            System.out.println("Invalid choice!");
            return;
        }

        vendingMachines.add(vendingMachine);
        System.out.println("Vending Machine created successfully!");
    }

    /**
     * Method to select which vending machine to test features for.
     */
    public void testVendingMachine() {
        System.out.println("------ Test a Vending Machine ------");
        System.out.println("Available Vending Machines:");

        if (vendingMachines.isEmpty()) {
            System.out.println("No Vending Machines available. Create a Vending Machine first.");
            return;
        }

        for (int i = 0; i < vendingMachines.size(); i++) {
            System.out.println((i + 1) + ". Vending Machine " + (i + 1));
        }

        System.out.print("Enter the Vending Machine number to test: ");
        int choice = scanner.nextInt();

        if (choice < 1 || choice > vendingMachines.size()) {
            System.out.println("Invalid choice!");
            return;
        }

        VendingMachine vendingMachine = vendingMachines.get(choice - 1);
        vendingMachine.testVendingFeatures();
    }
}
