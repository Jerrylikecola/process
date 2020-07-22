package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;
import com.jerrylikecola.process.entity.Drink;

/**
 * @author xiaxiang
 * @date 2020/7/22 10:20
 * @description
 */
@ProcessStep(name = "pullFlower")
public class PullFlower implements Step<Drink>{

    @Override
    public void execute(Drink drink) {
        drink.setExtra("飘着好看的拉花");
    }
}
