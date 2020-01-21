package com.jxmall.activity.application;

import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;
import com.jxmall.activity.domain.aggregate.activity.ActivityService;
import com.jxmall.activity.domain.aggregate.activity.root.Activity;
import com.jxmall.activity.domain.aggregate.benefit.ActivityBenefitService;
import com.jxmall.activity.domain.aggregate.qualification.ActivityQualificationService;
import com.jxmall.activity.domain.aggregate.rule.ActivityRuleService;
import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
@Slf4j
public class ActivityApplication {

    @Autowired
    private ActivityService activityService;

    @Autowired
    private ActivityQualificationService activityQualificationService;

    @Autowired
    private ActivityRuleService activityRuleService;

    @Autowired
    private ActivityBenefitService activityBenefitService;

    public List<Activity> search(String key) {
        return activityService.search(key);
    }

    public void create(Activity activity) {
        ActivityBenefit activityBenefit = loadActivityBenefit();

        if (activityBenefit == null) {
            return;
        }

        // 设置权益
        setActivityBenefit(activity, activityBenefit);

        activityService.create(activity);
    }

    private void setActivityBenefit(Activity activity, ActivityBenefit activityBenefit) {
        if (activity.getLabels() == null) {
            activity.setLabels(new String[1]);
        }
        activity.getLabels()[1] = "Benefit:" + activityBenefit.getMoney();
    }

    private ActivityBenefit loadActivityBenefit() {
        ActivityRule activityRule = loadActivityRule();

        if (activityRule == null) {
            return null;
        }

        log.info("load activity benefit");

        // 获取活动权益
        return activityBenefitService.findBySource(activityRule.getSource());
    }

    private ActivityRule loadActivityRule() {
        log.info("load activity qualification");

        // 当前活动资格
        ActivityQualification activityQualification = activityQualificationService.getCurrentActivityQualification();

        // 没有活动资格，则不处理
        if (activityQualification == null) {
            return null;
        }

        log.info("load activity rule");

        // 获取活动规则
        return activityRuleService.findByMonth(new Date().getMonth());
    }

    public Activity findById(String id) {
        return activityService.findById(id);
    }
}