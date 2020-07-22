package com.jerrylikecola.process.ext.base;

import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.base.Ext;

/**
 * @author xiaxiang
 * @date 2020/7/21 14:03
 * @description 倒入物料扩展点
 */
public interface EnrichContextExt extends Ext {

    /**
     * 倒入渴望的饮料
     * @param drink
     */
    void enrichContext(Drink drink);
}
