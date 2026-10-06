class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> ans = new ArrayList<>();
        Arrays.sort(strs, new Comparator<>() {
            @Override
            public int compare(String one, String two) {
                return Integer.compare(one.length(), two.length());
            }
        });

        boolean traversed[] = new boolean[strs.length];

        for (int i = 0; i < strs.length; i++) {
            if(traversed[i]){
                continue;
            }
            int freqi[] = new int[26];
            for (int w = 0; w < strs[i].length(); w++) {
                int val = strs[i].charAt(w) - 'a';
                freqi[val] += 1;
            }
            List<String> dummy = new ArrayList<>();
            dummy.add(strs[i]);
            traversed[i]=true;
            // System.out.println(" hi "+strs[i]);
            for (int j = i + 1; j < strs.length && strs[j].length() == strs[i].length(); j++) {
                int freqj[] = new int[26];
                for (int w = 0; w < strs[j].length(); w++) {
                    int val = strs[j].charAt(w) - 'a';
                    freqj[val] += 1;
                }

                // System.out.println(Arrays.toString(freqi));
                // System.out.println(Arrays.toString(freqj));
                boolean breaks = false;
                for (int w = 0; w < 26; w++) {
                    if(freqi[w]!=freqj[w]){
                    breaks=true;
                    break;
                    }
                }
                if(breaks){
                    continue;
                }
                // i=j;
                traversed[j]=true;
                // System.out.println(" yo "+strs[j]);
                dummy.add(strs[j]);    
            }
            if(dummy.size()!=0){
                ans.add(dummy);
            }
        }
        return ans;
    }
}
