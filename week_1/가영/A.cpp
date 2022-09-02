//
// Created by kayoung on 2022/09/02.
//
#include <iostream>
#include <algorithm>
using namespace std;

int main() {
    string name = "Timur";
    sort(name.begin(), name.end());
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int n;
        cin >> n;
        string input;
        cin >> input;
        sort(input.begin(), input.end());
        string ans = (name == input) ? "YES" : "NO";
        cout << ans << endl;
    }
    return 0;
}
