
/**
 * Write a description of class Player here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */

public class RNG{

	public int maximumValue;
	public int minimumValue;
	public int getMaximumValue() {
		return maximumValue;
	}
	public void setMaximumValue(int maximumValue) {
		this.maximumValue = maximumValue;
	}
	public int getMinimumValue() {
		return minimumValue;
	}
	public void setMinimumValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}
	
	@Override
	public String toString() {
		return "RNG [maximumValue=" + maximumValue + ", minimumValue=" + minimumValue + "]";
	}
	
	
}
