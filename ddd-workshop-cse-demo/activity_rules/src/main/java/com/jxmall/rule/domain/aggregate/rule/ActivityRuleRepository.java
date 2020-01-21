package com.jxmall.rule.domain.aggregate.rule;

import java.util.List;

import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

public interface ActivityRuleRepository {
    
    List<ActivityRule> search(String key);

    void create(ActivityRule ActivityRule);

    ActivityRule findById(String id);

	ActivityRule findByMonth(int month);
}
