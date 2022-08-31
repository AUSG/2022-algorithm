package spell_check;

import org.junit.jupiter.api.Test;

import java.io.*;
import java.util.StringTokenizer;

public class colourblindness {

    static InputReader r;
    static int T;
    static char R = 'R';
    static StringBuilder answer = new StringBuilder();

    private static void solution() throws IOException {

        // R G B

        // G==B
        int col = r.nextInt();
        String r1 = r.nextLine();
        String r2 = r.nextLine();

        // 오른쪽으로 전진
        for (int i = 0; i < col; i++) {

            //  위 아래가 같으면 오른쪽으로
            if (check(r1.charAt(i), r2.charAt(i))) {
                continue;
            }

            answer.append("NO\n");
            return;
        }

        answer.append("YES\n");
    }

    static boolean check(char a, char b) {
        if (a == b) return true;
        return a != R && b != R;
    }

    private static void input() throws IOException {
        r = new InputReader();
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
