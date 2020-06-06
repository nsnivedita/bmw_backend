package com.bmw.invoice.services;

import com.bmw.invoice.dao.entity.Invoice;
import com.bmw.invoice.dao.entity.LineItem;
import com.bmw.invoice.dao.repository.InvoiceRepository;
import com.bmw.invoice.dao.repository.LineItemRepository;
import com.bmw.invoice.domain.InvoiceDetail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service
public class InvoiceServiceImpl implements InvoiceService {

    private InvoiceRepository invoiceRepository;
    private LineItemRepository lineItemRepository;

    @Autowired
    public InvoiceServiceImpl(final InvoiceRepository invoiceRepository, final LineItemRepository lineItemRepository )
    {
        this.invoiceRepository = invoiceRepository;
        this.lineItemRepository = lineItemRepository;
    }

      @Override
      public BigDecimal getSubTotal(){
          List<LineItem> line = getAllLine();
          BigDecimal subTotal= BigDecimal.ZERO;

          for(LineItem lines : line ) {
              subTotal =subTotal.add(lines.getUnitPrice().multiply(BigDecimal.valueOf(lines.getQuantity())));
          }
          return subTotal;
      }

      @Override
      public BigDecimal getVat(long rate){

          BigDecimal vat =
          return vat;
      }

      @Override
      public BigDecimal findTotal(){

          BigDecimal total =  (getSubTotal().add(getVat()));
          return  total;

      }

      @Override
      public  BigDecimal getLineItemTotal(){
          LineItem lineItem = new LineItem();
          BigDecimal lineItemTotal = BigDecimal.valueOf(lineItem.getQuantity()).multiply(lineItem.getUnitPrice());
          return  lineItemTotal;
      }

      @Override
      public  List<LineItem> getAllLine(){
          List<LineItem> line = new ArrayList<>();
          lineItemRepository.findAll().forEach(line::add);
        return line;

      }


    @Override
    public void addLine(LineItem lines) {
        this.getAllLine().add(lines);
    }

      @Override
       public  Invoice addInvoice(Invoice invoice){

        invoiceRepository.save(invoice);
        return invoice;
      }

      @Override
       public  List<Invoice> viewAllInvoice(){
        List<Invoice> invoice = new ArrayList<>();
        invoiceRepository.findAll().forEach(invoice::add);

        return invoice;
      }

      @Override
      public  List<InvoiceDetail> getAllInvoiceDetatl(){
        List<InvoiceDetail> invoiceDetails = new ArrayList<>();
        List<Invoice> invoices = viewAllInvoice();
        List<LineItem> items = getAllLine();
        InvoiceDetail invoiceDetail = new InvoiceDetail();
        for(Invoice invoice:invoices){

            invoiceDetail.setClient(invoice.getClient());
            invoiceDetail.setInvoiceDate(invoice.getInvoiceDate());
            invoiceDetail.setSubTotal(getSubTotal());
            invoiceDetail.setVat(getVat(invoice.getVatRate()));
            invoiceDetail.setTotal(findTotal());
            invoiceDetail.setLine(getAllLine());
            invoiceDetails.add(invoiceDetail);
        }
        return invoiceDetails;


      }

      @Override

       public Invoice viewInvoice(){

        Invoice invoice = new Invoice();
        invoiceRepository.findById(invoice.getId());

        return invoice;

      }

      @Override
      public  LineItem saveLineItem(LineItem lineItem){
        return lineItemRepository.save(lineItem);
      }




}
