import java.io.BufferedReader;
import java.io.InputStreamReader;

public class _1074_Z {

    private static int R;
    private static int C;
    private static int count;
    private static boolean done = false;

    @Test
    public static void main(String[] args) throws Exception {
        BufferedReader r = new BufferedReader(new InputStreamReader(System.in));
        String[] input = r.readLine().split(" ");
        int n = Integer.parseInt(input[0]);
        R = Integer.parseInt(input[1]);
        C = Integer.parseInt(input[2]);
        count = 0;

        int N = (int) Math.pow(2, n);
        recursion(0, N, 0, N);
     }

    private static void recursion(int startR, int endR, int startC, int endC) {
        if (done) return;
        if (endR < R || endC < C) {
            count += (endR - startR) * (endC - startC);
            return;
        }

        if (endR - startR == 2 && endC - startC == 2) {
            check(startR, startC);
            check(startR, startC + 1);
            check(startR + 1, startC);
            check(startR + 1, startC + 1);
        } else {
            int midR = startR + (endR - startR) / 2;
            int midC = startC + (endC - startC) / 2;
            recursion(startR, midR, startC, midC);
            recursion(startR, midR, midC, endC);
            recursion(midR, endR, startC, midC);
            recursion(midR, endR, midC, endC);
        }

    }

    private static void check(int startR, int startC) {
        if (startR == R && startC == C) {
            System.out.println(count);
            done = true;
        } else {
            count++;
        }
    }
}
