package com.jxmall.activity.qualification.domain.aggregate.activity.root;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ActivityQualification {

    private String id;

    private String name;

    private String content;

    private Date startDate;

    private Date endDate;
}
