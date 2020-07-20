package com.jerrylikecola.process.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * @author xiaxiang
 * @date 2020/7/20 14:58
 * @description
 */

@Component
public class ProcessEngine {

    /**
     * 流程注册器
     */
    @Autowired
    private ProcessRegistry processRegistry;

    /**
     * 流程运行
     * @param uniquelyCode
     * @param context
     */
    public void turn(String uniquelyCode, Object context) {
        List<Step> steps = processRegistry.getProcessSteps(uniquelyCode);
        steps.forEach(step ->{
            step.execute(context);
        });
    }
}
