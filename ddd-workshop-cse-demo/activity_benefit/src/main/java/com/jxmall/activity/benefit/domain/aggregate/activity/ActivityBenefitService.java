package com.jxmall.activity.benefit.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ActivityBenefitService {

	@Autowired
	private ActivityBenefitRepository repository;

	public List<ActivityBenefit> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityBenefit activityBenefit) {
		activityBenefit.setId(UUID.randomUUID().toString());
		repository.create(activityBenefit);
	}

	public ActivityBenefit findById(String id){
		if(StringUtils.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}

	public ActivityBenefit findBySource(int source) {
		if(source == 0){
			return null;
		}
		return repository.findBySource(source);
	}
}