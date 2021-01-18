package com.ishwor.newp.spring.boot.repository.subs;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ishwor.newp.spring.boot.domain.Subscription;


public interface SubsRepo extends JpaRepository<Subscription, Long> {

}
