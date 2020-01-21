package com.jxmall.user.adapter.persistence;

import com.jxmall.user.domain.aggregate.activity.ActivityRepository;
import com.jxmall.user.domain.aggregate.activity.root.Activity;
import lombok.extern.slf4j.Slf4j;
import org.apache.servicecomb.provider.springmvc.reference.RestTemplateBuilder;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Repository;
import org.springframework.web.client.RestTemplate;

@Repository
@Slf4j
public class ActivityRepositoryHttp implements ActivityRepository {

    private RestTemplate client = RestTemplateBuilder.create();

    @Value("${activity.server.api.create}")
    private String createApi;

    @Override
    public void create(Activity activity) {

        client.postForObject(createApi, activity, String.class);

        // 暂时不处理返回的URI
        //log.info("{}://{}:{}{}", uri.getScheme(), uri.getHost(), uri.getPort(), uri.getPath());
    }
}