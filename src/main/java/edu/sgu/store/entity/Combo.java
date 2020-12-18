package edu.sgu.store.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="combo")
public class Combo implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;
    @Column(name = "combo_name")
    private String name;
    @Column(name = "discountpercent")
    private Integer discountPercent;
    @Column(name = "createtime")
    private Date createTime;
   @OneToMany(mappedBy = "combo")
    private List<InvoiceDetail> invoiceDetails;
    @OneToMany(mappedBy = "combo")
    private List<Cart> carts;
   @OneToMany(mappedBy = "combo")
   private List<ComboProduct> comboProducts;

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public List<ComboProduct> getComboProducts() {
        return comboProducts;
    }

    public void setComboProducts(List<ComboProduct> comboProducts) {
        this.comboProducts = comboProducts;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
