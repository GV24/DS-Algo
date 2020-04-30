class UndergroundSystem {
    
    class US
    {
        String stationName;
        int timestamp;
        
        US(int ts, String sn )
        {
            timestamp = ts;
            stationName = sn;
        }
    }
    
    class PS
    {
        String srcStation;
        String endStation;
        
        PS(String ss, String es)
        {
            srcStation = ss;
            endStation = es;
        }
        
        public int hashCode()
        {
            return srcStation.hashCode() + endStation.hashCode();
        }
        
        public boolean equals(Object obj)
        {
            if ( obj  instanceof PS )
            {
                PS pss = (PS)obj;
                
                if ( pss.srcStation.equals(this.srcStation ) && 
                   pss.endStation.equals(this.endStation ))
                        return true;
            }
            return false;
        }
        
    }
    
    class Cnt
    {
        int travelCnt;
        long trvlTimeSum;
        
        Cnt( int tc, int tts )
        {
            travelCnt = tc;
            trvlTimeSum = tts;
        }
    }
    
    //Map<id, US>
    Map<Integer, US> checkedIn;
    
    Map<PS, Cnt> travelTable;
    
    public UndergroundSystem() {
        
        checkedIn = new HashMap<>();
        travelTable = new HashMap<>();
    }
    
    public void checkIn(int id, String stationName, int t) {
        
        if ( !checkedIn.containsKey(id) )
            checkedIn.put( id, new US(t, stationName) );
    }
    
    public void checkOut(int id, String stationName, int t) {

        if ( checkedIn.containsKey(id) )
        {
            US person = checkedIn.remove(id); // check in - stationName and timestamp
            PS ps = new PS( person.stationName, stationName); // srcStation, destStation
            
            // make a entry to save (a) number of travels, (b) sum of travel time.
            if ( travelTable.containsKey(ps) )
            {
                Cnt cnt = travelTable.get ( ps );
                cnt.travelCnt++;
                cnt.trvlTimeSum += t - person.timestamp;
                travelTable.put( ps, cnt);
            }
            else
            {
                Cnt cnt = new Cnt( 1, t - person.timestamp);
                travelTable.put( ps, cnt);
            }
        }
    }
    
    public double getAverageTime(String startStation, String endStation) {
        
        Cnt cnt = travelTable.get(new PS( startStation, endStation ) );
        return (double)cnt.trvlTimeSum/cnt.travelCnt;
        
    }
}

/**
 * Your UndergroundSystem object will be instantiated and called as such:
 * UndergroundSystem obj = new UndergroundSystem();
 * obj.checkIn(id,stationName,t);
 * obj.checkOut(id,stationName,t);
 * double param_3 = obj.getAverageTime(startStation,endStation);
 */