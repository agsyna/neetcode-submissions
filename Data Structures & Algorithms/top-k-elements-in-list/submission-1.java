class Solution {
    class Pair{
        int elem;
        int freq;
        Pair(int elem, int freq){
            this.elem=elem;
            this.freq=freq;
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        Arrays.sort(nums);
        ArrayList<Pair> arl = new ArrayList<>();
        for(int i=0;i<nums.length;i++){
            int j=i;
            while(j<nums.length && nums[i]==nums[j]){
                j++;
            }
            int count = j-i+1;
            i=j-1;
            arl.add(new Pair(nums[i], count));
        }



        Collections.sort(arl, new Comparator<Pair>(){
            @Override
            public int compare(Pair one, Pair two){
                int freq = Integer.compare(two.freq, one.freq);
                int val = Integer.compare(one.freq, two.freq);
                return freq==0?val:freq;
            }
        });

        int arr[]= new int [k];
        for(int i=0;i<k;i++){
            arr[i]=arl.get(i).elem;
        }
        return arr;
    }
}
