package com.jxmall.activity.domain.aggregate.activity;

import java.util.List;

import com.jxmall.activity.domain.aggregate.activity.root.Activity;


public interface ActivityRepository {

    List<Activity> search(String key);

    void create(Activity activity);

    Activity findById(String id);
}
