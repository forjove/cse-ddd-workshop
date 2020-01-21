package com.jxmall.activity.general.report.domain.aggregate.activity;

import java.util.List;

import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

public interface ActivityGeneralReportRepository {

    List<ActivityGeneralReport> search(String key);

    void create(ActivityGeneralReport activityGeneralReport);

    ActivityGeneralReport findById(String id);
}
