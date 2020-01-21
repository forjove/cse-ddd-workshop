package com.jxmall.activity.qualification.domain.aggregate.activity;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ActivityQualificationService {

	@Autowired
	private ActivityQualificationRepository repository;

	public List<ActivityQualification> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityQualification activityQualification) {
		activityQualification.setId(UUID.randomUUID().toString());
		repository.create(activityQualification);
	}

	public ActivityQualification findById(String id) {
		if (StringUtils.isEmpty(id)) {
			return null;
		}
		return repository.findById(id);
	}

	public ActivityQualification getCurrentActivityQualification() {
		// 1、查询活动资格列表
		List<ActivityQualification> activityQualifications = repository.getAllActivityQualification();

		// 2、获取系统时间
		long currentTime = new Date().getTime();

		System.out.println(currentTime);

		// 3、查询对应的活动
		return activityQualifications.stream()
				.filter(activityQualification -> {
					System.out.println("====");
					System.out.println(activityQualification.getStartDate().getTime());
					System.out.println(activityQualification.getEndDate().getTime());
					
					return activityQualification.getStartDate().getTime() <= currentTime
						&& activityQualification.getEndDate().getTime() >= currentTime;
				})
				.findFirst().orElse(null);

		/*

		return activityQualifications.stream()
				.filter(activityQualification -> activityQualification.getStartDate().getTime() <= currentTime
						&& activityQualification.getEndDate().getTime() >= currentTime)
				.findFirst().orElse(null);
		*/
	}

}