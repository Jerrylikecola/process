package com.jerrylikecola.process.engine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:11
 * @description
 */

@Component
public class ProcessRegistry implements ApplicationListener<ContextRefreshedEvent> {

    @Autowired
    private StepRegistry stepRegistry;

    private Map<Process, List<Step>> processMap = new HashMap<>();

    public void add(Process process){
        List<Step> steps = process.getStepList().stream().map(stepRegistry::getStep).collect(Collectors.toList());
        this.processMap.put(process,steps);
    }

    public void addAll(List<Process> processes){
        processes.forEach(this::add);
    }

    public List<Step> getProcessSteps(String uniquelyCode){
        Process process = new Process();
        process.setUniquelyCode(uniquelyCode);
        return this.processMap.get(process);
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        //可扩展
    }
}
