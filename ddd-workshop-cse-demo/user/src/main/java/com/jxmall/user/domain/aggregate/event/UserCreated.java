package com.jxmall.user.domain.aggregate.event;

import org.springframework.context.ApplicationEvent;

import lombok.Getter;

public class UserCreated extends ApplicationEvent {

    public UserCreated(Object source , String userId) {
        super(source);
        this.userId = userId;
    }

    private static final long serialVersionUID = 1L;

    @Getter
    private String userId;
}