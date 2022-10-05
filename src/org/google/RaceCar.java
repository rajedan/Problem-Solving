package org.google;

public class RaceCar {
	public int racecar(int target) {
		int pos = 0, speed = 1;
		// char[] action = {'A', 'R'};
		return racecarHelper(pos, speed, target);
	}

	private int racecarHelper(int pos, int speed, int target) {
		if (target == 0 || target == pos) {
			return 0;
		}
		if (target < -1) return Integer.MAX_VALUE;
		//lets take A
		int newPos, newSpeed, lengthOfInstruction1 = Integer.MAX_VALUE, lengthOfInstruction2 = Integer.MAX_VALUE;
		if (target > pos || speed < 0) {
			newPos = pos + speed;
			newSpeed = speed * 2;
			lengthOfInstruction1 = 1 + racecarHelper(newPos, newSpeed, target);
		} else {
			//lets take R
			if (speed > 0) newSpeed = -1;
			else newSpeed = 1;
			lengthOfInstruction2 = 1 + racecarHelper(pos, newSpeed, target);
		}

		return Math.min(lengthOfInstruction1, lengthOfInstruction2);
	}

	public static void main(String[] args) {
		RaceCar rc = new RaceCar();
		int out = rc.racecar(6);
		System.out.println(out);
	}
}
