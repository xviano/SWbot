import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Panda implements PatternsPack{

	private String appName;
	private int runs;

	public static void main(String[] args) {
		String appName = "Nox";
		int runs = 20;
		Panda p = new Panda(appName, runs);
		p.runPandaBot();
		return;
	}


	public Panda(String appName, int runs) {
		this.appName = appName;
		this.runs = runs;
	}

	public boolean runPandaBot() {
		try {
			App app = new App(appName);
			System.out.println(appName + "is initiated");
			Screen screen = new Screen();
			System.out.println("Screen is initiated");
			Script script = new Script();

			if(app.isRunning()){
				System.out.println(app + " is running");
				app.focus();
			}

			Match result = null;

			for (int i = 1 ; i <= runs ; i++) {		
				System.out.println("========== Loop #"+ i +" Started");

				script.initializeOffSets();
				script.start();

				do {
					if(screen.exists(pRevive.similar((float)0.9))!= null) {
						result = screen.exists(pRevive.similar((float)0.9));
						System.out.println(result.toString());
						script.setResult("fail");
					}
					else if(screen.exists(pVictory.similar((float)0.9))!= null) {
						result = screen.exists(pVictory.similar((float)0.9));
						System.out.println(result.toString());
						script.setResult("success");
					}
				}
				while (result == null);

				if(script.getResult().equals("success")) {
					script.victory();
				}
				else {
					script.defeat();
				}

				if(screen.exists(pNoEnergy.similar((float)0.8))!=null) {
					System.out.print("No energy...");
					script.recharge();
				}

				result = null;
			}
			System.out.println("End of " + runs + " Loops ==========");
			System.out.println("Victory :" + script.getVictory());
			System.out.println("Defeat : " + script.getDefeat());
			System.out.println("Refills Spent :" + script.getRefill());	 
		}catch(Exception e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}
}
