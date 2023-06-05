public static int firstNotRepeatingCharacter(String s) {
        for (char c : s.toCharArray()) {
            if (s.indexOf(c) == s.lastIndexOf(c)) {
                return s.indexOf(c);
            }
        }
        return -1;
    }