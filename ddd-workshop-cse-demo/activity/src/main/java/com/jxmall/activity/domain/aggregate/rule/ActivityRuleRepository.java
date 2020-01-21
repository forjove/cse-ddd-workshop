package com.jxmall.activity.domain.aggregate.rule;

import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

public interface ActivityRuleRepository {

    ActivityRule findByMonth(int month);
}
