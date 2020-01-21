package com.jxmall.activity.adapter.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activity.domain.aggregate.activity.ActivityRepository;
import com.jxmall.activity.domain.aggregate.activity.root.Activity;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ActivityRepositoryCache implements ActivityRepository {

    private static List<Activity> dataList = new ArrayList<Activity>();

    static {
        dataList.add(new Activity(UUID.randomUUID().toString(), "IT论坛", "IT界精英齐聚一趟，交流技术，产生共鸣", "广东.深圳.南山",
                new String[] { "IT", "技术论坛", "技术交流" }));
        dataList.add(new Activity(UUID.randomUUID().toString(), "技术峰会", "技术峰会，邀请业界技术大牛参与", "广东.深圳.罗湖",
                new String[] { "IT", "峰会", "技术论坛", "技术交流" }));
        dataList.add(new Activity(UUID.randomUUID().toString(), "Ruby技术交流", "Ruby是世界上最好的开发语言，由华为发起", "广东.深圳.福田",
                new String[] { "IT", "Ruby", "PHP", "编程语言", "华为" }));
        dataList.add(new Activity(UUID.randomUUID().toString(), "DDD Workshop", "领域驱动设计，Thoughtworks一直致力于微服务的推广",
                "广东.深圳.盐田", new String[] { "IT", "DDD", "Workshop", "微服务", "Workshop" }));
    }

    public List<Activity> search(String key) {
        if (StringUtils.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream()
                .filter(activity -> Arrays.asList(activity.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(Activity activity) {
        dataList.add(activity);
    }

    public Activity findById(String id) {
        return dataList.stream().filter(activity -> id.equals(activity.getId())).findFirst().orElse(null);
    }
}
