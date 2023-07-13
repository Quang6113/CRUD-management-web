/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package basicobject;

/**
 *
 * @author QUANG
 */
public class Category {
    private int cateId;
    private String cateName;
    private boolean status;

    public Category() {
    }

    public Category(int cateId, String cateName, boolean status) {
        this.cateId = cateId;
        this.cateName = cateName;
        this.status = status;
    }

    public int getCateId() {
        return cateId;
    }

    public void setCateId(int cateId) {
        this.cateId = cateId;
    }

    public String getCateName() {
        return cateName;
    }

    public void setCateName(String cateName) {
        this.cateName = cateName;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "Category{" + "cateId=" + cateId + ", cateName=" + cateName + ", status=" + status + '}';
    }
}
