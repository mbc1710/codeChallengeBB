package com.banco.base.codeChallenge.dao;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "payments")
@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PaymentEntity implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "payment_id_seq")
	@SequenceGenerator(name = "payment_id_seq", sequenceName = "payment_id_seq", allocationSize = 1)
	@Basic(optional = false)
	@Column(name = "payment_id")
	private Long paymentId;

	@Basic(optional = false)
	@Column(name = "description")
	private String description;
	
	@Basic(optional = false)
	@Column(name = "number_products")
	private Integer numberProducts;
	
	@Basic(optional = false)
	@Column(name = "account_holder")
	private String accountHolder;
	
	@Basic(optional = false)
	@Column(name = "payment_receiver")
	private String paymentReceiver;
	
	@Basic(optional = false)
	@Column(name = "status")
	private String status;
	
	@Basic(optional = false)
	@Column(name = "amount")
	private Double amount;
	
	@Column(name = "user")
	private String user;
	
	@Basic(optional = false)
	@Column(name = "create_date")
	private Date createDate;
	
	@Column(name = "update_date")
	private Date updateDate;
}
