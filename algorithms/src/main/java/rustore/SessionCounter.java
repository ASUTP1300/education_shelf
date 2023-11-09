package rustore;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SessionCounter {
    public static void main(String[] args) {
        System.out.println("HWv2!");

        List<Session> sessions = new ArrayList<>();

        sessions.add(new Session(110, 500));
        sessions.add(new Session(25, 501));
        sessions.add(new Session(23, 200));
        sessions.add(new Session(501, 502));

        System.out.println(maxTraffic(sessions));
    }

    static int maxTraffic(List<Session> sessions){
        sessions.sort(Comparator.comparingLong(x -> x.start));

        int count = 1;
        int max = 0;

        for (int i = 0; i < sessions.size() - 1; i++) {
            int j = i + 1;

            while(j < sessions.size() && sessions.get(i).end >= sessions.get(j).start) {
                count++;
                j++;
            }
            max = Math.max(count, max);
            count = 1;
        }
        return max;
    }

}

class Session {

    long start;
    long end;

    Session(long start, long end){
        this.start = start;
        this.end = end;
    }

}