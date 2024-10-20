package com.jbn.block.maintenance.residence.payment.entity;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.Date;

@Entity
@Data
@Table(name = "resident_payment_trx")
public class ResidentPaymentTrx {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "RESIDENT_PAYMENT_TRX_ID")
    private Integer residentPaymentTrxId;

    @Column(name = "RESIDENT_ID")
    private Integer residentId;

    @Column(name = "AMOUNT_PAID")
    private Double amountPaid;

    @Column(name = "CREATED_ON")
    private Date createdOn;

    @Column(name = "UPDATED_ON")
    private Date updatedOn;

    @Column(name = "RECORD_DATE")
    private Date recordDate;

}
