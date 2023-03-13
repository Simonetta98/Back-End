package com.SpringDataEncrypt.runner;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import com.SpringDataEncrypt.model.Worker;
import com.SpringDataEncrypt.service.WorkerService;

@Component
public class WorkerRunner implements ApplicationRunner {

	@Autowired WorkerService workerSrv;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println("WorkerRunning...");
		
		//createWorkers();
	    //System.out.println(getWorkers());

	}
	
	public void createWorkers() {
		Worker w1 = Worker.builder()
				          .name("SimonaEncoded")
				          .secretPassword("1234")
				          .build();
		workerSrv.createWorker(w1);
		
		Worker w2 = Worker.builder()
		          .name("PippoEncoded")
		          .secretPassword("sonopippo")
		          .build();
		workerSrv.createWorker(w2);
		
		Worker w3 = Worker.builder()
		          .name("CarloEncoded")
		          .secretPassword("0000")
		          .build();
		workerSrv.createWorker(w3);
	}
	
	public List<Worker> getWorkers() {
		List<Worker> workers= workerSrv.getAllWorkers();
		return workers;
	}

}
