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
        // Write your code here
        List<Timer> times = new ArrayList();
        for(Interval interval: intervals) {
            times.add(new Timer(interval.start, true));
            times.add(new Timer(interval.end, false));
        }

        Collections.sort(times, new Comparator<Timer>(){
            public int compare(Timer t1, Timer t2){
                if (t1.time == t2.time) {
                    if (!t1.isStart) return -1;
                    else return 1;
                }
                else {
                    return t1.time - t2.time;
                }
            }
        });

        int curr = 0, max = 0;
        
        for (Timer t: times) {
            if (t.isStart) {
                curr++;
                max = Math.max(max, curr);
            }
            else {
                curr--;
            }
        }

        return max;
    }

    class Timer {
        int time;
        boolean isStart;

        Timer(int time, boolean isStart) {
            this.time = time;
            this.isStart = isStart;
        }
    }
}
