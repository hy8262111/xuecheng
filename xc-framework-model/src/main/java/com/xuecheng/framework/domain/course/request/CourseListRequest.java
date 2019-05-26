package com.xuecheng.framework.domain.course.request;

import com.xuecheng.framework.model.request.RequestData;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;

/**
 * Created by mrt on 2018/4/13.
 */
@Data
@ToString
public class CourseListRequest extends RequestData implements Serializable {
    private static final long serialVersionUID = -115314451412866488L;
    //公司Id
    private String companyId;
}
