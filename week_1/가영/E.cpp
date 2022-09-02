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
    int area[1000 + 1][1000 + 1] = {};

    int n, q; // n: the number of rectangles, q: the number of queries
    cin >> n >> q;

    for (int i = 0; i < n; i++) {
        int h, w;
        cin >> h >> w;
        area[h][w] += h * w;
    }

    int dp[1000 + 1][1000 + 1] = {};

    for (long long x = 2; x <= hb; x++) {
        if (dp[x][2] == 0) dp[x][2] = dp[x - 1][2] + area[x - 1][1];
        for (long long y = 3; y <= wb; y++) {
            if (dp[x][y] == 0) {
                dp[x][y] = dp[x - 1][y] + dp[x][y - 1] - dp[x - 1][y - 1] + area[x - 1][y - 1];
            }
        }
    }

    for (int i = 0; i < q; i++) {
        long long hs, ws, hb, wb;
        cin >> hs >> ws >> hb >> wb;
        cout << dp[hb][wb] - dp[hs + 1][wb] - dp[hb][ws + 1] + dp[hs + 1][ws + 1] << endl;
    }
}