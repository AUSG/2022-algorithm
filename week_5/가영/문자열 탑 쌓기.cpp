//
// Created by kayoung on 2022/09/29.
// https://www.acmicpc.net/problem/25643

#include <iostream>

using namespace std;

int main() {
    int N, M;
    cin >> N >> M;
    string top;
    cin >> top;
    int ans = 1;
    for (int i = 0; i < N - 1; i++) {
        string input;
        cin >> input;
        bool can = false;
        int comp;
        for (int j = 0; j < M && !can; j++) {
            comp = top.substr(0, j + 1).compare(input.substr(M - 1 - j, j + 1));
            if (comp == 0) {
                can = true;
            }
        }
        for (int j = 0; j < M && !can; j++) {
            comp = input.substr(0, j + 1).compare(top.substr(M - 1 - j, j + 1));
            if (comp == 0) {
                can = true;
            }
        }
        if (!can) {
            ans = 0;
            break;
        }
        top = input;
    }
    cout << ans;
}