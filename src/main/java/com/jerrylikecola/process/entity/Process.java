package com.jerrylikecola.process.entity;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.List;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:25
 * @description Process流程的对应JAVA类 JSON->JAVA
 */
@Data
@EqualsAndHashCode(of = "uniquelyCode")
public class Process implements Serializable {

    /**
     * 唯一值
     */
    private String uniquelyCode;

    /**
     * 步骤集合
     */
    private List<String> stepList;
}
