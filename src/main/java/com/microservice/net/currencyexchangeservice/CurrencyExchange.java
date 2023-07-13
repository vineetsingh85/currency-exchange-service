package com.microservice.net.currencyexchangeservice;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor@NoArgsConstructor@Getter@Setter
@Entity
public class CurrencyExchange {
    @Id
    private long id;
    @Column(name="currency_from")
    private String from;
    @Column(name="currency_to")
    private String to;
    BigDecimal conversionMultiple;
    private String environment;
}
