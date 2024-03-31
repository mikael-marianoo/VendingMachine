import java.util.Scanner;

/**
 * Front for all processes of the Special vending machine.
 * <p>
 * Contains 2 major functions, vending, maintenance features, and transaction summary. <br>
 * Extends the VendingMachine class for more concise code. <br>
 * Has one unique variable for input, scanner.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */
public class SpecialVendingMachine extends VendingMachine {
    private Scanner scanner;

    /**
     * Constructor for the SpecialVendingMachine datatype.
     * <p>
     * Uses createSpecialItemSlots to create default items and createTransactionList for special datatype.
     * </p>
     */
    public SpecialVendingMachine() {
        itemSlots = ItemSlotFactory.createSpecialItemSlots();
        transactions = TransactionFactory.createTransactionList();
        scanner = new Scanner(System.in);
    }

    /**
     * Contains the vending features, mainly the selling process.
     * <p>
     * Ends process if invalid input is taken.
     * </p>
     */
    @Override
    public void testVendingFeatures() {
        System.out.println("------ Testing Vending Features for Special Vending Machine ------");
        displayItemSlots();

        System.out.print("Enter the slot number to make a selection: ");
        int slotNumber = scanner.nextInt();

        if (slotNumber < 1 || slotNumber > itemSlots.size()) {
            System.out.println("Invalid slot number!");
            return;
        }

        ItemSlot selectedSlot = itemSlots.get(slotNumber - 1);
        Item selectedItem = selectedSlot.getItem();

        // Check if the selected item is in stock
        if (selectedSlot.getQuantity() == 0) {
            System.out.println("Selected item is out of stock!");
            return;
        }

        System.out.println("Selected item: " + selectedItem.getName());
        System.out.println("Price: " + selectedItem.getPrice());

        System.out.print("Enter the payment amount: ");
        double payment = scanner.nextDouble();

        // Check if the payment amount is sufficient
        if (payment < selectedItem.getPrice()) {
            System.out.println("Insufficient payment!");
            return;
        }

        double change = payment - selectedItem.getPrice();
        System.out.println("Change: " + change);

        // Update item quantities and track transactions
        selectedSlot.decreaseQuantity();
        Transaction transaction = new Transaction(selectedItem, 1);
        transactions.add(transaction);

        System.out.println("Item dispensed successfully!");
    }

    /**
     * Contains maintenance restocking features.
     * <p>
     * Ends process if invalid input is taken.
     * </p> 
     */
    @Override
    public void testMaintenanceFeatures() {
        System.out.println("------ Testing Maintenance Features for Special Vending Machine ------");
        displayItemSlots();

        System.out.print("Enter the slot number to restock: ");
        int slotNumber = scanner.nextInt();

        if (slotNumber < 1 || slotNumber > itemSlots.size()) {
            System.out.println("Invalid slot number!");
            return;
        }

        ItemSlot selectedSlot = itemSlots.get(slotNumber - 1);
        Item selectedItem = selectedSlot.getItem();

        System.out.print("Enter the quantity to restock: ");
        int quantity = scanner.nextInt();

        selectedSlot.increaseQuantity(quantity);
        System.out.println("Restocked " + selectedItem.getName() + " by " + quantity + " items.");
    }

    /**
     * Prints out all transactions of the special vending machine.
     */
    @Override
    public void displaySummary() {
        System.out.println("------ Summary of Transactions ------");

        System.out.println("Starting Inventory:");
        displayItemSlots();

        System.out.println("Ending Inventory:");
        for (ItemSlot slot : itemSlots) {
            System.out.println(slot.getItem().getName() + ": " + slot.getQuantity());
        }

        System.out.println("Items Sold:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction.getItem().getName() + ": " + transaction.getQuantity());
        }

        double totalAmountCollected = getTotalAmountCollected();
        System.out.println("Total Amount Collected: " + totalAmountCollected);

        System.out.println("-----------------------------------");
    }
}