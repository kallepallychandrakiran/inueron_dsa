public int[] shuffle(int[] nums, int n) {
        int[] ans=new int[nums.length];
        int mid=nums.length/2;
        int j=0;
        for(int i=0;i<nums.length;i=i+2){
           ans[i]=nums[j];
           j++;
        }
        j=mid;
         for(int i=1;i<nums.length;i=i+2){
           ans[i]=nums[j];
           j++;
        }
        return ans;
    }