package com.bmw.invoice.controller;


import com.bmw.invoice.dao.entity.Invoice;
import com.bmw.invoice.dao.entity.LineItem;
import com.bmw.invoice.domain.InvoiceDetail;
import com.bmw.invoice.services.InvoiceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "/api",
        produces = {
                APPLICATION_JSON_VALUE
        })
public class InvoiceController {


    private InvoiceService invoiceService;

    @Autowired
    public InvoiceController(final InvoiceService invoiceService){
        this.invoiceService=invoiceService;
    }

    @GetMapping(value = "/invoice",  produces = {MediaType.APPLICATION_JSON_VALUE})
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    List<InvoiceDetail> viewAllInvoices(){
        return invoiceService.getAllInvoiceDetatl();
    }

    @PostMapping (value = "/saveInvoice",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody

    public Invoice addInvoice(@RequestBody Invoice invoice){
        return invoiceService.addInvoice(invoice);
    }

    @PostMapping (value = "/saveLine",  produces = { MediaType.APPLICATION_JSON_VALUE })
    @ResponseStatus(HttpStatus.OK)
    @ResponseBody
    public LineItem addLineItem( @RequestBody LineItem lineItem){
        return invoiceService.saveLineItem(lineItem);
    }




}
