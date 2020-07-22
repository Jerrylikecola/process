package com.jerrylikecola.process.ext;

import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.base.CommonExt;
import org.springframework.stereotype.Component;

/**
 * @author xiaxiang
 * @date 2020/7/21 14:08
 * @description 制作咖啡的扩展点方法集
 */

@Component
@ProcessTik(uniquelyCode = "coffee")
public class CoffeeExt implements CommonExt {

    @Override
    public void enrichContext(Drink drink) {
        drink.setContext("用新的方式倒满了咖啡");
    }

    @Override
    public void washCup(Drink drink) {
        drink.setCup("用新的方式洗干净的咖啡杯");
    }
}
