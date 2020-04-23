class ProductOfNumbers {

    List<Integer> list;
    int zeroIndx = -1;
    
    public ProductOfNumbers() {
        list = new ArrayList<>();
    }
    
    public void add(int num) {
        
        if ( num == 0 )
        {
            zeroIndx = list.size();
        }
        else if ( num != 1 )
        {
            for ( int i = zeroIndx + 1; i < list.size(); ++i )
                list.set(i, num * list.get(i) );
        }
        
        list.add(num);
    }
    
    public int getProduct(int k) {
        
        if ( k <= list.size() )
        {
            if ( zeroIndx >= list.size() - k )
                return 0;
            else
                return list.get(list.size() - k);
        }
        
        return 0;
    }
}