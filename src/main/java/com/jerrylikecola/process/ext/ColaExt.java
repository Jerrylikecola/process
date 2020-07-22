package com.jerrylikecola.process.ext;

import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.base.CommonExt;
import org.springframework.stereotype.Component;

/**
 * @author xiaxiang
 * @date 2020/7/21 14:04
 * @description 制作可乐的扩展方法集
 */

@Component
@ProcessTik(uniquelyCode = "cola")
public class ColaExt implements CommonExt {

    @Override
    public void enrichContext(Drink drink) {
        drink.setContext("用新的方式倒满了可乐");
    }

    @Override
    public void washCup(Drink drink) {
        drink.setCup("用新的方式洗干净的玻璃杯");
    }
}
