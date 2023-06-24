Assignment-10
 -------------
 1) bool isPowerOfThree(int n) {
        if(n==1)return true;
        if(n==0 || n<0 || n%3 >0)return false;
        return isPowerOfThree(n/3);
    }
 2)   public int lastRemaining(int n) {
        boolean left = true;
        int head = 1;
        int step = 1;
        int remain = n;
        while(remain > 1){
            if(left || remain % 2 == 1){
                head = head + step;
            }
            step = step * 2;
            remain = remain / 2;
            left = !left;
        }
        return head;
    }
 3)
    static void powerSet(String str, int index, String curr)
    {
        int n = str.length();
 
        // base case
        if (index == n) {
            return;
        }
        System.out.println(curr);
 
        // Try appending remaining characters
        // to current subset
        for (int i = index + 1; i < n; i++) {
            curr += str.charAt(i);
            powerSet(str, i, curr);
 
            curr = curr.substring(0, curr.length() - 1);
        }
    }
4) private static int recLen(String str)
    {
        if (str.equals(""))
            return 0;
        else
            return recLen(str.substring(1)) + 1;
    }
5)static boolean checkEquality(String s)
    {
        return (s.charAt(0) == s.charAt(s.length() - 1));
    }
      
    static int countSubstringWithEqualEnds(String s)
    {
        int result = 0;
        int n = s.length();
      
        // Starting point of substring
        for (int i = 0; i < n; i++)
           for (int len = 1; len <= n-i; len++)
              if (checkEquality(s.substring(i, i + len)))
                result++;
      
        return result;
    }
  6)public long toh(int n, int from, int to, int aux) {
       
       if(n<=0) return 0;


       long x = toh(n-1,from,aux,to);


       System.out.println("move disk "+n+" from rod "+from+" to rod "+        to);
       long y = toh(n-1,aux,to,from);
       
       return x+y+1; 
   }
 7) static void printPermutn(String str, String ans)
    {
 
       
        if (str.length() == 0) {
            System.out.print(ans + " ");
            return;
        }
 
        for (int i = 0; i < str.length(); i++) {
 
          
            char ch = str.charAt(i);
 
          
            String ros = str.substring(0, i) +
                        str.substring(i + 1);
 
         
            printPermutn(ros, ans + ch);
        }
    }
  8) static boolean isConsonant(char ch)
    {
      
        ch = Character.toUpperCase(ch);
       
        return !(ch == 'A' || ch == 'E' || 
                ch == 'I' || ch == 'O' || 
                ch == 'U') && ch >= 65 && ch <= 90;
    }
   
    static int totalConsonants(String str)
    {
        int count = 0;
        for (int i = 0; i < str.length(); i++) 
       
            
            if (isConsonant(str.charAt(i)))
                ++count;
        return count;
    }