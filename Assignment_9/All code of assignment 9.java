Assignment-9
------------
1)public boolean isPowerOfTwo(int n) {
         if (n==0) return false;
       else if (n==1) return true;
       else if(n%2==0 && isPowerOfTwo(n/2)) return true;
       else return false;
        
    }
 2) public static int findSum(int n)
	 {
	 if (n <= 1)
	 {
	 return n;
	 }
	 else
	 {
	 return n + findSum(n - 1);
	 }
	 }
3) static int factorial(int n)
    {
        if (n == 0)
            return 1;
  
        return n * factorial(n - 1);
    }
4) public double myPow(double x, int n) {
        if(x == 1) return 1;
        if(n == -2147483648 && x > 1) return 0;
        if(n >= 0) return ans(x, n);
        else return 1 / ans(x, -1*n);
    }

    double ans(double x,int n){
        double ans = 1;
        while(n > 0){
            if((n & 1) == 1){
                ans *= x;
            }
            x *= x;
            n = n >> 1;
        }
        return ans;
    }
 5)  public int findMaxRec(int A[], int n)
{
    if (n == 1)
        return A[0];
    return Math.max(A[n-1], findMaxRec(A, n-1));
}
6) public static int Nth_of_AP(int a,
                                int d,
                                int N)
    {      return ( a + (N - 1) * d );}
 7) static void permute(String s, String answer)
    {
        if (s.length() == 0) {
            System.out.print(answer + "  ");
            return;
        }
 
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            String left_substr = s.substring(0, i);
            String right_substr = s.substring(i + 1);
            String rest = left_substr + right_substr;
            permute(rest, answer + ch);
        }
    }
  8) static int product(int[] arr,n)
    {
        if(n==1) return arr[0];
  
        return arr[n-1]*product(arr,n-1);
    }
    