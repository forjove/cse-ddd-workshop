package com.jxmall.activity.general.report.adapter.api;

import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

import com.jxmall.activity.general.report.application.ActivityGeneralReportApplication;
import com.jxmall.activity.general.report.domain.aggregate.activity.root.ActivityGeneralReport;

@RestSchema(schemaId = "activity_general_reports")
@RequestMapping("/jxmall/activity_general_reports")
public class ActivityGeneralReportController {

    @Autowired
    private ActivityGeneralReportApplication activityGeneralReportApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityGeneralReport>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityGeneralReportApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody ActivityGeneralReport activitieGeneralReport) {
        activityGeneralReportApplication.create(activitieGeneralReport);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/activity_general_reports/{id}")
                .buildAndExpand(activitieGeneralReport.getId()).toUri()).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityGeneralReport> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityGeneralReportApplication.findById(id));
    }
}