package com.jxmall.rule.application;

import java.util.List;

import com.jxmall.rule.domain.aggregate.rule.ActivityRuleService;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityRuleApplication {

	@Autowired
	private ActivityRuleService activityRuleService;

	public List<ActivityRule> search(String key) {
		return activityRuleService.search(key);
	}

	public void create(ActivityRule ActivityRule) {
		activityRuleService.create(ActivityRule);
	}

	public ActivityRule findById(String id) {
		return activityRuleService.findById(id);
	}

	public ActivityRule findByMonth(int month) {
		return activityRuleService.findByMonth(month);
	}

}
