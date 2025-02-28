class Solution {
    public int lastStoneWeight(int[] stones) {
        PriorityQueue<Integer> temp = new PriorityQueue<>(Collections.reverseOrder());
        for(int n : stones){
            temp.offer(n);
        }

        while(temp.size() > 1){
            int a = temp.poll();
            int b = temp.poll();
            if(a != b){
                temp.offer(a -b);
            }
        }
        return temp.isEmpty() ? 0 : temp.peek();
        
    }
}
