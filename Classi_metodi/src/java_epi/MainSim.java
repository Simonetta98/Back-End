package java_epi;

public class MainSim {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[][] arrChiam = {
				{"called: 8009283", "10.5 min"},  //number and minutes
				{"called: 4909282", "4.2 min"},
				{"called: 118", "1.1 min"},
				{"called: 112", "0.5 min"},
				{"called: 289475", "30.10 min"}
		};
		
		CartaSim sim1 = new CartaSim("3426335687", 3, arrChiam);
		CartaSim.stampaSim(sim1);

	}

}
