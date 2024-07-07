package sw;

import java.util.concurrent.ThreadLocalRandom;

import org.sikuli.script.FindFailed;
import org.sikuli.script.Screen;

import sw.PatternsPack;

public class Script implements PatternsPack{
	
	static int x, y, smallX, smallY = 0;
	private int victory, defeat, refill = 0;
	private String result;
	private Screen screen;
	
	public Script() {
		this.screen = new Screen();
		result = "fail";
	}
	
	
	public void start() {
		try {
			System.out.println("Starting...");
			screen.click(pStart.similar((float)0.8));

		}catch(FindFailed e) {
			System.out.print("shit start happens");
			e.printStackTrace();
		}
	}
	
	public void victory() {
		try {
			System.out.println("Victory..");
			screen.wait(pVictory.similar((float)0.8), 1*3);
	//		screen.wait(pRewards.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
		
	//		screen.wait(pChest.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
			
			System.out.println("Opening Chest...");

			//LOOTS! rarity > rare
			//symbols or rainbowmon or stuff --- press the tiny 'x'
	//		screen.wait(pX.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
			
			System.out.println("Got loots...");
			victory++;
		}catch(FindFailed e) {
			System.out.print("shit wins happens");
			e.printStackTrace();
		}
	}
	
	public void defeat() {
		try {
			screen.wait(pRevive.similar((float)0.8),1*3);
			System.out.println("Defeated...");
	//		screen.wait(pReviveNo.similar((float)0.8), 1*3).click();	
			screen.click(pReplay.similar((float)0.8));
	//		screen.wait(pDefeat.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
			defeat++;
		}catch(FindFailed e) {
			System.out.print("shit defeat happens");
			e.printStackTrace();
		}
	}

	public boolean recharge() {
		try{
			System.out.println("Attempting to recharge energy with crystals...");
		//	screen.wait(pRechargeYes.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
			//recharge energy
		//	screen.wait(pRechargeEnergy.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
		//	screen.wait(pRechargePurchaseYes.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));

			System.out.print("Purchased energy...");
			screen.wait(pPurchaseSuccessful.similar((float)0.8), 1*3);
		//	screen.wait(pPurchaseOK.similar((float)0.8), 1*5).click();
			screen.click(pReplay.similar((float)0.8));

			System.out.println("Resuming...");
		//	screen.wait(pRechargeClose.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
		//	screen.wait(pReplay.similar((float)0.8), 2).click();
			screen.click(pReplay.similar((float)0.8));
			refill++;

			//replay();
			return true;	
		}
		catch(FindFailed e){
			System.out.print("Recharge Failed");
			e.printStackTrace();
			return false;
		}
	}

	public void replay() {
		try {

			System.out.println("Attempt to replay...");
	//		screen.wait(pReplay.similar((float)0.8), 1*3).click();
			screen.click(pReplay.similar((float)0.8));
		}catch(FindFailed e) {
			System.out.print("shit in replay happens");
			e.printStackTrace();
		}
	}
	
	public static int getX(){
		x = ThreadLocalRandom.current().nextInt(-15, 15 + 1);
		return x;
	}
	public static int getY(){
		y = ThreadLocalRandom.current().nextInt(-15, 15 + 1);
		return y;
	}
	public static int getSmallX(){
		smallX = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		return smallX;
	}
	public static int getSmallY(){
		smallY = ThreadLocalRandom.current().nextInt(-5, 5 + 1);
		return smallY;
	}
	public int getVictory() {
		return victory;
	}
	public int getDefeat() {
		return defeat;
	}
	public int getRefill() {
		return refill;
	}	
	
	public void setResult(String r) {
		this.result = r;
	}
	public String getResult() {
		return result;
	}
	
	public void initializeOffSets(){
		System.out.println("Generating click points...");
		//initialize offsets
		pStart.targetOffset(getX(), getY());
		pVictory.targetOffset(getX(), getY());
		pRewards.targetOffset(getSmallX(), getSmallY());
		pChest.targetOffset(getX(), getY());
		pX.targetOffset(getSmallX(), getSmallY());
		pReplay.targetOffset(getX(), getY());

		pNoEnergy .targetOffset(getX(), getY());
		pRechargeYes.targetOffset(getX(), getY());
		pRechargeEnergy.targetOffset(getX(), getY());
		pRechargePurchaseYes.targetOffset(getX(), getY());

		pPurchaseSuccessful.targetOffset(getX(), getY());
		pPurchaseOK.targetOffset(getX(), getY());
		pRechargeClose.targetOffset(getX(), getY());

		pRevive.targetOffset(getX(), getY());
		pReviveNo.targetOffset(getX(), getY());
		pReviveYes.targetOffset(getX(), getY());
		pDefeat.targetOffset(getX(), getY());
	}

	
}
