package com.jxmall.activity.channel.domain.aggregate.activity;

import java.util.List;

import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

public interface ActivityChannelRepository {

    List<ActivityChannel> search(String key);

    void create(ActivityChannel activityChannel);

    ActivityChannel findById(String id);
}
