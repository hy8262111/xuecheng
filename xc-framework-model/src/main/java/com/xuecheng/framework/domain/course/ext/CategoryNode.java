package com.xuecheng.framework.domain.course.ext;

import com.xuecheng.framework.domain.course.Category;
import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * Created by admin on 2018/2/7.
 */
@Data
@ToString
public class CategoryNode extends Category  implements Serializable {

    private static final long serialVersionUID = -3833832829931131631L;
    private List<CategoryNode> children;

}
