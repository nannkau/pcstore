package edu.sgu.store.entity;

import jdk.internal.dynalink.linker.LinkerServices;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "product")
public class Product implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Integer id;
    @Column(name = "product_name")
    private String name;
    @Column(name = "detail")
    private String detail;
    @Column(name = "amount")
    private Integer amount;
    @Column(name = "price")
    private Long price;
    @Column(name = "createtime")
    private Date createTime;
    @Column(name = "discountpercent")
    private Integer discountPercent;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "catalog_id")
    private Catalog catalog;
    @OneToMany(mappedBy = "product")
    private List<InvoiceDetail> invoiceDetails;
    @OneToMany(mappedBy = "product")
    private List<Cart> carts;
    @OneToMany(mappedBy = "product")
    private List<Storage> storages;
    @OneToMany(mappedBy = "product")
    private List<ComboProduct> comboProducts;
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

    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Long getPrice() {
        return price;
    }

    public void setPrice(Long price) {
        this.price = price;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getDiscountPercent() {
        return discountPercent;
    }

    public void setDiscountPercent(Integer discountPercent) {
        this.discountPercent = discountPercent;
    }

    public Catalog getCatalog() {
        return catalog;
    }

    public void setCatalog(Catalog catalog) {
        this.catalog = catalog;
    }

    public List<InvoiceDetail> getInvoiceDetails() {
        return invoiceDetails;
    }

    public void setInvoiceDetails(List<InvoiceDetail> invoiceDetails) {
        this.invoiceDetails = invoiceDetails;
    }

    public List<Storage> getStorages() {
        return storages;
    }

    public void setStorages(List<Storage> storages) {
        this.storages = storages;
    }

    public List<ComboProduct> getComboProducts() {
        return comboProducts;
    }

    public void setComboProducts(List<ComboProduct> comboProducts) {
        this.comboProducts = comboProducts;
    }

    public List<Cart> getCarts() {
        return carts;
    }

    public void setCarts(List<Cart> carts) {
        this.carts = carts;
    }
}
