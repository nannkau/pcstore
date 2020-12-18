package edu.sgu.store.dto;

import edu.sgu.store.entity.Combo;
import edu.sgu.store.entity.ComboProduct;
import edu.sgu.store.entity.Customer;
import edu.sgu.store.entity.Product;
public class CartDTO {
    private Integer id;
    private Boolean selected;
    private Product product;
    private Integer amount;
    private Customer customer;
    private Combo combo;
    private long price;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice() {
        long priceTmp=0;
        if (this.combo!=null){
            for (ComboProduct comboProduct: this.combo.getComboProducts())
            {
               priceTmp=priceTmp+(comboProduct.getProduct().getPrice()* comboProduct.getAmount());
            }
            this.price=priceTmp;
        }
        else {
            this.price=0;
        }

    }

    public Boolean getSelected() {
        return selected;
    }

    public void setSelected(Boolean selected) {
        this.selected = selected;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Combo getCombo() {
        return combo;
    }

    public void setCombo(Combo combo) {
        this.combo = combo;
    }
}
