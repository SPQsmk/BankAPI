package com.bootcamp.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import java.math.BigDecimal;
import java.util.Set;

@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "ACCOUNT")
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;

    @Column(name = "NUMBER", nullable = false)
    private String number;

    @Column(name = "BALANCE", nullable = false)
    private BigDecimal balance;

    @ManyToOne
    @JoinColumn(name = "CLIENT_ID", nullable = false)
    private Client client;

    @EqualsAndHashCode.Exclude
    @OneToMany(mappedBy = "account", cascade = CascadeType.ALL, fetch = FetchType.EAGER, orphanRemoval = true)
    private Set<Card> cardList;
}
