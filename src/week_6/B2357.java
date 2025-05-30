package week_6;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2357 {
    static int[] arr;
    static int[] minTree, maxTree;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        int size = 1;
        while (size < N) {
            size <<= 1;
        }
        minTree = new int[size * 2];
        maxTree = new int[size * 2];

        buildMinTree(1, 0, N - 1);
        buildMaxTree(1, 0, N - 1);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int left = Integer.parseInt(st.nextToken()) - 1;
            int right = Integer.parseInt(st.nextToken()) - 1;

            int min = queryMin(1, 0, N - 1, left, right);
            int max = queryMax(1, 0, N - 1, left, right);
            sb.append(min).append(" ").append(max).append("\n");
        }

        System.out.print(sb);
    }

    static void buildMinTree(int node, int start, int end) {
        if (start == end) {
            minTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildMinTree(node * 2, start, mid);
            buildMinTree(node * 2 + 1, mid + 1, end);
            minTree[node] = Math.min(minTree[node * 2], minTree[node * 2 + 1]);
        }
    }

    static void buildMaxTree(int node, int start, int end) {
        if (start == end) {
            maxTree[node] = arr[start];
        } else {
            int mid = (start + end) / 2;
            buildMaxTree(node * 2, start, mid);
            buildMaxTree(node * 2 + 1, mid + 1, end);
            maxTree[node] = Math.max(maxTree[node * 2], maxTree[node * 2 + 1]);
        }
    }

    static int queryMin(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MAX_VALUE;
        }
        if (left <= start && end <= right) {
            return minTree[node];
        }
        int mid = (start + end) / 2;
        int lMin = queryMin(node * 2, start, mid, left, right);
        int rMin = queryMin(node * 2 + 1, mid + 1, end, left, right);
        return Math.min(lMin, rMin);
    }

    static int queryMax(int node, int start, int end, int left, int right) {
        if (right < start || end < left) {
            return Integer.MIN_VALUE;
        }
        if (left <= start && end <= right) {
            return maxTree[node];
        }
        int mid = (start + end) / 2;
        int lMax = queryMax(node * 2, start, mid, left, right);
        int rMax = queryMax(node * 2 + 1, mid + 1, end, left, right);
        return Math.max(lMax, rMax);
    }
}
