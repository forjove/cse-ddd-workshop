package com.jxmall.activity.general.report.domain.aggregate.activity;

import java.util.List;
import java.util.UUID;

import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

@Service
public class ActivityGeneralReportService {

	@Autowired
	private ActivityGeneralReportRepository repository;

	public List<ActivityGeneralReport> search(String key) {
		return repository.search(key);
	}

	public void create(ActivityGeneralReport activityGeneralReport) {
		activityGeneralReport.setId(UUID.randomUUID().toString());
		repository.create(activityGeneralReport);
	}

	public ActivityGeneralReport findById(String id){
		if(StringUtils.isEmpty(id)){
			return null;
		}
		return repository.findById(id);
	}
}