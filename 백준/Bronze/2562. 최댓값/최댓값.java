import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int max = 0;
        int index = 0;

        for (int i = 0; i < 9; i++) {
            int num = Integer.parseInt(br.readLine());
            if (i == 0) {
                max = num;
                index = i;
            } else if (num > max) {
                max = num;
                index = i;
            }
        }

        System.out.println(max);
        System.out.print(index + 1);
    }
}
