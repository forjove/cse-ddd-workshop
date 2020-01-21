package com.jxmall.activity.domain.aggregate.benefit;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityBenefitService {

    @Autowired
    private ActivityBenefitRepository repository;

    public ActivityBenefit findBySource(int source) {
        if (source == 0) {
            return null;
        }
        return repository.findBySource(source);
    }
}