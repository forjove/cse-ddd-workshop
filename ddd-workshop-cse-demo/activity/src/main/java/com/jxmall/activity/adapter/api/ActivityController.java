package com.jxmall.activity.adapter.api;

import com.jxmall.activity.application.ActivityApplication;
import com.jxmall.activity.domain.aggregate.activity.root.Activity;
import org.apache.servicecomb.provider.rest.common.RestSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@RestController
@RestSchema(schemaId = "activity")
@RequestMapping("/jxmall/activities")
public class ActivityController {

    @Autowired
    private ActivityApplication activityApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<Activity>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody Activity activity) {
        activityApplication.create(activity);
        return ResponseEntity.ok("success");
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<Activity> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityApplication.findById(id));
    }
}