class Solution {
    HashMap<Integer, HashSet<Integer>> hm = new HashMap<>();
    HashSet<Integer> hs = new HashSet<>();
    StringBuilder sb = new StringBuilder();
    public String foreignDictionary(String[] words) {

        if(words.length==1){
            return words[0];
        }

        for(int i=0;i<26;i++){
            hm.put(i, new HashSet<>());
        }

        int in[] = new int[26];
        
        for(int i=0;i<words.length-1;i++){
            String one = words[i];
            String two = words[i+1];
            
            boolean check=false;
            if(one.equals(two)){
                check=true;
            }
            if(one.contains(two) && one.length()>two.length()){
                System.out.println("hiii ");
                return "";
            }
            for(int j=0;j<Math.min(one.length(), two.length());j++){
                hs.add(one.charAt(j)-'a');
                hs.add(two.charAt(j)-'a');
                if(one.charAt(j)!=two.charAt(j) && !check){
                    int from = one.charAt(j)-'a';
                    int to = two.charAt(j)-'a';
                    // System.out.println(from+" "+to);
                    
                    if(!hm.get(from).contains(to)){
                        in[to]+=1;
                    }
                    hm.get(from).add(to);
                    
                    check=true;
                    // break;
                }
            }
            // if(!check){
            //     return "";
            // }
        }

        if(hs.size()==1){
            return words[0].charAt(0)+"";
        }

        System.out.println(hm);
        System.out.println(hs);

        Queue<Integer> q = new LinkedList<>();

        for(int i=0;i<26;i++){
            if(in[i]==0 && hs.contains(i)){
                q.offer(i);
            }
        }
        HashSet<Integer> vis = new HashSet<>();


        while(!q.isEmpty()){
            Integer rv = q.poll();
            char ch = (char)(rv+'a');
            sb.append(ch);
            vis.add(rv);
            // System.out.println(" popped out "+rv);
            for(Integer val : hm.get(rv)){
                
                in[val]-=1;
                // System.out.println(" nbrs "+val+" in val "+in[val]);
                if(in[val]==0){
                    q.offer(val);
                }
            }
        }
        
        if(sb.length()<hs.size()){
            return "";
        }


      return sb.toString();
    }
}
