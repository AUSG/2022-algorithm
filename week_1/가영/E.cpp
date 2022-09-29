//
// Created by kayoung on 2022/09/02.
//
//
#include <iostream>
#include <algorithm>

using namespace std;

void solve();

long long area[1000 + 1][1000 + 1] = {};
long long dp[1000 + 1][1000 + 1] = {};

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        solve();
    }
    return 0;
}

void solve() {

    // 계산값 저장 배열 초기화
    for (int i = 0; i <= 1000; i++) {
        for(int j = 0; j <= 1000; j++) {
            area[i][j] = dp[i][j] = 0;
        }
    }

    int n, q; // n: the number of rectangles, q: the number of queries
    cin >> n >> q;

    for (int i = 0; i < n; i++) {
        int h, w;
        cin >> h >> w;
        area[h][w] += h * w;
    }

    // 높이가 i, 너비가 j인 영역에 들어가는 직사각형 넓이의 합 계산
    for (int i = 2; i <= 1000; i++) {
        for (int j = 2; j <= 1000; j++) {
            // 밑에서부터 순서대로 계산하므로 이전에 계산됐는지 체크하지 않고 바로 대입할 수 있음
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + area[i - 1][j - 1];
        }
    }

    // 쿼리 입력 & 답 출력
    for (int i = 0; i < q; i++) {
        long long hs, ws, hb, wb;
        cin >> hs >> ws >> hb >> wb;
        cout << dp[hb][wb] - dp[hs + 1][wb] - dp[hb][ws + 1] + dp[hs + 1][ws + 1] << endl;
    }
}