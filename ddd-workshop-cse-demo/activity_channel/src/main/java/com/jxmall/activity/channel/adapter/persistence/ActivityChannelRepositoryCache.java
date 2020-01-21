package com.jxmall.activity.channel.adapter.persistence;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import com.jxmall.activity.channel.domain.aggregate.activity.ActivityChannelRepository;
import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

@Repository
public class ActivityChannelRepositoryCache implements ActivityChannelRepository {

    private static List<ActivityChannel> dataList = new ArrayList<ActivityChannel>();
    
    static {
        dataList.add(new ActivityChannel(UUID.randomUUID().toString(), "李白", "zs@thoughtworks.com", "广东.深圳.南山", 30,
                new String[] { "IT男", "男", "宅男" }));
        dataList.add(new ActivityChannel(UUID.randomUUID().toString(), "杜甫", "ls@thoughtworks.com", "广东.深圳.龙岗", 16,
                new String[] { "用户体验设计师", "女", "时尚达人" }));
        dataList.add(new ActivityChannel(UUID.randomUUID().toString(), "王维", "zd@thoughtworks.com", "广东.深圳.罗湖", 28,
                new String[] { "业务需求分析师", "女", "美装达人" }));
        dataList.add(new ActivityChannel(UUID.randomUUID().toString(), "白居易", "bjy@thoughtworks.com", "广东.深圳.盐田", 32,
                new String[] { "项目经理", "男", "美食达人" }));
        dataList.add(new ActivityChannel(UUID.randomUUID().toString(), "陆游", "ly@thoughtworks.com", "广东.深圳.坪山", 34,
                new String[] { "质量保障师", "男", "职场老者" }));
    }

    public List<ActivityChannel> search(String key) {
        if(StringUtils.isEmpty(key)) {
            return dataList;
        }
        return dataList.stream()
                .filter(activityChannel -> Arrays.asList(activityChannel.getLabels()).stream().anyMatch(l -> l.equalsIgnoreCase(key)))
                .collect(Collectors.toList());
    }

    public void create(ActivityChannel activityChannel) {
        dataList.add(activityChannel);
    }

    public ActivityChannel findById(String id) {
        return dataList.stream()
                .filter(activityChannel -> id.equals(activityChannel.getId()))
                .findFirst()
                .orElse(null);
    }
}
