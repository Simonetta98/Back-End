package ex1;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSample extends Thread {
	Logger log = LoggerFactory.getLogger(ThreadSample.class);
	
	String message;
	
	public ThreadSample(String mess) {
		message = mess;
	}
	
	@Override
	public void run() {
		//override metodo run
		try {
			for(int i=0; i<10; i++) {
				sleep(1000);
				log.info(message);
		    }
		
		}catch(InterruptedException e) {
			System.out.println("ERRORE: " + e);
		}
	}
}
