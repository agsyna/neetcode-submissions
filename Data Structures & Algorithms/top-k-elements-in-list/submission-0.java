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
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i],0)+1);
        }

        ArrayList<Pair> arl = new ArrayList<>();
        for(Map.Entry<Integer, Integer> entry : hm.entrySet()){
            arl.add(new Pair(entry.getKey(), entry.getValue()));
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
