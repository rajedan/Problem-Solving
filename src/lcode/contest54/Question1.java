package lcode.contest54;

import java.util.HashMap;

public class Question1 {
    class Node {
        int count;
        int start;
        int end;
        public Node(int count, int start, int end) {
            this.count=count;
            this.start=start;
            this.end = end;
        }
        public Node(){}
    }
    public int findShortestSubArray(int[] nums) {
        HashMap<Integer, Node> map = new HashMap<Integer, Node>();
        int index = 0;
        for (int num : nums) {
            if(map.containsKey(num)) {
                Node node = map.get(num);
                node.count = node.count+1;
                node.end = index;
            } else {
                Node node = new Node(1, index, index);
                map.put(num, node);
            }
            index++;
        }
        Node maxNode = new Node(0,0,0);
        int tempCount=0;
        for (int key: map.keySet()) {
            Node node = map.get(key);
            if (node.count > tempCount) {
                maxNode = node;
                tempCount = node.count;
            } if (node.count == tempCount) {
            	if((maxNode.end-maxNode.start) > (node.end-node.start)) {
            		maxNode = node;
            	}
            }
        }
        return maxNode==null?0:(maxNode.end-maxNode.start+1);
    }
    public static void main(String[] args) {
		int[] in = {1,2,2,3,1};
		Question1 q = new Question1();
		System.out.println(q.findShortestSubArray(in));
	}
}
