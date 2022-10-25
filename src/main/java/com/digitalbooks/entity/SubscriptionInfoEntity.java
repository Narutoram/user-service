
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
	private Long userId;

	@Column(name = "subscription_date")
	private ZonedDateTime subscriptionDate;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Long getBookId() {
		return bookId;
	}

	public void setBookId(Long bookId) {
		this.bookId = bookId;
	}

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long user) {
		this.userId = user;
	}

	public ZonedDateTime getSubscriptionDate() {
		return subscriptionDate;
	}

	public void setSubscriptionDate(ZonedDateTime subscriptionDate) {
		this.subscriptionDate = subscriptionDate;
	}
	
	
	

}
