package com.jxmall.activity.channel.application;

import java.util.List;

import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;
import com.jxmall.activity.channel.domain.aggregate.activity.ActivityChannelService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityChannelApplication {

    @Autowired
    private ActivityChannelService activityChannelService;

    public List<ActivityChannel> search(String key) {
        return activityChannelService.search(key);
    }

    public void create(ActivityChannel activityChannel) {
        activityChannelService.create(activityChannel);
    }

    public ActivityChannel findById(String id) {
        return activityChannelService.findById(id);
    }
}