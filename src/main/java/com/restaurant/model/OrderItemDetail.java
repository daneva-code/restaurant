package com.restaurant.model;

public class OrderItemDetail {

    private Long itemId;
    private String quantity;
    private String specialNote;

    public Long getItemId() {
        return itemId;
    }

    public void setItemId(Long itemId) {
        this.itemId = itemId;
    }

    public String getQuantity() {
        return quantity;
    }

    public void setQuantity(String quantity) {
        this.quantity = quantity;
    }

    public String getSpecialNote() {
        return specialNote;
    }

    public void setSpecialNote(String specialNote) {
        this.specialNote = specialNote;
    }


    @Override
    public String toString() {
        return "OrderItemDetail{" +
                "itemId=" + itemId +
                ", quantity='" + quantity + '\'' +
                ", specialNote='" + specialNote + '\'' +
                '}';
    }
}
