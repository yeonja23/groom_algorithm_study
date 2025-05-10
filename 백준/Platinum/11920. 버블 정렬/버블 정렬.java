import java.io.*;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class Main {
    static int toInt(String s) { return Integer.parseInt(s); }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int K = toInt(st.nextToken());

        PriorityQueue<Integer> pq = new PriorityQueue<>();

        int count = 0;
        while (count < N) {
            st = new StringTokenizer(br.readLine());
            while (st.hasMoreTokens() && count < N) {
                pq.offer(toInt(st.nextToken()));
                if (count >= K)
                    bw.write(pq.poll() + " ");
                count++;
            }
        }

        while (!pq.isEmpty())
            bw.write(pq.poll() + " ");
        bw.flush();
    }
}
