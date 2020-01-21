package com.jxmall.activity.qualification.domain.aggregate.activity;

import java.util.List;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

public interface ActivityQualificationRepository {
    
    List<ActivityQualification> search(String key);

    void create(ActivityQualification activityQualification);

    ActivityQualification findById(String id);

    List<ActivityQualification> getAllActivityQualification();
}
