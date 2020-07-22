package com.jerrylikecola.process.ext.engine;

import com.jerrylikecola.process.ext.ProcessTik;
import com.jerrylikecola.process.ext.base.Ext;
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
 * @date 2020/7/21 17:10
 * @description
 */

@Component
public class ExtRegistry implements ApplicationContextAware {
    private Map<String, Ext> extMap;

    public <T extends Ext> T getExt(String uniquelyCode) {
        return (T)extMap.get(uniquelyCode);
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        extMap = new HashMap<>(512);
//        Map<String, Object> beanMap = applicationContext.getBeansWithAnnotation(ProcessTik.class);
//        if (!CollectionUtils.isEmpty(beanMap)) {
//            beanMap.forEach((beanName, ext) -> {
//                ProcessTik processTik = AnnotationUtils.findAnnotation(ext.getClass(), ProcessTik.class);
//                if (ClassUtils.isAssignableValue(Ext.class, ext)) {
//                    String uniquelyCode = StringUtils.isEmpty(processTik.uniquelyCode()) ? ext.getClass().getSimpleName() : processTik.uniquelyCode();
//                    extMap.put(uniquelyCode, (Ext) ext);
//                }
//            });
//        }
        Map<String, Ext> beanMap = applicationContext.getBeansOfType(Ext.class);
        if (!CollectionUtils.isEmpty(beanMap)) {
            beanMap.forEach((beanName, ext) -> {
                ProcessTik processTik = AnnotationUtils.findAnnotation(ext.getClass(), ProcessTik.class);
                if (ClassUtils.isAssignableValue(Ext.class, ext)) {
                    String uniquelyCode = StringUtils.isEmpty(processTik.uniquelyCode()) ? ext.getClass().getSimpleName() : processTik.uniquelyCode();
                    extMap.put(uniquelyCode, ext);
                }
            });
        }
    }
}
