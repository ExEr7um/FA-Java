package com.exer7um.rest.repository;

import com.exer7um.rest.entity.Category;
import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
}
