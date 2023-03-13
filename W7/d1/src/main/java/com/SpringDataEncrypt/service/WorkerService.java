package com.SpringDataEncrypt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringDataEncrypt.model.Worker;
import com.SpringDataEncrypt.repository.WorkerRepo;

@Service
public class WorkerService {

@Autowired WorkerRepo repo;
	
	public String createWorker(Worker w) {
		repo.save(w);
		return "Worker created";
	}
	public String updateWorker(Worker w) {
		repo.save(w);
		return "Worker updated";
	}
	public String deleteWorker(Worker w) {
		repo.delete(w);
		return "Worker deleted";
	}
	
	
	public List<Worker> getAllWorkers() {
		return (List<Worker>) repo.findAll();
	}
}
