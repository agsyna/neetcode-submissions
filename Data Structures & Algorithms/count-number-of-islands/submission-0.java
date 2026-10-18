class Solution {
    int row[] ={-1,+1,0,0};
    int col[] ={0,0,-1,+1};
    class Pair{
        int i;
        int j;
        Pair(int i, int j){
            this.i=i;
            this.j=j;
        }
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        boolean traversed[][] = new boolean[m][n];

        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !traversed[i][j]){
                    bft(i,j,grid,traversed);
                    count++;
                }

                // print(traversed);
            }
        }

        return count;
    }

    public void print(boolean arr [][]){
        for(int i=0;i<arr.length;i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" , ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public void bft(int i, int j, char[][] grid, boolean traversed[][]){
        Queue<Pair> q = new LinkedList<>();
        q.offer(new Pair(i,j));

        while(!q.isEmpty()){
            Pair rv = q.poll();
            int x = rv.i;
            int y = rv.j;
            if(traversed[x][y]){
                continue;
            }
            traversed[x][y]=true;
            for(int w=0;w<4;w++){
                int adjx=x+row[w];
                int adjy=y+col[w];
                if(adjx<0 || adjy<0 || adjx>=grid.length || adjy>=grid[0].length || traversed[adjx][adjy]){
                    continue;
                }
                if(grid[adjx][adjy]=='1')
                q.offer(new Pair(adjx, adjy));
            }
        }

    }
}