package week_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B11920_priorityQueue {
    static int toInt(String s) { return Integer.parseInt(s);}

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = toInt(st.nextToken());
        int K = toInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        PriorityQueue<Integer> pq = new PriorityQueue<Integer>();

        for(int i=0; i<N; i++) {
            pq.offer(toInt(st.nextToken()));

            if(i >= K)
                bw.write(pq.poll() + " ");
        }

        while(!pq.isEmpty())
            bw.write(pq.poll() + " ");
        bw.flush();
    }
}
