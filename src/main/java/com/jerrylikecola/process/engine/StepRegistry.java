package com.jerrylikecola.process.engine;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.StringUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:13
 * @description
 */

@Component
public class StepRegistry implements ApplicationContextAware {

    private Map<String, Step> stepMap;

    public Step getStep(String stepName) {
        return stepMap.get(stepName);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        stepMap = new HashMap<>(512);
        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(ProcessStep.class);
        if (!CollectionUtils.isEmpty(beanMap)) {
            beanMap.forEach((beanName, step) -> {
                ProcessStep processStep = AnnotationUtils.findAnnotation(step.getClass(), ProcessStep.class);
                if (ClassUtils.isAssignableValue(Step.class, step)) {
                    String stepName = StringUtils.isEmpty(processStep.name()) ? step.getClass().getSimpleName() : processStep.name();
                    stepMap.put(stepName, (Step) step);
                }

            });
        }
    }
}
