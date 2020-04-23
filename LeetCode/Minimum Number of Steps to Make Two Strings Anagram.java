class Solution {
    public int minSteps(String s, String t) {
     
        int[] srcArr = new int[128];
        char[] sArr = s.toCharArray();
        char[] tArr = t.toCharArray();
        
        for ( char el : sArr)
            ++srcArr[el];
        
        for ( char el : tArr)
            --srcArr[el];
        
        int sum = 0;
        for ( int el : srcArr)
            sum += Math.abs(el);
        
        return sum/2;
    }
}