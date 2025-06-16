package week_8;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class B1202 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[][] jewelries = new int[N][2]; // [무게, 가격]
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            jewelries[i][0] = Integer.parseInt(st.nextToken());
            jewelries[i][1] = Integer.parseInt(st.nextToken());
        }

        // 무게 오름차순, 무게가 같으면 가격 내림차순 정렬
        Arrays.sort(jewelries, (a, b) -> {
            if (a[0] == b[0]) return b[1] - a[1];
            return a[0] - b[0];
        });

        int[] bags = new int[K];
        for (int i = 0; i < K; i++) {
            bags[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(bags); // 가방 무게 오름차순 정렬

        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder()); // 가격 내림차순
        long ans = 0;
        for (int i = 0, j = 0; i < K; i++) {
            while (j < N && jewelries[j][0] <= bags[i]) {
                pq.offer(jewelries[j][1]);
                j++;
            }

            if (!pq.isEmpty()) {
                ans += pq.poll();
            }
        }

        bw.write(ans + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
