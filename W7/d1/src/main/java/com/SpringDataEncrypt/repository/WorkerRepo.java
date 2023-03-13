package com.SpringDataEncrypt.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.SpringDataEncrypt.model.Worker;

@Repository
public interface WorkerRepo extends CrudRepository<Worker, Long> {

}
