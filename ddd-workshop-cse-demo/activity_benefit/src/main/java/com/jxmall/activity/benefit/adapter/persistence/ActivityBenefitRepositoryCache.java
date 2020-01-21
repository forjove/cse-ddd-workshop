package com.jxmall.activity.benefit.adapter.persistence;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activity.benefit.domain.aggregate.activity.ActivityBenefitRepository;
import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ActivityBenefitRepositoryCache implements ActivityBenefitRepository  {

    private static List<ActivityBenefit> dataList = new ArrayList<ActivityBenefit>();
    
    static {
        for (int i = 1; i <= 12; i ++) {
            dataList.add(
                ActivityBenefit.builder()
                    .id(UUID.randomUUID().toString())
                    .source(1)
                    .money(1 * 10)
                    .build()
            );
        }
    }

    public List<ActivityBenefit> search(String key) {
        if(StringUtils.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream()
                .filter(activityBenefit -> activityBenefit.getId().contains(key))
                .collect(Collectors.toList());
    }

    public void create(ActivityBenefit activityBenefit) {
        dataList.add(activityBenefit);
    }

    public ActivityBenefit findById(String id) {
        return dataList.stream()
                .filter(activityBenefit -> id.equals(activityBenefit.getId()))
                .findFirst()
                .orElse(null);
    }

    public ActivityBenefit findBySource(int source) {
        return dataList.stream()
                .filter(activityBenefit -> activityBenefit.getSource() == source)
                .findFirst()
                .orElse(null);
    }
}
