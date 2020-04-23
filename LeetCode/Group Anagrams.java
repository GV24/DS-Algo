/* Given an array of strings, group anagrams together. */

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        
        List<List<String>> result = new ArrayList<>();
        Map<String, List<String>> listMap = new HashMap<>();
        
        if ( strs.length == 0 || strs == null )
            return result;
        
        for ( String str : strs )
        {
            // Arrays.sort(arr);
            String keyString = calculateKey(str.toCharArray());
            
            if ( !listMap.containsKey( keyString ) )
                listMap.put(keyString, new ArrayList<String>());
                
                listMap.get(keyString).add(str);
        }
        
        result.addAll(listMap.values());
        return result;
    }
    
    String calculateKey(char[] arr)
    {
        char[] keyCal = new char[26];
        for (char c : arr )
            ++keyCal[c - 'a'];
        
        return String.valueOf(keyCal);
    }
}