//
// Created by kayoung on 2022/09/02.
//
#include <iostream>

using namespace std;

void solve();

int main() {
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        solve();
    }
    return 0;
}

void solve() {
    int n;
    cin >> n;
    string firstR, secR;
    cin >> firstR >> secR;
    for (int i = 0; i < n; i++) {
        if (firstR[i] == 'R' || secR[i] == 'R') { // 해당 열에 빨간색이 있는 경우
            if (firstR[i] != secR[i]) { // 둘다 빨간색이 아니면 B 또는 G가 있다는 거니까 NO
                cout << "NO" << endl;
                return;
            }
        }
    }
    cout << "YES" << endl;
}