/**
 * Contains both item and the quantity of the item.
 * <p>
 * This class contains an Item and an integer variable for the quantity.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */
public class ItemSlot {
    private Item item;
    private int quantity;

    /**
     * Constructor for the ItemSlot datatype.
     * 
     * @param item item data
     * @param quantity amount of items in stock
     */
    public ItemSlot(Item item, int quantity) {
        this.item = item;
        this.quantity = quantity;
    }
    
    /**
     * @return item data
     */
    public Item getItem() {
        return item;
    }

    /**
     * @return amount of items in stock
     */
    public int getQuantity() {
        return quantity;
    }

    /**
     * Decrements the quantity of the item.
     */
    public void decreaseQuantity() {
        quantity--;
    }

    /**
     * Increases the quantity of items, used in restocking.
     * @param quantity amount of items restocked
     */
    public void increaseQuantity(int quantity) {
        this.quantity += quantity;
    }
}
