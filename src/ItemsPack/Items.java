package ItemsPack;

public class Items {

    private String itemName;
    private String itemCategory;
    private boolean isEquipable;

    public Items(String itemName, String itemCategory, boolean isEquipable) {
        this.itemName = itemName;
        this.itemCategory = itemCategory;
        this.isEquipable = isEquipable;
    }

    public String displayItem() {
        return String.format("- Name : %s\n- Category : %s\n", itemName, itemCategory);
    }

}
