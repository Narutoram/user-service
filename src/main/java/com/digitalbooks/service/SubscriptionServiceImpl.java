package com.digitalbooks.service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.client.RestTemplate;

import com.digitalbooks.dto.BookDto;
import com.digitalbooks.entity.SubscriptionInfoEntity;
import com.digitalbooks.repository.SubscriptionDao;

@Service
@Transactional
public class SubscriptionServiceImpl implements SubscriptionService {
	
   @Autowired
   private SubscriptionDao subscriptionDao;

	@Override
	public SubscriptionInfoEntity subscribeBook(Long bookId, Long authorId) {
		// TODO Auto-generated method stub
		SubscriptionInfoEntity subscriptionInfoEntity = new SubscriptionInfoEntity();
		subscriptionInfoEntity.setBookId(bookId);
		subscriptionInfoEntity.setUserId(authorId);
		subscriptionInfoEntity.setSubscriptionDate(ZonedDateTime.now());
		return subscriptionDao.save(subscriptionInfoEntity);
	}

	@Override
	public List<BookDto> fetchSubscribedBooks(Long subscriptionId, Long authorId) {
		List<BookDto> books=new ArrayList<BookDto>();
		List<Long> BookIds=subscriptionDao.findbyIdandUserId( subscriptionId,authorId);
		 String uri = "http://localhost:8080/api/digitalbooks/author/books";
		   RestTemplate restTemplate = new RestTemplate();
		   for(Long bookid:BookIds) {
			   Map<String, String> vars = new HashMap<>();
			   vars.put("bookId", bookid.toString());
			   BookDto book= restTemplate.getForObject(uri,BookDto.class,vars ); 
			   books.add(book);
		   }
		   
		// TODO Auto-generated method stub
		return books;
	}

	@Override
	public List<BookDto> fetchAllSubscribedBooks(Long authorId) {
		List<BookDto> books=new ArrayList<BookDto>();
		List<Long> BookIds=subscriptionDao.findbyUserId(authorId);
		 String uri = "http://localhost:8080/api/digitalbooks/author/books/all";
		   RestTemplate restTemplate = new RestTemplate();
		   for(Long bookid:BookIds) {
			   Map<String, String> vars = new HashMap<>();
			   vars.put("bookId", bookid.toString());
			   BookDto book= restTemplate.getForObject(uri,BookDto.class,vars ); 
			   books.add(book);
		   }
		// TODO Auto-generated method stub
		return books;
	}

}
