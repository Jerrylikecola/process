package com.jerrylikecola.process.engine;

import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.util.StringUtils;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:02
 * @description
 */
public interface Step<Context> {

    /**
     * 步骤运行
     *
     * @param context
     */
    void execute(Context context);

    /**
     * 获取步骤名字
     *
     * @return
     */
    default String getStepName() {
        ProcessStep processStep = AnnotationUtils.findAnnotation(this.getClass(), ProcessStep.class);
        if (processStep == null && StringUtils.isEmpty(processStep.name())) {
            return this.getClass().getSimpleName();
        }
        return processStep.name();
    }
}
