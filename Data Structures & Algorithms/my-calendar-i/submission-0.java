public class MyCalendar {
    private TreeSet<int[]> events;

    public MyCalendar() {
        events = new TreeSet<>((a, b) -> a[0] - b[0]);
    }

    public boolean book(int startTime, int endTime) {
        int[] event = new int[]{startTime, endTime};
        int[] prev = events.floor(event);
        int[] next = events.ceiling(event);

        if ((prev != null && prev[1] > startTime) || (next != null && next[0] < endTime)) {
            return false;
        }
        events.add(event);
        return true;
    }
}