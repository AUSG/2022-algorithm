//
// Created by kayoung on 2022/09/29.
//

#include <iostream>
#include <map>

using namespace std;

int main() {
    int N;
    cin >> N;
    map<int, int> sizeToCnt = {};
    int ans = 1;
    for (int i = 0; i < N; i++) {
        int matSize;
        cin >> matSize;
        if (sizeToCnt.find(matSize) != sizeToCnt.end()) {
            sizeToCnt[matSize]++;
            if (ans < sizeToCnt[matSize]) ans = sizeToCnt[matSize];
        } else {
            sizeToCnt[matSize] = 1;
        }
    }
    cout << ans;
    return 0;
}