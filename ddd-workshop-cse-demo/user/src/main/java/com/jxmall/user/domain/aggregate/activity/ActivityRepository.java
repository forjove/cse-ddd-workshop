package com.jxmall.user.domain.aggregate.activity;

import com.jxmall.user.domain.aggregate.activity.root.Activity;

public interface ActivityRepository {

	void create(Activity activity);

}