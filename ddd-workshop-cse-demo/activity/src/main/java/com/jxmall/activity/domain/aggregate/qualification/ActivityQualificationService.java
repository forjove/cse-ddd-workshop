package com.jxmall.activity.domain.aggregate.qualification;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ActivityQualificationService {

    @Autowired
    private ActivityQualificationRepository repository;

    public ActivityQualification getCurrentActivityQualification() {
        return repository.getCurrentActivityQualification();
    }
}