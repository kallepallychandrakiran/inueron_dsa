public int[] findErrorNums(int[] nums) {
        int[] res=new int[2];

        HashSet<Integer> set= new HashSet<>();
        int sum=0;
        for(int num: nums){
            if(set.contains(num)){
                res[0]=num;
            }else {
                
                set.add(num);
                 sum+=num;
            
        }
       
        }
        // we got the number which was repeated twice

        int n=nums.length;
        res[1]=(n*(n+1)/2)-(sum);



return res;
    }