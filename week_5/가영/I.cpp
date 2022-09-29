//
// Created by kayoung on 2022/09/25.
//
#include <iostream>
#include <math.h>

using namespace std;

int main() {
    int yt = 0, yj = 0, both = 0;
    int A, B, C, D;
    cin >> A >> B >> C >> D;
    for (int i = 2; i < 1000 + 1; i++) {
        bool isPrime = true;
        for (int j = 2; j <= sqrt(i); j++) {
            if (0 == i % j) {
                isPrime = false;
                break;
            }
        }
        if (isPrime) {
            bool isYt = A <= i && i <= B, isYj = C <= i && i <= D;
            if (isYt && isYj) { both++; }
            else if (isYt) { yt++; }
            else if (isYj) { yj++; }
        }
    }
    if (yt == yj) {
        if (both % 2 == 1) {
            cout << "yt";
        } else {
            cout << "yj";
        }
    } else if (yt > yj) {
        cout << "yt";
    } else {
        cout << "yj";
    }
}