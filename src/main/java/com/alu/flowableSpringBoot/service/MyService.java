package com.alu.flowableSpringBoot.service;

import com.alu.flowableSpringBoot.model.Person;
import com.alu.flowableSpringBoot.repository.PersonRepository;
import org.flowable.engine.RuntimeService;
import org.flowable.engine.TaskService;
import org.flowable.task.api.Task;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author jairy
 * @date 2020/4/28
 */
@Service
@Transactional
public class MyService {

    @Autowired
    private RuntimeService runtimeService;

    @Autowired
    private TaskService taskService;

    @Autowired
    private PersonRepository personRepository;

//    @Transactional
//    public void startProcess() {
//        runtimeService.startProcessInstanceByKey("oneTaskProcess");
//    }
//
//    @Transactional
//    public List<Task> getTasks(String assignee) {
//        return taskService.createTaskQuery().taskAssignee(assignee).list();
//    }


    public void startProcess(String assignee) {

        Person person = personRepository.findByUsername(assignee);

        Map<String, Object> variables = new HashMap<>();
        variables.put("person", person);
        runtimeService.startProcessInstanceByKey("oneTaskProcess", variables);

    }

    public List<Task> getTasks(String assignee) {
        return taskService.createTaskQuery().taskAssignee(assignee).list();
    }

    public void createDemoUsers() {
        if (personRepository.findAll().size() == 0) {
            personRepository.save(new Person("jbarrez", "Joram", "Barrez", new Date()));
            personRepository.save(new Person("trademakers", "Tijs", "Rademakers", new Date()));
        }
    }

}
