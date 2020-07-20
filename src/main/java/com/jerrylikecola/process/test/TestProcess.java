package com.jerrylikecola.process.test;

import com.jerrylikecola.process.engine.ProcessEngine;
import com.jerrylikecola.process.step.Drink;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:54
 * @description
 */
@RestController
public class TestProcess {

    @Autowired
    private ProcessEngine processEngine;

    /**
     * 模仿一个制作饮料不同的品种不同的流程
     * @param drink
     * @return
     */
    @GetMapping("/get")
    public String makeDrink(@RequestParam String drink){
        Drink demo = new Drink();
        processEngine.turn(drink,demo);
        return demo.getCup()+demo.getContext();
    }
}
