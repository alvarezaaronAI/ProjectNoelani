package Vegetation;

import Formulas.TreeConsumptions;
import OtherClasses.Time;

/**
 * Redbud Tree Information credit to url
 * https://www.arborday.org/trees/treeguide/treedetail.cfm?itemID=912
 * 
 * The idea is to create a class Specific to REDBUD Tree and know when it really
 * needs attention to be a healthy tree all the time.
 * 
 * We must know the state of the tree every hour or when temperature increases
 * dramatically which allows us to treat the tree before it major damage is
 * done.
 * 
 * @author alvarezaaronAI
 *
 */
public class TreeRedbud implements TreeConsumptions {

	/**
	 * Member Variables of Redbud Tree
	 */
	private final String NAME = "Redbud Tree";
	private final double MAX_HEIGHT = 30.0;
	private final double MAX_WIDTH = 36.0;
	private final double DRY = 0.4;
	private final double GROWTH_RATE_YEARLY = 13;
	
	
	private double heightFeet;
	private double trunkWidthFeet;
	private double weightLBS;
	private double shadingAreaInches2;
	private int oldnessYear;
	
	private Time time;
	private double tempOut;
	private double tempIn;
	private double waterConsump;
	private boolean isItDry;
	

	/**
	 * Create Constructors
	 */
	/*
	 * Tree Default
	 */

	public TreeRedbud() {
		this.heightFeet = 16.0;
		this.trunkWidthFeet = 20.8;
		this.weightLBS = 39.65;
		this.shadingAreaInches2 = Math.PI * Math.pow(2, (this.trunkWidthFeet / 2) * 12.0);
		this.oldnessYear = 10;
	}

	/*
	 * Tree User Creator
	 */
	public TreeRedbud(double heightFeet, double trunkWidthFeet, double weightLBS, int oldness) {
		super();
		this.heightFeet = heightFeet;
		this.trunkWidthFeet = trunkWidthFeet;
		this.weightLBS = weightLBS;
		this.shadingAreaInches2 = Math.PI * Math.pow(2, (this.trunkWidthFeet / 2) * 12.0);
		this.oldnessYear = oldness;
		this.time = new Time();
	}


	/*
	 * Water consumption which can improve our probably when it will run out of
	 * water in a feature senerio. (non-Javadoc)
	 * 
	 * @see Formulas.TreeConsumptions#waterConsumptionGal()
	 */
	@Override
	public void waterConsumptionGal() {
		// Apply 10 galons of water per trunchInch
		double tempTWInches = this.trunkWidthFeet * 12;
		double tempGalWater = tempTWInches * 10;
		this.waterConsump = tempGalWater;
	}

	
	/*
	 * temperature of the outerPart of the tree, where sun may hit, maybe use to
	 * future calculations to calculate the dryness, or improve how dry a tree
	 * dryness is. (non-Javadoc)
	 * 
	 * @see Formulas.TreeConsumptions#temperatureCurrentOut(double)
	 */
	@Override
	public void temperatureCurrentOut(double temp) {
		double tempTemperature = temp;
		this.tempOut = temp;
	}

	/*
	 * temperature of the shade, maybe use to future calculations to calculate
	 * the dryness, or improve how dry a tree is. (non-Javadoc)
	 * 
	 * @see Formulas.TreeConsumptions#temperatureCurrentInn(double)
	 */
	@Override
	public void temperatureCurrentInn(double temp) {
		double tempTemperature = temp;
		this.tempIn = temp;
	}

	/*
	 * Method that takes in a value from 0 to 1, 0 being dry and 1 moist RedBud
	 * Tree is dry when it it goes below 0.4 (non-Javadoc)
	 * 
	 * @see Formulas.TreeConsumptions#currentDryNess(double)
	 */
	@Override
	public void isItDry(double value) {
		if (this.DRY >= value) {
			this.isItDry =  true;
		}
		this.isItDry = false;
	}
	
	/*
	 *  Udpate per hour if return true throwWater
	 */
	public boolean hourlyUpdate(double tempIn, double tempOut) {
		this.time.updateTime();
		temperatureCurrentInn(tempIn);
		temperatureCurrentOut(tempOut);
		if(this.tempOut > 90){
			//Trow Water
			return true;
		}
		return false;
	}
	/*
	 * Public Method that updates every Day if return true throwwater
	 */
	public boolean dayUpdate(double tempIn, double tempOut, boolean isItDry) {
		this.time.updateTime();
		temperatureCurrentInn(tempIn);
		temperatureCurrentOut(tempOut);
		if (isItDry) {
			return true;
		}
		if( tempIn > 65 && tempOut > 80){
			return true;
		}
		return false;
		
	}
	/*
	 * public Method that updates every year
	 */
	public boolean yearlyUpdate(double tempIn, double tempOut, boolean isItDry) {
		//Time
		this.time.updateTime();
		//this is keeping track of the height of the tree
		
		double heightInches= (this.heightFeet * 12) + 8;
		this.heightFeet = heightInches /12.0;
		//if it passes the height its automatically set back to the maximun growth of this tree
		if(this.heightFeet > MAX_HEIGHT){
			this.heightFeet = MAX_HEIGHT;
		}
		//keep track of width of tree
		double widthInches= (this.trunkWidthFeet * 12) + 8;
		this.trunkWidthFeet = widthInches /12.0;
		if (this.trunkWidthFeet > MAX_WIDTH) {
			this.trunkWidthFeet = MAX_WIDTH;
		}
		//update the waterConsumption
		this.waterConsump = waterCalc();
		if (isItDry) {
			return true;
		}
		return false;
		
	}
	/**
	 * Method that acts upon assistnace.
	 */
	/*
	 * Method that will know if this tree needs assitance. that takes in 1 or 0,
	 * 1 defining that it needs assistance and 0 meaning no assitance else -1 of
	 * the value was not in range of the method.
	 */
	public int needsAssitance(int value) {
		if (value == 1) {
			return 1;
		} else if (value == 0) {
			return 0;
		} else {
			return -1;
		}
	}
	
	/*
	 * Private method that checks if how much water and returns a value double
	 * from 0 to 1
	 */
	private double waterCalc() {
		double tempCurrWater = this.currentWater;
		//convert into a percent value between 0 to 1
		double 
	}
}
