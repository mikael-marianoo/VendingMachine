import java.util.ArrayList;
import java.util.Scanner;

public class RegularVendingMachine extends VendingMachine {
    private Scanner scanner;

    public RegularVendingMachine() {
        itemSlots = ItemSlotFactory.createRegularItemSlots();
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);
    }

    @Override
    public void testVendingFeatures() {
        System.out.println("------ Testing Vending Features for Regular Vending Machine ------");
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
        scanner.close();
    }

    @Override
    public void testMaintenanceFeatures() {
        System.out.println("Maintenance features are not supported for Regular Vending Machine.");
    }

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
