package com.jxmall.activity.qualification.adapter.api;

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

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import com.jxmall.activity.qualification.application.ActivityQualificationApplication;
import com.jxmall.activity.qualification.domain.aggregate.activity.root.ActivityQualification;

@RestSchema(schemaId = "activity_qualifications")
@RequestMapping("/jxmall/activity_qualifications")
@Slf4j
public class ActivityQualificationController {

    @Autowired
    private ActivityQualificationApplication activityQualificationApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityQualification>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityQualificationApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody ActivityQualification activitie) {
        activityQualificationApplication.create(activitie);
//        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/activity_qualifications/{id}")
//                .buildAndExpand(activitie.getId()).toUri()).build();
         return ResponseEntity.ok().build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityQualification> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityQualificationApplication.findById(id));
    }

    @RequestMapping(path = "/current-date", method = RequestMethod.GET)
    public ResponseEntity<ActivityQualification> getCurrentActivityQualification() {
        log.debug("current-data");
        return ResponseEntity.ok(activityQualificationApplication.getCurrentActivityQualification());
    }
}