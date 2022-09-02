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

    for (int i = 2; i <= 1000; i++) {
        for (int j = 2; j <= 1000; j++) {
            dp[i][j] = dp[i - 1][j] + dp[i][j - 1] - dp[i - 1][j - 1] + area[i - 1][j - 1];
        }
    }

    for (int i = 0; i < q; i++) {
        long long hs, ws, hb, wb;
        cin >> hs >> ws >> hb >> wb;

        cout << dp[hb][wb] - dp[hs + 1][wb] - dp[hb][ws + 1] + dp[hs + 1][ws + 1] << endl;
    }
}