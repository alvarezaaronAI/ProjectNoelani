package Formulas;

/*
 * Interface that every Tree must have in order to know if it needs any
 * assistance.
 * @author alvarezaaronAI
 */
public interface TreeConsumptions {
	/**
	 * Methods that calculate every tree consumption and current temperature
	 * 
	 * @return
	 */
	/*
	 * Water Consumption of a Tree
	 */
	public void waterConsumptionGal();

	/*
	 * Current Temperature of the tree Outer which could improve how dry a tree
	 * is currently.
	 */
	public void temperatureCurrentOut(double temp);

	/*
	 * Current Temperature of the Tree Inner which could improve how dry a tree
	 * is currently.
	 */
	public void temperatureCurrentInn(double temp);

	/*
	 * How Dry a tree is, in order to add more water
	 */
	public void isItDry(double value);

}
