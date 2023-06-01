public int distributeCandies(int[] candyType) {
     
     int n=candyType.length;
     int candysAllowed=n/2;
     if(candysAllowed<=findTypesOfCandy(candyType)){
         return candysAllowed;
     }else return findTypesOfCandy(candyType);

        
    }
    public int findTypesOfCandy(int[] ct){
        Arrays.sort(ct);
        int count=1;
        for(int i=1;i<ct.length;i++){
            if(ct[i]!=ct[i-1]) count++;
        }
        return count;
    }