/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
public class Solution {
    public List<Interval> merge(List<Interval> intervals) {
    	int size = intervals.size() ;
    	if(size <=1) return intervals ;
    	Collections.sort(intervals, new comparatorIntervals()) ;
    	ArrayList<Interval> result = new ArrayList<Interval>() ;
    	Interval prev = intervals.get(0) ;
    	for(int i = 1; i < size; i++) {
    		Interval curr = intervals.get(i) ;
    		if(curr.start <= prev.end) {
    			Interval merged = new Interval(prev.start, Math.max(prev.end, curr.end)) ;
    			prev = merged ;
    			}else {
    			result.add(prev) ;
    			prev = curr ;
    		}
    	}
    	result.add(prev) ;
    	return result ;
        
    }
}

class comparatorIntervals implements Comparator<Interval> {
	public int compare(Interval in1, Interval in2) {
		return in1.start - in2.start ;
	}
}
