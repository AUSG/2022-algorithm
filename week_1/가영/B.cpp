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
        bool r;
        if (firstR[i] == 'R' || secR[i] == 'R') {
            if (firstR[i] != secR[i]) {
                cout << "NO" << endl;
                return;
            }
        }
    }
    cout << "YES" << endl;
}