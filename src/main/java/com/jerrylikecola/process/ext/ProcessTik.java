package com.jerrylikecola.process.ext;

import org.springframework.stereotype.Component;

import java.lang.annotation.*;

/**
 * @author xiaxiang
 * @date 2020/7/21 17:08
 * @description
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE)
@Component
public @interface ProcessTik {

    /**
     * 唯一值，用来标注流程
     * @return
     */
    String uniquelyCode() default "";
}
