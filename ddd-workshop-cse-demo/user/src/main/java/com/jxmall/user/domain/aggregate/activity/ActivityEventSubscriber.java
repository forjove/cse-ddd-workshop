package com.jxmall.user.domain.aggregate.activity;

import com.jxmall.user.domain.aggregate.event.UserCreated;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

@Component
public class ActivityEventSubscriber implements ApplicationListener<UserCreated> {

    @Autowired
    private ActivityService ActivityService;

    @Override
    public void onApplicationEvent(UserCreated event) {
        ActivityService.addActivity(event.getUserId());
    }
}