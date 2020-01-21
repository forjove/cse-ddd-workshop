package com.jxmall.activity.domain.aggregate.rule;

import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityRuleService {

    @Autowired
    private ActivityRuleRepository repository;

    public ActivityRule findByMonth(int month) {
        return repository.findByMonth(month);
    }
}