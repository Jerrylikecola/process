package com.jerrylikecola.process.step;

import com.jerrylikecola.process.engine.ProcessStep;
import com.jerrylikecola.process.engine.Step;
import com.jerrylikecola.process.entity.Drink;
import com.jerrylikecola.process.ext.base.EnrichContextExt;
import com.jerrylikecola.process.ext.engine.ExtRegistry;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * @author xiaxiang
 * @date 2020/7/21 17:25
 * @description
 */
@ProcessStep(name = "toDrink")
public class ToDrink implements Step<Drink> {

    @Autowired
    private ExtRegistry extRegistry;

    @Override
    public void execute(Drink drink) {
        EnrichContextExt enrichContextExt = extRegistry.getExt(drink.getUniquelyCode());
        enrichContextExt.enrichContext(drink);
    }
}
