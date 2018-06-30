package psclass.basic.util;

/**
 * Integer Class
 * @author rajesh
 *
 */
public class MyInteger {
	int myInteger;
	
	/**
	 * Initializes value as 0
	 */
	public MyInteger() {
		myInteger = 0;
	}
	
	/**
	 * Initializes value as provided
	 * @param value
	 */
	public MyInteger(final int value) {
		myInteger = value;
	}
	
	public void setValue(int value) {
		myInteger = value;
	}
	
	public int getValue() {
		return myInteger;
	}
	
	@Override
	public String toString() {
		return String.valueOf(myInteger);
	}
}
