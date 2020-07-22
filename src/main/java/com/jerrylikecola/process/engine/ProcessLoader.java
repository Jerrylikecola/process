package com.jerrylikecola.process.engine;

import com.alibaba.fastjson.JSON;
import com.google.common.base.Charsets;
import com.google.common.io.CharStreams;
import com.jerrylikecola.process.entity.Process;
import org.springframework.context.ApplicationContext;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * @author xiaxiang
 * @date 2020/7/20 15:07
 * @description 将配置文件中的.json文件转换成java对象
 */

@Component
public class ProcessLoader {

    /**
     * default path to resource
     */
    private static final String DEFAULT_PATH = "process/process_*.json";

    private final ApplicationContext applicationContext;
    private final ProcessRegistry processRegistry;

    public ProcessLoader(ApplicationContext applicationContext, ProcessRegistry processRegistry) {
        this.applicationContext = applicationContext;
        this.processRegistry = processRegistry;
    }

    @PostConstruct
    public void init() throws IOException {
        List<Process> processes = loadProcess(DEFAULT_PATH);
        processRegistry.addAll(processes);
    }

    private List<Process> loadProcess(String resourcePath) throws IOException {
        List<Process> processes = new ArrayList<>();
        Resource[] resources = applicationContext.getResources(ResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + resourcePath);
        for (Resource resource:resources) {
            String json = CharStreams.toString(new InputStreamReader(resource.getInputStream(), Charsets.UTF_8));
            processes.addAll(JSON.parseArray(json,Process.class));
        }
        return processes;
    }
}
