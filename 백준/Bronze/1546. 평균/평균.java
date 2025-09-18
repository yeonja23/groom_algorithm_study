import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        double[] arr = new double[n];
        double max = 0;

        for (int i = 0; i < n; i++) {
            double realScore = Double.parseDouble(st.nextToken());
            if (realScore > max) {
                max = realScore;
            }
            arr[i] = realScore;
        }

        double sum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = (arr[i]/max) * 100;
            sum += arr[i];
        }
        double avg = sum / n;
        System.out.println(avg);
    }
}
