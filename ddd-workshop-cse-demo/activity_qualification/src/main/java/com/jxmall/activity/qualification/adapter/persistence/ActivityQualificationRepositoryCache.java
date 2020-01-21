package com.jxmall.activity.qualification.adapter.persistence;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import com.jxmall.activity.qualification.domain.aggregate.activity.ActivityQualificationRepository;
import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ActivityQualificationRepositoryCache implements ActivityQualificationRepository {

    private static List<ActivityQualification> dataList = new ArrayList<ActivityQualification>();

    private static SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    static {
        try {
            dataList.add(ActivityQualification.builder().id("1").name("双11回血活动")
                    .content("亲，双11是否还有没抢购到的商品呢，机会来啦，现在全场半价，走过路过不要错过")
                    .startDate(simpleDateFormat.parse("2019-11-11")) //2019-11-11
                    .endDate(simpleDateFormat.parse("2019-12-12")) // 2019-12-12
                    .build());
            dataList.add(ActivityQualification.builder().id("2").name("双12半价活动").content("在双12期间，所有商品全部半价，新注册的会员折上折")
                    .startDate(simpleDateFormat.parse("2019-12-12")) // 2019-12-12
                    .endDate(simpleDateFormat.parse("2019-12-15")) // 2019-12-15
                    .build());
        } catch (Exception e) {
            // 暂时不处理
        }
    }

    public List<ActivityQualification> search(String key) {
        if (StringUtils.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream().filter(activityQualification -> activityQualification.getName().contains(key))
                .collect(Collectors.toList());
    }

    public void create(ActivityQualification activityQualification) {
        dataList.add(activityQualification);
    }

    public ActivityQualification findById(String id) {
        return dataList.stream().filter(activityQualification -> id.equals(activityQualification.getId())).findFirst()
                .orElse(null);
    }

    public List<ActivityQualification> getAllActivityQualification() {
        return dataList;
    }
}
