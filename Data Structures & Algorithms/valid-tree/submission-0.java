class Solution {
    public boolean validTree(int n, int[][] edges) {
        HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
        for(int i=0;i<n;i++){
            hm.put(i, new HashSet<>());
        }

        boolean vis[] = new boolean[n];
        
        for(int i=0;i<edges.length;i++){
            hm.get(edges[i][0]).add(edges[i][1]);
            hm.get(edges[i][1]).add(edges[i][0]);
        }

        Queue<Integer> q = new LinkedList<>();
        q.offer(0);

        int count=0;

        while(!q.isEmpty()){
            Integer rv = q.poll();
            if(vis[rv]){
                // System.out.println(" hii ");
                return false;
            }
            vis[rv]=true;
            count++;
            // System.out.println(rv);
            for(Integer nb : hm.get(rv)){
                if(vis[nb]){
                    continue;
                }
                q.offer(nb);
            }
        }
        if(count<n){
            return false;
        }

        return true;
    }
}
