package com.alu.flowableSpringBoot;

import com.alu.flowableSpringBoot.service.MyService;
import org.flowable.engine.RepositoryService;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

/**
 * @author jairy
 * @date 2020/4/28
 */
@SpringBootApplication
public class MyApplication {

    public static void main(String[] args) {
        SpringApplication.run(MyApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner init(final RepositoryService repositoryService,
//                                  final RuntimeService runtimeService,
//                                  final TaskService taskService) {
//
//        return new CommandLineRunner() {
//            @Override
//            public void run(String... strings) throws Exception {
//                System.out.println("Number of process definitions : " + repositoryService.createProcessDefinitionQuery().count());
//
//                System.out.println("Number of tasks : " + taskService.createTaskQuery().count());
//
//                runtimeService.startProcessInstanceByKey("oneTaskProcess");
//
//                System.out.println("Number of tasks after process start: " + taskService.createTaskQuery().count());
//            }
//        };
//    }

    @Bean
    public CommandLineRunner init(final MyService myService) {

        return new CommandLineRunner() {
            @Override
            public void run(String... strings) throws Exception {
                myService.createDemoUsers();
            }
        };
    }
}
