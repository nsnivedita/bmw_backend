package com.bmw.invoice.services;

import com.bmw.invoice.dao.entity.Invoice;
import com.bmw.invoice.dao.entity.LineItem;
import com.bmw.invoice.domain.InvoiceDetail;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

public interface InvoiceService {


    BigDecimal getSubTotal();
    BigDecimal getVat();
    BigDecimal findTotal();
    BigDecimal getLineItemTotal();
    void addLine(LineItem lines);
    List<LineItem> getAllLine();
    Invoice addInvoice(Invoice invoice);
    Invoice viewInvoice();
    List<Invoice> viewAllInvoice();
    LineItem saveLineItem(LineItem lineItem);
    List<InvoiceDetail> getAllInvoiceDetatl();





}
