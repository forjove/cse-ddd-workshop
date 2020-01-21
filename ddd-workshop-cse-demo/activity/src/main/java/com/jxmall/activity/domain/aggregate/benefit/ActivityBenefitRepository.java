package com.jxmall.activity.domain.aggregate.benefit;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

public interface ActivityBenefitRepository {

    ActivityBenefit findBySource(int source);
}
