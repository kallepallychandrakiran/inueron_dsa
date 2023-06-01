public int maximumProduct(int[] nums) {
    
        int maxProduct=Integer.MIN_VALUE;
        int prod=1;
        int left=0;
        for(int i=0;i<3;i++) {
         prod=prod*nums[i];
        }
      maxProduct=  Math.max(prod,maxProduct);
        for(int i=3;i<nums.length;i++){
            prod=prod/nums[left]*nums[i];
            left++;
        }
        maxProduct= Math.max(prod,maxProduct);
        return maxProduct;
        
    }