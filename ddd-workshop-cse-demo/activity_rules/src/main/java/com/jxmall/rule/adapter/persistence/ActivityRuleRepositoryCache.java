package com.jxmall.rule.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.rule.domain.aggregate.rule.ActivityRuleRepository;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

import org.springframework.stereotype.Repository;

@Repository
public class ActivityRuleRepositoryCache implements ActivityRuleRepository{

    private static List<ActivityRule> dataList = new ArrayList<ActivityRule>();

    static {
        for (int i = 1; i <= 12; i ++) {
            dataList.add(
                ActivityRule.builder()
                        .id(UUID.randomUUID().toString())
                        .month(i)
                        .source(i)
                        .build()
                );
        }
    }

    public List<ActivityRule> search(String key) {
        return dataList.stream()
                .filter(activityRule -> activityRule.getId().contains(key))
                .collect(Collectors.toList());
    }

    public void create(ActivityRule activityRule) {
        dataList.add(activityRule);   
    }

    public ActivityRule findById(String id) {
        return dataList.stream()
                .filter(activityRule -> id.equals(activityRule.getId()))
                .findFirst()
                .orElse(null);
    }

    public ActivityRule findByMonth(int month) {
        return dataList.stream()
                .filter(activityRule -> activityRule.getMonth() == month)
                .findFirst()
                .orElse(null);
    }
}
