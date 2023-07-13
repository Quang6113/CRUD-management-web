/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicobject;

/**
 *
 * @author QUANG
 */
public class Item {
    private int itemId;
    private String itemName;
    private int price;
    private int cateId;

    public Item() {
    }

    public Item(int itemId, String itemName, int price, int cateId) {
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.cateId = cateId;
    }

    public int getItemId() {
        return itemId;
    }

    public void setItemId(int itemId) {
        this.itemId = itemId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    @Override
    public String toString() {
        return "Item{" + "itemId=" + itemId + ", itemName=" + itemName + ", price=" + price + ", cateId=" + cateId + '}';
    }

    
}
