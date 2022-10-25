package com.digitalbooks.service;

import java.util.List;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.SubscriptionInfoEntity;

public interface SubscriptionService {

	SubscriptionInfoEntity subscribeBook(Long bookId, Long authorId);

	List<BookDto>  fetchSubscribedBooks(Long subscriptionId, Long authorId);

	List<BookDto> fetchAllSubscribedBooks(Long authorId);

}
