import org.sikuli.script.App;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class Panda extends Thread implements Runnable ,PatternsPack{

	private String appName;
	private int runs;

	public Panda(String appName, int runs) {
		this.appName = appName;
		this.runs = runs;
	}

	//	public void runPandaBot() {
	//
	//		th = new Thread(new Runnable() {
	@Override
	public void run(){	 
		try {
				App app = new App(appName);
				System.out.println(appName + " is initiated");
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
						} //edited this for sd
						else if(screen.exists(pRewards.similar((float)0.9))!= null) {
							result = screen.exists(pRewards.similar((float)0.9));
							System.out.println(result.toString());
							script.setResult("success");
						}
					}
					while (result == null);

					app.focus();
					
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
				
			
		}
//		catch(InterruptedException e) {
//			System.out.println("lo"+Thread.currentThread().isInterrupted());
//			Thread.currentThread().interrupt();
//			System.out.println(Thread.currentThread().isInterrupted());
//		
//		throw new InterruptedException();
//		}
//		}
		
		catch(FindFailed ff) {
			System.out.println("lo"+Thread.currentThread().isInterrupted());
			Thread.currentThread().interrupt();
			System.out.println(Thread.currentThread().isInterrupted());
			ff.printStackTrace();
			return;
		}
	

	}			
	//		});
	//		th.start();
	//	}

}