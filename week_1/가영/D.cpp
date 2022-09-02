//
// Created by kayoung on 2022/09/02.
//
#include <iostream>
#include <vector>
#include <queue>

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
    long long n;
    cin >> n;
    string pos;
    cin >> pos;

    int bestRes[2*100000] = {};
    for(int i = 0; i < n/2+1; i++) {
        if (bestRes[i] !=0) break;
        bestRes[i] = bestRes[n-1-i] = n-1-i;
    }

    priority_queue<long long> pQueue = {};
    int currRes[2*100000] = {};
    long long total = 0;
    for (int i = 0;i < n; i++) {
        if (pos[i] == 'L') {
            currRes[i] = i;
        } else {
            currRes[i] = n-1-i;
        }
        if (bestRes[i]!= currRes[i]) {
            pQueue.push(bestRes[i] - currRes[i]);
        }

        total += currRes[i];
    }

    for(int i = 0; i < n; i++) {
        if (pQueue.empty()) {
            cout << total << " ";
        } else {
            total += pQueue.top();
            pQueue.pop();
            cout << total << " ";
        }
    }
    cout << endl;
}
