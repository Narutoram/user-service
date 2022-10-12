package com.digitalbooks.dto;

import lombok.Data;

@Data
public class SubscriptionDto {

	private String bookId;
	
	private String userId;

	public String getBookId() {
		return bookId;
	}

	public void setBookId(String bookId) {
		this.bookId = bookId;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}

}
