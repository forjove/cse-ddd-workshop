package com.jxmall.activity.benefit.domain.aggregate.activity;

import java.util.List;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

public interface ActivityBenefitRepository {

    List<ActivityBenefit> search(String key);

    void create(ActivityBenefit activityBenefit);

    ActivityBenefit findById(String id);

	ActivityBenefit findBySource(int source);
}
