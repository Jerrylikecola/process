package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:45
 * @description
 */
@ProcessStep(name = "washCup")
public class WashCup<Context extends Drink> implements Step<Context> {

    @Override
    public void execute(Drink drink) {
        drink.setCup("洗干净的陶瓷杯");
    }
}
