//
// Created by kayoung on 2022/09/02.
//
//
#include <iostream>
#include <algorithm>

using namespace std;


void solve();

int main() {
    int t;
    cin >> t;
    for (int i = 0; i < t; i++) {
        solve();
    }
    return 0;
}

void solve() {
    int count[1000 + 1][1000 + 1] = {}; // count[i][j] : 가로 i, 세로 j인 rectangle 의 개수

    int n, q; // n: the number of rectangles, q: the number of queries
    cin >> n >> q;

    for (int i = 0; i < n; i++) {
        int h, w;
        cin >> h >> w;
        count[h][w]++;
    }

    int dp[1000 + 1][1000 + 1] = {};

    for (int i = 0; i < q; i++) {
        int hs, ws, hb, wb;
        cin >> hs >> ws >> hb >> wb;

        for (int x = 2; x <= hb; x++) {
            if (dp[x][2] == 0) dp[x][2] = dp[x - 1][2] + (x - 1) * count[x - 1][1];
            for (int y = 3; y <= wb; y++) {
                if (dp[x][y] == 0) dp[x][y] = max(dp[x - 1][y], dp[x][y - 1]) + (x - 1) * (y - 1) * count[x - 1][y - 1];
            }
        }

        // hb wb 보다 작은 애들 - hs ws 포함 애들 넓이 (중복 차감은 다시 더함)
        cout << dp[hb][wb] - dp[hs + 1][wb] - dp[hb][ws + 1] + dp[hs + 1][ws + 1] << endl;
        // 모루겠따.
    }
}