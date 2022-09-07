import java.io.*;
import java.util.*;

class Main {

    static InputReader r;

    static int N;
    static int K;
    static int[] priorities;

    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        r = new InputReader("/Users/user/workspace/study/algorithm-study/boj/프린터큐/input.txt");

        int T = r.nextInt();

        for (int t = 0; t < T; t++) {
            input();
            solution();
        }

        System.out.println(sb.toString());
    }

    private static void solution() {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        Queue<Document> q = new LinkedList<>();

        for (int i = 0; i < N; i++) {
            pq.add(priorities[i]);
            q.add(new Document(i, priorities[i]));
        }

        while (!q.isEmpty()) {
            Document d = q.peek();
            int maxPriority = pq.peek();
            if (d.priority >= maxPriority) {
                q.poll();
                pq.poll();

                if (d.idx == K) {
                    break;
                }
            } else if (d.priority < maxPriority) {
                q.add(q.poll());
            }

        }

        sb.append(N - q.size()).append('\n');
    }

    public static class Document implements Comparable<Document> {
        int idx;
        int priority;

        public Document(int idx, int priority) {
            this.idx = idx;
            this.priority = priority;
        }

        @Override
        public int compareTo(Document d) {
            return priority - d.priority;
        }

    }

    private static void input() throws IOException {
        N = r.nextInt();
        K = r.nextInt();

        priorities = new int[N];

        for (int i = 0; i < N; i++) {
            priorities[i] = r.nextInt();
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