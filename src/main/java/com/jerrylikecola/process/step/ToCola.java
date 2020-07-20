package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:52
 * @description
 */
@ProcessStep(name = "toCola")
public class ToCola<Context extends Drink> implements Step<Context> {

    @Override
    public void execute(Context context) {
        context.setContext("里面装满了可乐");
    }
}
