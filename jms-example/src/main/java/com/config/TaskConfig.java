package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.SimpleAsyncTaskExecutor;
import org.springframework.core.task.TaskExecutor;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * Created by jt on 2019-07-17.
 */
//включает планировшик задач. Т е говорит спрингу слушать дальше, вдруг что то прийдет еще
@EnableScheduling
//включает выполнение задач из пула задач
@EnableAsync
@Configuration
public class TaskConfig {
    //запускаем асинхронню задачу
    @Bean
    TaskExecutor taskExecutor() {
        return new SimpleAsyncTaskExecutor();
    }
}
