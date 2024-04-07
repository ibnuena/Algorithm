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
        int minAbsSum = Integer.MAX_VALUE;

        for (int i = 0; i < arr.length - 1; i++) {
            int left = i + 1;
            int right = arr.length - 1;

            while (left <= right) {
                int mid = (left + right) / 2;
                int currentSum = arr[i] + arr[mid];
                int currentAbsSum = Math.abs(currentSum);

                if (currentAbsSum < minAbsSum) {
                    minAbsSum = currentAbsSum;
                    answer[0] = arr[i];
                    answer[1] = arr[mid];
                }

                if (currentSum < 0)
                    left = mid + 1;
                else if (currentSum > 0)
                    right = mid - 1;
                else
                    break; // Found exact pair whose sum is 0
            }
        }

        System.out.println(answer[0] + " " + answer[1]);
    }
}
