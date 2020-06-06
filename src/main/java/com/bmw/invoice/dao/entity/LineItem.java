package com.bmw.invoice.dao.entity;


import lombok.*;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "item")
@Data
public class LineItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String description;
    private long quantity;
    private BigDecimal unitPrice;

}
