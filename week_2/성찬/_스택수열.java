import java.io.*;
import java.util.*;

class Main {

    static int N;
    static int[] nums;

    public static void main(String[] args) throws IOException {
        input();
        solution();
    }

    private static void solution() {
        StringBuilder sb = new StringBuilder();

        int stackNum = 1;
        int numsIdx = 0;

        Stack<Integer> stack = new Stack<>();
        stack.add(0);
        while (numsIdx < N) {
            if (stack.peek() < nums[numsIdx]) {
                stack.add(stackNum++);
                sb.append('+').append('\n');
            } else if (stack.peek() > nums[numsIdx]) {
                System.out.println("NO");
                return;
            } else if (stack.peek() == nums[numsIdx++]) {
                stack.pop();
                sb.append('-').append('\n');
            }
        }

        System.out.println(sb.toString());
    }

    private static void input() throws IOException {
        InputReader r = new InputReader("/Users/user/workspace/study/algorithm-study/boj/스택/input.txt");

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