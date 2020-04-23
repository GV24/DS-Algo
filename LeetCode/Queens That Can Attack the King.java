class Solution {
    public List<List<Integer>> queensAttacktheKing(int[][] queens, int[] king) {
        
        List<List<Integer>> ret = new ArrayList<>();
        int x = king[0], y = king[1];
        List<Integer> list = null;
        boolean[][] seen = new boolean[8][8];
        
        for (int[] s : queens )
            seen[s[0]][s[1]] = true;
        
        while ( --x >= 0 && --y >= 0 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list);
                break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( ++x < 8 && --y >= 0 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( ++x < 8 && ++y < 8 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( --x >= 0 && ++y < 8 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( --x >= 0 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( --y >= 0 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( ++x < 8 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        x = king[0]; y = king[1];
        while ( ++y < 8 ){
            if ( seen[x][y] ) {
                list = new ArrayList<>();
                list.add(x); list.add(y);
                ret.add(list); break;
             }
        }
        
        return ret;
    }
}