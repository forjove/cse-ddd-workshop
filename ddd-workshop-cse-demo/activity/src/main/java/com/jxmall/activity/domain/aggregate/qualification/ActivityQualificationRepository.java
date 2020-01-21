package com.jxmall.activity.domain.aggregate.qualification;

import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

public interface ActivityQualificationRepository {

    ActivityQualification getCurrentActivityQualification();
}
