package com.dsi32g6.Covid19Test.ui.UserHelper;

public class PanierItem {

    String itemname;
    Integer amount;
    Integer priceToPay;

    private String photo;

    public PanierItem(String itemname, Integer amount, Integer priceToPay) {
        this.itemname = itemname;
        this.amount = amount;
        this.priceToPay = priceToPay;
    }

    public PanierItem() {
    }

    public String getItemname() {
        return itemname;
    }

    public void setItemname(String itemname) {
        this.itemname = itemname;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getPriceToPay() {
        return priceToPay;
    }

    public void setPriceToPay(Integer priceToPay) {
        this.priceToPay = priceToPay;
    }


    @Override
    public String toString() {
        return "PanierItem{" +
                "itemname='" + itemname + '\'' +
                ", amount=" + amount +
                ", priceToPay=" + priceToPay +
                '}';
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }
}
