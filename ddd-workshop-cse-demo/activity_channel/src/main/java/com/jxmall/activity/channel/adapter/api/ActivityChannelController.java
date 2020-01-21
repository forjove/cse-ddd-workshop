package com.jxmall.activity.channel.adapter.api;

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

import javax.servlet.http.HttpServletRequest;

import com.jxmall.activity.channel.application.ActivityChannelApplication;
import com.jxmall.activity.channel.domain.aggregate.activity.root.ActivityChannel;

@RestSchema(schemaId = "activity_channels")
@RequestMapping("/jxmall/activity_channels")
public class ActivityChannelController {

    @Autowired
    private ActivityChannelApplication activityChannelApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<ActivityChannel>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(activityChannelApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody ActivityChannel activitieChannel, HttpServletRequest request) {
        activityChannelApplication.create(activitieChannel);
        return ResponseEntity.created(UriComponentsBuilder.newInstance().path("/activity_channels/{id}")
                .buildAndExpand(activitieChannel.getId()).toUri()).build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<ActivityChannel> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(activityChannelApplication.findById(id));
    }
}