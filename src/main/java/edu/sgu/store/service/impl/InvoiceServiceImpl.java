package edu.sgu.store.service.impl;

import edu.sgu.store.dto.CartDTO;
import edu.sgu.store.dto.InvoiceDTO;
import edu.sgu.store.entity.*;
import edu.sgu.store.repository.CartRepository;
import edu.sgu.store.repository.CustomerRepository;
import edu.sgu.store.repository.InvoiceRepository;
import edu.sgu.store.service.InvoiceService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
@Service
public class InvoiceServiceImpl implements InvoiceService {
    final private InvoiceRepository invoiceRepository;
    final private CartRepository cartRepository;
    final private CustomerRepository customerRepository;
    public InvoiceServiceImpl(InvoiceRepository invoiceRepository, CartRepository cartRepository, CustomerRepository customerRepository) {
        this.invoiceRepository = invoiceRepository;
        this.cartRepository = cartRepository;
        this.customerRepository = customerRepository;
    }

    @Override
    public void save(InvoiceDTO invoiceDTO,String username) {
        List<InvoiceDetail> invoiceDetailList= new ArrayList<>();
        for (CartDTO entity : invoiceDTO.getItemList()){
           if (entity.getSelected()==true){
               Cart cart=cartRepository.findById(entity.getId()).get();
               InvoiceDetail invoiceDetail= new InvoiceDetail();
               invoiceDetail.setAmount(entity.getAmount());
               invoiceDetail.setProduct(cart.getProduct());
               if(cart.getProduct()!=null){
                   invoiceDetail.setPrice(cart.getProduct().getPrice());
               }
               else {
                   long price=0;
                   for (ComboProduct comboProduct : cart.getCombo().getComboProducts()){
                       price=price+(comboProduct.getProduct().getPrice()* comboProduct.getAmount());
                   }
                   invoiceDetail.setPrice(price);
                   invoiceDetail.setCombo(cart.getCombo());
               }
               invoiceDetailList.add(invoiceDetail);
               cartRepository.deleteById(cart.getId());
           }
        }
        Invoice invoice= new Invoice();
        invoice.setInvoiceDetails(invoiceDetailList);
        long price=0;
        for (InvoiceDetail invoiceDetail: invoiceDetailList){
            price=price+(invoiceDetail.getPrice()*invoiceDetail.getAmount());
        }
        invoice.setPriceTotal((int) price);
        Customer customer=customerRepository.findByUsername(username).get();
        invoice.setCustomer(customer);
        invoice.setCreateDate(new Date());
        invoice.setAddress(invoiceDTO.getAddress());
        invoice.setShipDate(invoiceDTO.getShipDate());
        invoice.setName("invoice of"+username);
        invoice.setStatus(0);
        invoiceRepository.save(invoice);

    }
}
