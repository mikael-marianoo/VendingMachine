/**
 * Contains the objects of the datatype Item.
 * <p>
 * This class contains only a String and a double variable, with appopriate constructor and getters, but no setters.
 * </p>
 * @author Jean Mikael Mariano
 * @author Trebis Hao Detablan
 */

public class Item {
    private String name;
    private double price;

    /**
     * Constructor for the Item datatype.
     * 
     * @param name name of the item
     * @param price price of the item
     */
    public Item(String name, double price) {
        this.name = name;
        this.price = price;
    }

    /**
     * @return name of item
     */
    public String getName() {
        return name;
    }

    /**
     * @return price of item
     */
    public double getPrice() {
        return price;
    }
}
