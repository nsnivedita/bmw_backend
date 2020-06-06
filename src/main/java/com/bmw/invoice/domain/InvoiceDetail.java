package com.bmw.invoice.domain;

import com.bmw.invoice.dao.entity.LineItem;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Getter
@Setter

public class InvoiceDetail {

    private String client;
    private long vatRate;

    private Date invoiceDate;
    private BigDecimal subTotal;
    private BigDecimal vat;
    private BigDecimal total;
    private List<LineItem> line;
}
