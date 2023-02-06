package ex3;

public class BancaException extends Exception {
	public BancaException(String mess) {
		super(mess);
	}
	
public String toString(String mess) {
	return mess;
}

}
