class Solution {
    public String longestPalindrome(String s) {
        int max=0;
        String ans ="";
        if(s.length()==1){
            return s;
        }
        for(int i=0;i<s.length();i++){
            
            for(int j = s.length()-1;j>=0;j--){
                int ogj=j;
                int ogi=i;
                // System.out.println(ogi+" "+ogj+" hiii");
                while(s.charAt(ogi)==s.charAt(ogj) && ogi<ogj){
                    ogi++;
                    ogj--;
                    // System.out.println(ogi+" "+ogj);
                }
                if(ogi>=ogj){
                    if(max<(j-i)){
                        max = j-i;
                        ans = s.substring(i,j+1);
                    }
                }
            }
        }
        return ans.length()==0?s.substring(0,1):ans;
    }
}
