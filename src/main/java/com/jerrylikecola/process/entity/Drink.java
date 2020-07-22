package com.jerrylikecola.process.entity;

import lombok.Data;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:47
 * @description 过程步骤流转中的上下文对象
 */
@Data
public class Drink {

    private String uniquelyCode = "";

    /**
     * xia ji ba qu de
     */
    private String cup = "";
    /**
     * xia ji ba qu de
     */
    private String context = "";

    private String extra = "";
}
