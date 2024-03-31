/**
 * Contains the objects of the Transaction datatype.
 * <p>
 * Has variables item, which contains the item sold, and quantity, contains the amount of the item sold.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */

public class Transaction {
    private Item item;
    private int quantity;

    /**
     * Constructor for the Transaction datatype.
     * @param item item sold
     * @param quantity amount of items sold
     */
    public Transaction(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }

    /**
     * @return item sold
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return amount of items sold
     */
    public int getQuantity() {
        return quantity;
    }
}
