package com.jxmall.user.adapter.api;

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

import com.jxmall.user.application.UserApplication;
import com.jxmall.user.domain.aggregate.user.root.User;

@RestSchema(schemaId = "users")
@RequestMapping("/jxmall/users")
public class UserController {

    @Autowired
    private UserApplication userApplication;

    @RequestMapping(path = "/", method = RequestMethod.GET)
    public ResponseEntity<List<User>> search(@RequestParam("key") String key) {
        return ResponseEntity.ok(userApplication.search(key));
    }

    @RequestMapping(path = "/", method = RequestMethod.POST)
    public ResponseEntity<String> create(@RequestBody User user) {
        userApplication.create(user);
        return ResponseEntity
                .created(UriComponentsBuilder.newInstance().path("/users/{id}").buildAndExpand(user.getId()).toUri())
                .build();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET)
    public ResponseEntity<User> findById(@PathVariable("id") String id) {
        return ResponseEntity.ok(userApplication.findById(id));
    }

}