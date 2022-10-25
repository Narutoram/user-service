package com.digitalbooks.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.digitalbooks.entity.SubscriptionInfoEntity;

@Repository
public interface SubscriptionDao extends JpaRepository<SubscriptionInfoEntity, Long>{

	List<Long> findbyIdandUserId(Long subscriptionId, Long authorId);

	List<Long> findbyUserId(Long authorId);

}
