package com.jxmall.activity.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.domain.aggregate.activity.root.Activity;

//import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ActivityService {

	@Autowired
	private ActivityRepository repository;

	public List<Activity> search(String key) {
		return repository.search(key);
	}

	public void create(Activity activity) {
		activity.setId(UUID.randomUUID().toString());
		repository.create(activity);
	}

	public Activity findById(String id){
		if(StringUtils.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}