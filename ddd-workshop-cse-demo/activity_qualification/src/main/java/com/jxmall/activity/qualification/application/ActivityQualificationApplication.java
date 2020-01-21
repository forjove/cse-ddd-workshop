package com.jxmall.activity.qualification.application;

import java.util.List;

import com.jxmall.activity.qualification.domain.aggregate.activity.ActivityQualificationService;
import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

@Component
public class ActivityQualificationApplication {

    @Autowired
    public ActivityQualificationService activityQualificationService;

    public List<ActivityQualification> search(String key) {
		return activityQualificationService.search(key);
	}

	public void create(ActivityQualification activityQualification) {
		activityQualificationService.create(activityQualification);
	}

	public ActivityQualification findById(String id){
		return activityQualificationService.findById(id);
	}

	public ActivityQualification getCurrentActivityQualification() {
		return activityQualificationService.getCurrentActivityQualification();
	}

}