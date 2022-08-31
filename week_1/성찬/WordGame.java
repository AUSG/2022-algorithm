package spell_check;


import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.*;

public class a {

    // 한명만 썼다. 그럼 3점
    // 두명이 썼다. 둘다 1점
    // 세명이 썼다. 빵점

    static InputReader r;

    static int T;

    static StringBuilder answer = new StringBuilder();

    private static void solution() throws IOException {

        int col = r.nextInt();

        String[] r1 = r.nextLine().split(" ");
        String[] r2 = r.nextLine().split(" ");
        String[] r3 = r.nextLine().split(" ");


        Map<String, Integer> map = new HashMap<>();
        // r1을 map에 넣는다.
        // r1의 초기 점수는 col * 3;
        // 값은 1로 설정

        // r2를 map에 넣는다.
        // 이미 키가 존재한다면 r1 - 2, r2 + 1
        // 키가 없다면 r2 + 3
        // 값은 2를 더하거나 2로 설정한다.

        // r3을 map에 조회한다.
        // 키가 존재한다면
        // -- 값이 1인지 2인지 3인지 판단한다
        // ---- 값이 1이라면 r1 - 2, r3 + 1
        // ---- 값이 2라면면 r2 - 2, r3 + 1
        // ---- 값이 3이라면 r1 - 1, r2 - 1,
        // 키가 없다면 r3 + 3

        int r1s = col * 3;
        int r2s = 0;
        int r3s = 0;

        // r1 넣기
        for (String s : r1) {
            map.put(s, 1);
        }

        // r2 넣기
        for (String s : r2) {
            if (map.containsKey(s)) {
                r1s -= 2;
                r2s += 1;

                map.put(s, 3);
                continue;
            }

            map.put(s, 2);
            r2s += 3;
        }

        // r3 넣기
        for (String s : r3) {
            if (map.containsKey(s)) {
                Integer value = map.get(s);

                if (value == 1) {
                    r1s -= 2;
                    r3s += 1;
                }

                if (value == 2) {
                    r2s -= 2;
                    r3s += 1;
                }

                if (value == 3) {
                    r1s -= 1;
                    r2s -= 1;
                }
                continue;
            }

            r3s += 3;
        }

        answer.append(r1s).append(' ').append(r2s).append(' ').append(r3s).append('\n');
    }

    private static void input() throws IOException {
        r = new InputReader("/Users/user/Downloads/boj/src/test/java/spell_check/input.txt");
        T = r.nextInt();
    }

    @Test
    public static void main(String[] args) throws IOException {
        input();
        for (int t = 0; t < T; t++) {
            solution();
        }
        System.out.println(answer.toString());
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

        public String nextLine() throws IOException {
            return r.readLine();
        }

    }

}
