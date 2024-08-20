package codefile;

import java.util.Arrays;

public class Solution1921 {
	public int eliminateMaximum(int[] dist, int[] speed) {
        int[] time = new int[dist.length];

        for (int i = 0; i < dist.length; i++) {
            time[i] = (int) Math.ceil((double) dist[i] / speed[i]);
        }

        Arrays.sort(time);

        int kills = 0;
        for (int i = 0; i < dist.length; i++) {
            if (i >= time[i]) {
                return kills;
            }
            kills++;
        }

        return dist.length;
    }
}
