package com.spring.boot.mong.angular.app.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.repository.CrudRepository;

import com.spring.boot.mong.angular.app.entity.Employee;

public interface IEmployeeRepository extends MongoRepository<Employee, String> {
}
