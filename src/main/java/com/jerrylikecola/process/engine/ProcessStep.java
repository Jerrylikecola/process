package com.jerrylikecola.process.engine;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:04
 * @description
 */

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ProcessStep {

    /**
     * 流程名字
     * @return
     */
    String name() default "";
}
