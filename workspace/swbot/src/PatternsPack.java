import org.sikuli.script.Pattern;

public interface PatternsPack {
	static final Pattern pStart = new Pattern("src/img/720x1280/startBattle.png");
	static final Pattern pVictory = new Pattern("src/img/720x1280/victory.png");
	static final Pattern pRewards = new Pattern("src/img/720x1280/reward.png");
	static final Pattern pChest = new Pattern("src/img/720x1280/chest.png");	
	static final Pattern pX = new Pattern("src/img/720x1280/x.png");	
	static final Pattern pReplay = new Pattern("src/img/720x1280/replay.png");	

	static final Pattern pNoEnergy = new Pattern("src/img/720x1280/noEnergy.png");
	static final Pattern pRechargeYes = new Pattern("src/img/720x1280/rechargeYes.png");
	static final Pattern pRechargeEnergy = new Pattern("src/img/720x1280/rechargeEnergy.png");
	static final Pattern pRechargePurchaseYes = new Pattern("src/img/720x1280/rechargePurchaseYes.png");
	
	static final Pattern pPurchaseSuccessful = new Pattern("src/img/720x1280/purchaseSuccessful.png");
	static final Pattern pPurchaseOK = new Pattern("src/img/720x1280/purchaseOK.png");
	static final Pattern pRechargeClose = new Pattern("src/img/720x1280/rechargeClose.png");

	static final Pattern pRevive = new Pattern("src/img/720x1280/revive.png");
	static final Pattern pReviveNo = new Pattern("src/img/720x1280/reviveNo.png");
	static final Pattern pReviveYes = new Pattern("src/img/720x1280/reviveYes.png");
	static final Pattern pDefeat = new Pattern("src/img/720x1280/defeat.png");
	
//  checks pattern validility
//	System.out.println(pStart.isValid());
//	System.out.println(pVictory.isValid());
//	System.out.println(pRewards.isValid());
//	System.out.println(pChest.isValid());
//	System.out.println(pX.isValid());
//	System.out.println(pReplay.isValid());
}