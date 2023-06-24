Assignment-8
------------
1)class Solution {
    int func(String s1, String s2, int i, int j, HashSet<Character> hs, int[][] dp) {
        if (i >= s1.length() || j >= s2.length()) {
            if (i >= s1.length()) {
                int x = 0;
                while (j < s2.length()) {
                    x += (int) s2.charAt(j);
                    j++;
                }
                return x;
            } else {
                int x = 0;
                while (i < s1.length()) {
                    x += (int) s1.charAt(i);
                    i++;
                }
                return x;
            }
        }
        if (dp[i][j] != 0) {
            return dp[i][j];
        }
        char a = s1.charAt(i);
        char b = s2.charAt(j);
        if (!hs.contains(a)) {
            dp[i][j] = func(s1, s2, i + 1, j, hs, dp) + (int) a;
        } else if (!hs.contains(b)) {
            dp[i][j] = func(s1, s2, i, j + 1, hs, dp) + (int) b;
        } else if (a == b) {
            dp[i][j] = func(s1, s2, i + 1, j + 1, hs, dp);
        } else {
            dp[i][j] = Math.min(func(s1, s2, i + 1, j, hs, dp) + (int) a, func(s1, s2, i, j + 1, hs, dp) + (int) b);
        }
        return dp[i][j];
    }
    
    public int minimumDeleteSum(String s1, String s2) {
        int[][] dp = new int[s1.length()][s2.length()];

        HashSet<Character> hs1 = new HashSet<>();
        HashSet<Character> hs2 = new HashSet<>();

        for (char c : s1.toCharArray()) {
            hs1.add(c);
        }

        for (char c : s2.toCharArray()) {
            hs2.add(c);
        }
        hs1.retainAll(hs2);
        
        return func(s1, s2, 0, 0, hs1, dp);
    }
}
2) public boolean checkValidString(String s) {
        int openCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '(') {
                openCount++;
            } else if (c == ')') {
                openCount--;
            }
            if (openCount < 0) return false;    // Currently, don't have enough open parentheses to match close parentheses-> Invalid
                                                // For example: ())(
        }
        return openCount == 0; // Fully match open parentheses with close parentheses
    }
3)public int minDistance(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();
        
        int[] dp = new int[n+1];
        // as java already contain 0 as default value no need to initailize the dp array
        for(int i = 1 ; i < m+1 ;i++){
            int[] temp = new int[n+1];
            for(int j = 1 ; j < n+1 ; j++){
                if(word1.charAt(i-1) == word2.charAt(j-1))
                     temp[j] = 1+dp[j-1];
                 
                 else
                     temp[j] = Math.max(dp[j] , temp[j-1]);       
            }
            dp = temp;
        }
         return m+n-(2*dp[n]);
     }
4) StringBuilder sb;
    private void doEv(TreeNode root){
        if(root == null)return;
        if(root.left == null && root.right==null){
            sb.append(root.val);
            return;
        }
        sb.append(root.val);
        sb.append('(');
        doEv(root.left);
        sb.append(')');
        if(root.right!=null){
        sb.append('(');
        doEv(root.right);
        sb.append(')');
        }
        return;
    }
    public String tree2str(TreeNode t) {
        sb = new StringBuilder();
        doEv(t);
        return sb.toString();
    }
5)   public int compress(char[] chars) {
        String s="";
        int c=1;
        int i;
        for (i=0;i<chars.length-1;i++)
        {
            if(chars[i]==chars[i+1]){
                  c++;
            }else{
                if(c>1)s+=chars[i]+""+c;
                else s+=chars[i];
                c=1;
            }
        }
        if(c>1)s+=chars[i]+""+c;
        else s+=chars[i];
        int k=0;
        for(char c1:s.toCharArray())
        {
            chars[k++]=c1;
        }

        return s.length();
       

    }
6)  static boolean isequal(int counta[],int countb[]){
       
        boolean ans=true;
        for(int i=0;i<26;i++){
            if(counta[i]!=countb[i]){
                ans= false;
                break;
            }
        }
        return ans;

    }

    public List<Integer> findAnagrams(String s, String p) {
        int k=p.length();
        List<Integer> l=new ArrayList<>();
        if(s.length()<k){
            return l;
        }
        
        int counts[]=new int[26];
        int countp[]=new int[26];
        for(int i=0;i<k;i++){
            counts[s.charAt(i)-'a']++;
            countp[p.charAt(i)-'a']++;
        }
        if(isequal(counts,countp)){
            l.add(0);
        }
        for(int i=k;i<s.length();i++){
            counts[s.charAt(i)-'a']++;
            counts[s.charAt(i-k)-'a']--;
            if(isequal(counts,countp)){
                l.add(i-k+1);
            }
        }
        return l;
    }
7)  public String decodeString(String s) {
        Stack<Integer> is = new Stack<>();
        Stack<StringBuilder> ss = new Stack<>();

        int n = s.length(), num = 0;
        StringBuilder str = new StringBuilder();

        for(char ch : s.toCharArray()) {
            // There will be 4 types of characters --> number, [ , ], character

            if(ch >= '0' && ch <= '9') {
                num = (num * 10) + ch - '0';
            } else if(ch == '[') {
                ss.push(str);
                str = new StringBuilder();

                is.push(num);
                num = 0;
            } else if(ch == ']') {
                StringBuilder temp = str;
                str = ss.pop();
                int count = is.pop();

                while(count-- > 0) {
                    str.append(temp);
                }
            } else {
                str.append(ch);
            }
        }
        return str.toString();
    }
8) public boolean buddyStrings(String s, String goal) {
        int m = s.length(), n = goal.length();
        if (m != n) {
            return false;
        }
        int diff = 0;
        int[] cnt1 = new int[26];
        int[] cnt2 = new int[26];
        for (int i = 0; i < n; ++i) {
            int a = s.charAt(i), b = goal.charAt(i);
            ++cnt1[a - 'a'];
            ++cnt2[b - 'a'];
            if (a != b) {
                ++diff;
            }
        }
        boolean f = false;
        for (int i = 0; i < 26; ++i) {
            if (cnt1[i] != cnt2[i]) {
                return false;
            }
            if (cnt1[i] > 1) {
                f = true;
            }
        }
        return diff == 2 || (diff == 0 && f);
    }

        
        return true;
    }