package com.jxmall.rule.adapter.api;

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

import com.jxmall.rule.application.ActivityRuleApplication;
import com.jxmall.rule.domain.aggregate.rule.root.ActivityRule;

@RestSchema(schemaId = "activity_rules")
@RequestMapping("/jxmall/activity_rules")
@Slf4j
public class ActivityRuleController {

    @Autowired
    private ActivityRuleApplication activityRuleApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityRule>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityRuleApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody ActivityRule rule) {
        activityRuleApplication.create(rule);
        return ResponseEntity.created(
                UriComponentsBuilder.newInstance().path("/activity_rules/{id}").buildAndExpand(rule.getId()).toUri())
                .build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityRule> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityRuleApplication.findById(id));
    }

    @RequestMapping(path = "/month/{month}", method = RequestMethod.GET)
    public ResponseEntity<ActivityRule> findByMonth(@PathVariable("month") int month) {
        return ResponseEntity.ok(activityRuleApplication.findByMonth(month));
    }
}