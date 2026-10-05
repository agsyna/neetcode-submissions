class Solution {
    class Pair{
        int x;
        int y;
        Pair(int x, int y){
            this.x=x;
            this.y=y;
        }
    }
    int row[]={-1,+1,0,0};
    int col[]={0,0,-1,+1};
    List<List<Integer>> arl = new ArrayList<>();
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int m = heights.length;
        int n = heights[0].length;
        Boolean pac[][] = new Boolean[m][n];
        Queue<Pair> q = new LinkedList<>();
        for(int j=0;j<n;j++){
            q.offer(new Pair(0,j));
        }

        for(int i=0;i<m;i++){
            q.offer(new Pair(i,0));
        }

        while(!q.isEmpty()){
            Pair rv = q.poll();
            int x = rv.x;
            int y = rv.y;
            if(pac[x][y]!=null){
                continue;
            }
            pac[x][y]=true;
            int val = heights[x][y];
            for(int i =0;i<4;i++){
                int adjx = x+row[i];
                int adjy = y+col[i];
                if(adjx<0 || adjy<0 || adjx>=m || adjy>=n || heights[adjx][adjy]<val){
                    continue;
                }
                q.offer(new Pair(adjx, adjy));
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                System.out.print(pac[i][j]+" , ");
            }
            System.out.println();
        }

        Boolean atl[][] = new Boolean[m][n];
        q = new LinkedList<>();
        for(int j=0;j<n;j++){
            q.offer(new Pair(m-1,j));
        }

        for(int i=0;i<m;i++){
            q.offer(new Pair(i,n-1));
        }

        while(!q.isEmpty()){
            Pair rv = q.poll();
            int x = rv.x;
            int y = rv.y;
            if(atl[x][y]!=null){
                continue;
            }
            atl[x][y]=true;
            int val = heights[x][y];
            for(int i =0;i<4;i++){
                int adjx = x+row[i];
                int adjy = y+col[i];
                if(adjx<0 || adjy<0 || adjx>=m || adjy>=n || heights[adjx][adjy]<val){
                    continue;
                }
                q.offer(new Pair(adjx, adjy));
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                List<Integer> dummy = new ArrayList<>();
                if(pac[i][j]!=null && atl[i][j]!=null && pac[i][j] && atl[i][j]){
                    dummy.add(i);
                    dummy.add(j);
                    arl.add(dummy);
                }
            }
        }

        
        return arl;
    }
}
