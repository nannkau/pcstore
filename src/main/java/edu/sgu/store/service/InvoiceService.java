package edu.sgu.store.service;

import edu.sgu.store.dto.InvoiceDTO;

public interface InvoiceService {
    void save(InvoiceDTO invoiceDTO,String username);
}
