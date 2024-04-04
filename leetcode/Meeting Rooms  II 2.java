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
     * @return: the minimum number of conference rooms required
     */
    public int minMeetingRooms(List<Interval> intervals) {
        // Logic taken from Neetcode
        // Write your code here
        int n = intervals.size();
        int[] starts = new int[n];
        int[] ends = new int[n];
        int k = 0;

        for(Interval interval: intervals) {
            starts[k] = interval.start;
            ends[k] = interval.end;
            k++;
        }
        Arrays.sort(starts);
        Arrays.sort(ends);

        int curr = 0, max = 0;
        int p=0, q=0;
        
        while(p<n && q<n) {
            if (ends[q] <= starts[p]) {
                q++;
                curr--;
            }
            else {
                p++;
                curr++;
                max = Math.max(max,curr);
            }
        }

        return max;
    }

}

