import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        String[] inputs = br.readLine().split(" ");
        for (int i = 0; i < arr.length; i++)
            arr[i] = Integer.parseInt(inputs[i]);

        Arrays.sort(arr);

        int[] answer = new int[2];
		int num = 2000000000;

        for (int i = 0; i < arr.length - 1; i++) {
            int min = i + 1;
            int max = arr.length - 1;
            while (max >= min) {
                int mid = (min + max) / 2;
                if (Math.abs(arr[i] + arr[mid]) < Math.abs(num)) {
                    num = arr[i] + arr[mid];
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                }
                if ((arr[i] + arr[mid]) > 0) {
                    max = mid - 1;
                } else if ((arr[i] + arr[mid]) < 0) {
                    min = mid + 1;
                } else {
                    break;
                }
            }
        }
        System.out.println(answer[0] + " " + answer[1]);
    }
}