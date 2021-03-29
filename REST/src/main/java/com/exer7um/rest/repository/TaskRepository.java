package com.exer7um.rest.repository;

import com.exer7um.rest.entity.Task;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepository extends CrudRepository<Task, Long> {

}
