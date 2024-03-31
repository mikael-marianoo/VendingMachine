import java.util.ArrayList;
import java.util.List;

public class ItemSlotFactory {
    public static List<ItemSlot> createRegularItemSlots() {
        List<ItemSlot> itemSlots = new ArrayList<>();
        itemSlots.add(new ItemSlot(new Item("Cola", 1.5), 5));
        itemSlots.add(new ItemSlot(new Item("Chips", 1.0), 10));
        itemSlots.add(new ItemSlot(new Item("Candy", 0.75), 8));
        return itemSlots;
    }

    public static List<ItemSlot> createSpecialItemSlots() {
        List<ItemSlot> itemSlots = new ArrayList<>();
        itemSlots.add(new ItemSlot(new Item("Customized Drink", 2.0), 5));
        itemSlots.add(new ItemSlot(new Item("Katsudon", 15.25), 10));
        itemSlots.add(new ItemSlot(new Item("Bread", 8.0), 8));
        return itemSlots;
    }
}
