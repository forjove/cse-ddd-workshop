package com.jxmall.user.domain.aggregate.activity;

import com.jxmall.user.domain.aggregate.activity.root.Activity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityService {

    @Autowired
    private ActivityRepository activityRepository;

    public void addActivity(String userId) {
        activityRepository.create(new Activity());
    }
}