class Solution {
    public void bfs(Queue<int[]> queue , boolean [][] reachable , int[][] heights){
        int ROWS = heights.length , COLS  = heights[0].length;
        int [][] directions = {{1,0},{-1,0} , {0,1} , {0,-1}};
        
        while(!queue.isEmpty()){
            int curr[] = queue.poll();
            int r = curr[0] , c = curr[1];
            for(int[] dir : directions){
                int nr = r + dir[0] , nc = c + dir[1];
                if(nr >=  0 && nr < ROWS && nc >= 0 && nc < COLS && !reachable[nr][nc] && heights[nr][nc] >= heights[r][c]){
                    queue.add(new int[]{nr,nc});
                    reachable[nr][nc] = true;
                }
            }
        }
    }
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int ROWS = heights.length , COLS = heights[0].length;
        Queue<int[]> pacificQueue = new LinkedList<>();
        Queue<int[]> atlanticQueue = new LinkedList<>();
        boolean pacificring[][] = new boolean[ROWS][COLS];
        boolean atlanticring[][] = new boolean[ROWS][COLS];

        for(int r = 0 ; r < ROWS ; r++){
            pacificQueue.add(new int[]{r,0});
            atlanticQueue.add(new int[]{r,COLS -1});
            pacificring [r][0] = true;
            atlanticring [r][COLS -1] = true;
        }
        for(int c = 0 ; c < COLS; c ++){
            pacificQueue.add(new int[]{0,c});
            atlanticQueue.add(new int[]{ROWS -1 , c});
            pacificring[0][c] = true;
            atlanticring[ROWS -1 ][c] = true;
        }
        bfs(pacificQueue , pacificring , heights);
        bfs(atlanticQueue , atlanticring  , heights);

        List<List<Integer>> ans = new ArrayList<>();
        for(int r = 0 ; r < ROWS ; r ++){
            for(int c = 0 ; c < COLS ; c++){
                if(pacificring[r][c] && atlanticring[r][c]){
                    ans.add(Arrays.asList(r,c));
                }
            }
        }
        return ans;

    }

    
    
    
}
