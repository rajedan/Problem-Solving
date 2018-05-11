package lcode.contest54;

public class Question3 {
	public boolean canPartitionKSubsets(int[] nums, int k) {
        int total=0;
        for (int n : nums) {
            total+=n;
        }
        return total%k==0;
    }
	public static void main(String[] args) {
		int[] in = {7628, 3147, 7137, 2578, 7742, 2746, 4264, 7704, 9532, 9679, 8963, 3223, 2133, 7792, 5911, 3979};
		Question3 q = new Question3();
		System.out.println(q.canPartitionKSubsets(in, 6));
	}
}
