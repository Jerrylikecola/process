package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;
import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.engine.ExtRegistry;
import com.jerrylikecola.process.ext.base.WashCupExt;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:45
 * @description
 */
@ProcessStep(name = "washCup")
public class WashCup implements Step<Drink> {

    @Autowired
    private ExtRegistry extRegistry;

    @Override
    public void execute(Drink drink) {
        WashCupExt washCupExt = extRegistry.getExt(drink.getUniquelyCode());
        washCupExt.washCup(drink);
    }
}
