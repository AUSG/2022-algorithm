//
// Created by kayoung on 2022/09/29.
//

#include <iostream>

using namespace std;

int main() {
    int n;
    cin >> n;
    int dp[100000 + 1] = {};
    dp[0] = dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;
    dp[4] = 7;
    dp[5] = 13;
    for (int i = 6; i <= n; i++) {
        dp[i] = (dp[i - 1] + dp[i - 2] + dp[i - 4] + dp[i - 5]) % 1004;
    }
    cout << dp[n];
}
