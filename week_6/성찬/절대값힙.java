import java.io.*;
import java.util.*;

public class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        PriorityQueue<Number> pq = new PriorityQueue<>();
        for (int n : nums) {

            if (n == 0) {
                if (pq.isEmpty()) {
                    sb.append(0).append('\n');
                    continue;
                }

                sb.append(pq.poll().n).append('\n');
                continue;
            }


            pq.add(new Number(n));
        }

        System.out.println(sb);

    }

    static class Number implements Comparable<Number> {

        int n;

        public Number(int n) {
            this.n = n;
        }

        private int getAbs() {
            return Math.abs(n);
        }

        @Override
        public int compareTo(Number o) {
            int i1 = this.getAbs();
            int i2 = o.getAbs();

            if (i1 == i2) {
                return Integer.compare(this.n, o.n);
            }

            return Integer.compare(i1, i2);
        }

    }

    private static void input() throws IOException {
        InputReader r = new InputReader();

        N = r.nextInt();
        nums = new int[N];
        for (int i = 0; i < N; i++) {
            nums[i] = r.nextInt();
        }
    }

    private static class InputReader {
        StringTokenizer st;
        BufferedReader r;

        public InputReader(String filePath) throws FileNotFoundException {
            this(new FileReader(filePath));
        }

        public InputReader() {
            this(new InputStreamReader(System.in));
        }

        private InputReader(InputStreamReader reader) {
            r = new BufferedReader(reader);
            st = new StringTokenizer("");
        }

        public int nextInt() throws IOException {
            if (!st.hasMoreTokens()) st = new StringTokenizer(r.readLine());
            return Integer.parseInt(st.nextToken());
        }

        public char[] nextCharArr() throws IOException {
            return r.readLine().toCharArray();
        }
    }

}
