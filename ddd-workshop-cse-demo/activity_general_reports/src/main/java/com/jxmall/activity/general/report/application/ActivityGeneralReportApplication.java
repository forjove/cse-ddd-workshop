package com.jxmall.activity.general.report.application;

import java.util.List;

import com.jxmall.activity.general.report.domain.aggregate.activity.ActivityGeneralReportService;
import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ActivityGeneralReportApplication {

    @Autowired
    public ActivityGeneralReportService activityGeneralReportService;

    public List<ActivityGeneralReport> search(String key) {
		return activityGeneralReportService.search(key);
	}

	public void create(ActivityGeneralReport activityGeneralReport) {
		activityGeneralReportService.create(activityGeneralReport);
	}

	public ActivityGeneralReport findById(String id){
		return activityGeneralReportService.findById(id);
	}
}