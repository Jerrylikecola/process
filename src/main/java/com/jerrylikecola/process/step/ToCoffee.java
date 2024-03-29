package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;
import com.jerrylikecola.process.entity.Drink;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:52
 * @description
 */
@ProcessStep(name = "toCoffee")
public class ToCoffee<Context extends Drink> implements Step<Context> {

    @Override
    public void execute(Context context) {
        context.setContext("里面装满了咖啡");
    }
}
