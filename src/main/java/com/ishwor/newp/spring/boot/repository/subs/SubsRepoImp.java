package com.ishwor.newp.spring.boot.repository.subs;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ishwor.newp.spring.boot.comon.util.AOP.TrackQueryTime;
import com.ishwor.newp.spring.boot.domain.Subscription;

@Repository
@Transactional
public class SubsRepoImp {

	@Autowired
	SubsRepo em;
	@TrackQueryTime
	public void save(Subscription sub) {
		em.save(sub);
	}

}
