import java.util.*;

public class MeetingRooms {
    static class Pair implements Comparable <Pair> {
        int roomsChange;
        int timestamp;

        public int compareTo(Pair other){
            return this.timestamp-other.timestamp;
        }
        Pair( int timestamp, int roomsChange){
            this.roomsChange =roomsChange;
            this.timestamp=timestamp;
        }
    }
    // create a class of pairs
        // integer roomschange;
        // integer timestamp;
        
        //comparator logic to sort pairs on increasing order of timestamp
    public int findNumRooms(int[][] intervals) {
        List <Pair> list = new ArrayList <Pair> ();
        for(int [] interval: intervals){
            list.add(new Pair(interval[0], +1));
            list.add(new Pair(interval[1], -1));
        }
        Collections.sort(list);
        int minRooms=0, meetingsInProgress = 0;
        for(Pair p: list){
            meetingsInProgress+=p.roomsChange;
            minRooms=Math.max(minRooms, meetingsInProgress);
        }
        return minRooms;
        
    }

    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        int n = scanner.nextInt();

        int[][] nums = new int[n][2];

        for(int i = 0 ; i < n ;i++) {
            nums[i][0] = scanner.nextInt();
            nums[i][1] = scanner.nextInt();
        }

        int result = new MeetingRooms().findNumRooms(nums);

        System.out.printf("%d", result);
    }

}