import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

// https://www.acmicpc.net/status?from_mine=1&problem_id=10816&user_id=dbfpzk142

public class Main {
    static BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
//        bSearch();
        hashMap();
//        arrayCount();

        // 세가지 방법이 떠오른다.

        // 1. 배열을 운영하며 카운트한다.
        // -1_000_000 ~ 1_000_000
        // 공간복잡도 계산이 필요
        // 시간 복잡도 O(N)

        // 2. 완전탐색
        // 시간 복잡도 500_000 ^ 2 안되겠다.

        // 3. HashMap 으로 카운터를 운영한다.
        // 공간복잡도를 확실하게 파악하기 어렵다.
        // 최악의 경우 Integer 500_000만개
        // bucket 이 있기 때문에 더 크다.
        // 시간 복잡도 O(N)

        // 4. 이분탐색으로 한다.
        // 시간복잡도 O(n log n)
        // binarySearch bound


    }

    private static void arrayCount() throws IOException {
        r.readLine();

        int[][] counter = new int[2][10_000_001]; // 10_000_000 * 2
        for (String s : r.readLine().split(" ")) { // 500_000
            int i = Integer.parseInt(s);
            if (i > 0) {
                counter[0][i]++;
            } else {
                counter[1][i * -1]++;
            }
        }



        r.readLine();

        StringBuilder sb = new StringBuilder();
        for (String s : r.readLine().split(" ")) { // 500_000
            int i = Integer.parseInt(s);
            if (i > 0) {
                sb.append(counter[0][i]).append(' ');
            } else {
                sb.append(counter[1][i * - 1]).append(' ');
            }
        }
        System.out.println(sb); // O(N) | 20_500_000
    }

    private static void hashMap() throws IOException {
        r.readLine();

        Map<Integer, Integer> counter = new HashMap<>(); // counter 만드는 로직 오래걸림
        for (String s : r.readLine().split(" ")) {
            int i = Integer.parseInt(s);
            int count = counter.getOrDefault(i, 0);
            counter.put(i, count + 1);
        }



        r.readLine();

        StringBuilder sb = new StringBuilder();
        for (String s : r.readLine().split(" ")) { // O(N) 가능
            int i = Integer.parseInt(s);
            int count = counter.getOrDefault(i, 0);
            sb.append(count).append(' ');
        }
        System.out.println(sb);
    }

    private static void bSearch() throws IOException {
        final int N = Integer.parseInt(r.readLine());
        String[] inputs = r.readLine().split(" ");
        int[] nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = Integer.parseInt(inputs[i]);
        }

        final int M = Integer.parseInt(r.readLine());
        String[] inputs2 = r.readLine().split(" ");
        int[] nums2 = new int[M];
        for (int i = 0; i < M; i++) {
            nums2[i] = Integer.parseInt(inputs2[i]);
        }

        // 있는지 없는지
        Arrays.sort(nums); // N logN

        StringBuilder sb = new StringBuilder();
        for (int num : nums2) { // 2N logN
            int upper = upperBound(num, nums); // log N
            if (upper == -1) {
                sb.append(0).append(' ');
                continue;
            }

            int lower = lowerBound(num, nums); // log N

            sb.append(upper - lower + 1).append(' ');
        }
        System.out.println(sb); // O(3N logN)
    }

    private static int lowerBound(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int num = nums[mid];

            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                index = mid;
                right = mid - 1;
            }
        }

        return index;
    }

    private static int upperBound(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        int index = -1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int num = nums[mid];

            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                index = mid;
                left = mid + 1;
            }
        }

        return index;
    }

    private static int bSearch(int target, int[] nums) {
        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = (right + left) / 2;
            int num = nums[mid];

            if (target > num) {
                left = mid + 1;
            } else if (target < num) {
                right = mid - 1;
            } else {
                return mid;
            }

        }

        return -1;
    }
}
