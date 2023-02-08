package ex1;

public class MainProject {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		ThreadSample hashtag = new ThreadSample("#");
		ThreadSample asterisk = new ThreadSample("*");
		
		hashtag.start();
		asterisk.start();

	}

}
