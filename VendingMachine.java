import java.util.List;

/**
 * Mother class to Regular and Special Vending Machine.
 * <p>
 * This class is mainly used to initialize objects and serves as a multitool and blueprint for both Regular and Special Vending Machines. <br>
 * Contains itemSlots and transactions, the former containing all data about the items, and the latter containing all transaction data.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */

public abstract class VendingMachine {
    protected List<ItemSlot> itemSlots;
    protected List<Transaction> transactions;

    /** Instantiated object used in Regular and Special Vending Machines. */
    public abstract void testVendingFeatures();

    /** Instantiated object used in Regular and Special Vending Machines. */
    public abstract void testMaintenanceFeatures();

    /** Instantiated object used in Regular and Special Vending Machines. */
    public abstract void displaySummary();

    /** Prints out all items with their data. */
    protected void displayItemSlots() {
        System.out.println("Available Items:");
        for (int i = 0; i < itemSlots.size(); i++) {
            ItemSlot slot = itemSlots.get(i);
            System.out.println((i + 1) + ". " + slot.getItem().getName() + " - " + slot.getItem().getPrice());
        }
    }

    /**
     * Returns the total amount attained from all transactions.
     * @return total amount attained
     */
    protected double getTotalAmountCollected() {
        double totalAmount = 0.0;
        for (Transaction transaction : transactions) {
            totalAmount += transaction.getItem().getPrice() * transaction.getQuantity();
        }
        return totalAmount;
    }
}
