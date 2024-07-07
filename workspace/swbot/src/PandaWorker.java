import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingWorker;

import org.sikuli.script.App;
import org.sikuli.script.Match;
import org.sikuli.script.Screen;

public class PandaWorker extends SwingWorker<String, String> implements PatternsPack{

	private JPanel contentPane;
	private JTextField textFieldRuns;
	private JTextField textFieldApp;
	private JButton btnStart, btnStop;
	private String appName;
	private int runs;
	private Thread th;
	private volatile boolean flag = false;
	
	public PandaWorker(JTextField textFieldRuns, JTextField textFieldApp) {
	    this.appName = textFieldApp.getText();
	    this.runs = Integer.parseInt(textFieldRuns.getText());
	}
	
	@Override
	  protected String doInBackground() throws Exception {
		 publish("What");	 
		 try {
				System.out.println(appName);
				App app = new App(appName);
				Screen screen = new Screen();
				System.out.println("2");
				Script script = new Script();
				System.out.println("1");
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
		
					script.replay();
		
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
			catch(Exit e) {
				e.printStackTrace();
			}
		 
		 
		return null;
	 }
	
	

}
