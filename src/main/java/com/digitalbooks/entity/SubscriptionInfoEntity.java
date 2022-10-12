
package com.digitalbooks.entity;

import java.time.ZonedDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.Data;

@Entity

@Data

@Table(name = "subscription")
public class SubscriptionInfoEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	@Column(name = "id")
	private Long id;

	@Column(name = "book_id")
	private Long bookId;

	@OneToOne
	@JoinColumn(name = "user_id")
	private User user;

	@Column(name = "subscription_date")
	private ZonedDateTime subscriptionDate;

}
