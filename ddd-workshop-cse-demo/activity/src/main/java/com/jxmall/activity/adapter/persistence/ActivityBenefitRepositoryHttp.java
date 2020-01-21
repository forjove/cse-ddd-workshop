package com.jxmall.activity.adapter.persistence;


import com.jxmall.activity.benefit.domain.aggregate.activity.root.ActivityBenefit;
import com.jxmall.activity.domain.aggregate.benefit.ActivityBenefitRepository;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
public class ActivityBenefitRepositoryHttp implements ActivityBenefitRepository {

    private RestTemplate client = RestTemplateBuilder.create();

    @Value("${activity.benefit.server.api.source}")
    private String sourceApi;

    public ActivityBenefit findBySource(int source) {
        return client.getForEntity(sourceApi, ActivityBenefit.class, source).getBody();
    }
}