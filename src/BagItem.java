/* Connor */
public class BagItem {
    private Item itemType;
    private int numOfItems;

    public BagItem(Item itemType, int numOfItems) {
        this.itemType = itemType;
        this.numOfItems = numOfItems;
    }

    public Item getItemType() {
        return itemType;
    }

    public void setItemType(Item itemType) {
        this.itemType = itemType;
    }

    public int getNumOfItems() {
        return numOfItems;
    }

    public void setNumOfItems(int numOfItems) {
        this.numOfItems = numOfItems;
    }
}
