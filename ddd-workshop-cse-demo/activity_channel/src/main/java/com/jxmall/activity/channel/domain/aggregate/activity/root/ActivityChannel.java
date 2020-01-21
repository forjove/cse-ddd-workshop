package com.jxmall.activity.channel.domain.aggregate.activity.root;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ActivityChannel {
    private String id;

    private String name;

    private String email;

    private String address;

    private int age;

    private String[] labels;
}
