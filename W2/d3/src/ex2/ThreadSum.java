package ex2;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ThreadSum extends Thread{
	Logger log = LoggerFactory.getLogger(ThreadSum.class);
	
    int[] mille;
    int somma;
	
	public ThreadSum(int [] arr, int start, int end) {
		 mille = Arrays.copyOfRange(arr, start, end);
		 
		  ///controllavo se era tutto ok
		 /*for(int i=0; i<mille.length; i++) {
			 System.out.println(mille[i]);
		 }
		 System.out.println(mille.length);*/
	}
	
	@Override
	public void run() {
		//override metodo run
		 int sum = IntStream.of(mille).sum();
		 log.info("La somma è " + sum);
		 somma = sum;
    }
	public int getSomma() {
		return somma;
	}
}