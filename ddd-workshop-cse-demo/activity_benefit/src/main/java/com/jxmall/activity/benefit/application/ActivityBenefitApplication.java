package com.jxmall.activity.benefit.application;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;
import com.jxmall.activity.benefit.domain.aggregate.activity.ActivityBenefitService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityBenefitApplication {

    @Autowired
    private ActivityBenefitService activityBenefitService;

    public List<ActivityBenefit> search(String key) {
        return activityBenefitService.search(key);
    }

    public void create(ActivityBenefit activityBenefit) {
        activityBenefitService.create(activityBenefit);
    }

    public ActivityBenefit findById(String id) {
        return activityBenefitService.findById(id);
    }

	public ActivityBenefit findBySource(int source) {
		return activityBenefitService.findBySource(source);
	}

}