package com.jxmall.activity.adapter.persistence;

import com.jxmall.activity.domain.aggregate.rule.ActivityRuleRepository;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ActivityRuleRepositoryHttp implements ActivityRuleRepository {

    private RestTemplate client = RestTemplateBuilder.create();

    @Value("${activity.rule.server.api.month}")
    private String monthApi;

    public ActivityRule findByMonth(int month) {
        return client.getForEntity(monthApi, ActivityRule.class, month).getBody();
    }
}