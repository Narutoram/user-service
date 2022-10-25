package com.digitalbooks.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.SubscriptionInfoEntity;
import com.digitalbooks.service.SubscriptionService;

@RequestMapping("/api/v1/digitalbooks")
public class SubscriptionController {
	
    @Autowired
    private SubscriptionService subscriptionService;
	
	@GetMapping("/readers/{authorId}/books")
	public SubscriptionInfoEntity subscribeBook(@RequestParam Long bookId,@PathVariable Long authorId) {
		return subscriptionService.subscribeBook(bookId,authorId);
	}
	
	@GetMapping("/readers/{authorId}/books/{subscriptionId")
	public List<BookDto>  fetchSubscribedBooks(@PathVariable(name="authorId") Long subscriptionId,@PathVariable(name="subscriptionId") Long authorId) {
		return subscriptionService.fetchSubscribedBooks(subscriptionId,authorId);
	}
	
	@GetMapping("/readers/{emailId}/books")
	public List<BookDto>  fetchAllSubscribedBooks(@PathVariable(name="subscriptionId") Long authorId) {
		return subscriptionService.fetchAllSubscribedBooks(authorId);
	}
}
