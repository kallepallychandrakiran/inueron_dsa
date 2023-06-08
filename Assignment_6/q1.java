public boolean searchMatrix(int[][] matrix, int target) {
        
     int n=matrix[0].length-1;
     for(int i=0;i<matrix.length;i++){
         if(target<=matrix[i][n]){
             int s=0;
             int e=n;
             while(s<=e){
                 int m=(s+e)/2;
                 if(matrix[i][m]==target) return true;
                 else if(matrix[i][m]<target){
                     s=m+1;
                 }else{
                     e=m-1;
                 }

             }


         }
     }
     return false;