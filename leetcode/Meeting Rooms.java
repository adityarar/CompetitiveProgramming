/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class Solution {
    /**
     * @param intervals: an array of meeting time intervals
     * @return: if a person could attend all meetings
     */
    public boolean canAttendMeetings(List<Interval> intervals) {
        // Write your code here
        int prevEnd = -1;
        
        Collections.sort(intervals, new Comparator<Interval>() {
            public int compare(Interval i, Interval j) {
                return i.start - j.start;
            }
        });

        for (Interval i: intervals) {
            if (i.start < prevEnd) return false;
            prevEnd = i.end;
        }

        return true;
    }
}
