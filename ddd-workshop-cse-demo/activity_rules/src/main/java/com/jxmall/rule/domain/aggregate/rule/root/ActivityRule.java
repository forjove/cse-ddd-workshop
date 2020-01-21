package com.jxmall.rule.domain.aggregate.rule.root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityRule {
    private String id;

    private int month;

    private int source;
}

