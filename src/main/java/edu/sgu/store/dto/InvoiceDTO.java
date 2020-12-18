package edu.sgu.store.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;
import java.util.List;

public class InvoiceDTO {
    private String address;
    @DateTimeFormat(pattern = "MM/dd/yyyy")
    private Date shipDate;
    private List<CartDTO> itemList;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getShipDate() {
        return shipDate;
    }

    public void setShipDate(Date shipDate) {
        this.shipDate = shipDate;
    }

    public List<CartDTO> getItemList() {
        return itemList;
    }

    public void setItemList(List<CartDTO> itemList) {
        this.itemList = itemList;
    }
}
