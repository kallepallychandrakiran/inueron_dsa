public boolean isMonotonic(int[] nums) {
            for(int i = 0; i < nums.length - 1; i++){
            if(nums[i] < nums[i + 1]) {
                
                for(int j = i + 1; j < nums.length - 1; j++){
                    if(nums[j] > nums[j + 1]) return false;
                }

                return true;
            }else if(nums[i] > nums[i + 1]) {
                
                for(int j = i + 1; j < nums.length - 1; j++){
                    if(nums[j] < nums[j + 1]) return false;
                }

                return true;
            }
        }

        return true;
    }