package com.jxmall.activity.channel.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ActivityChannelService {

	@Autowired
	private ActivityChannelRepository repository;

	public List<ActivityChannel> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityChannel activityChannel) {
		activityChannel.setId(UUID.randomUUID().toString());
		repository.create(activityChannel);
	}

	public ActivityChannel findById(String id){
		if(StringUtils.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}