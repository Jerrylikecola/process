package com.jerrylikecola.process.ext.base;

import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.base.Ext;

/**
 * @author xiaxiang
 * @date 2020/7/21 14:01
 * @description 洗杯子扩展点
 */
public interface WashCupExt extends Ext {

    /**
     * 洗杯子，并决定采用什么样的杯子
     * @param drink
     */
    void washCup(Drink drink);
}
