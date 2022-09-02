//
// Created by kayoung on 2022/09/02.
//
#include <iostream>
#include <map>
#include <vector>


using namespace std;

int main() {
    int T;
    cin >> T;
    for (int i = 0; i < T; i++) {
        int score[3] = {};
        int n;
        cin >> n;
        map<string, int> wordToScore = {}; // 나중에 세명의 점수를 합해서 출력하기 위해 단어별 점수를 저장하는 map
        map<int, vector<string>> manToWords = {}; // 세명이 말한 단어를 저장하는 map
        for (int i = 0; i < 3; i++) { // 3명의 답
            manToWords[i] = {};
            for (int j = 0; j < n; j++) { // n개의 단어
                string word;
                cin >> word;
                manToWords.find(i)->second.push_back(word);
                map<string, int>::iterator it = wordToScore.find(word);
                if (it != wordToScore.end()) {
                    if (it->second == 3) {
                        it->second = 1;
                    } else {
                        it->second = 0;
                    }
                } else {
                    wordToScore[word] = 3;
                }
            }
        }
        for(int i = 0;i < 3; i++) {
            for (int j = 0; j < n; j++) {
                string st = manToWords[i].back();
                manToWords[i].pop_back();
                score[i] += wordToScore.find(st)->second;
            }
        }
        cout << score[0] << " " << score[1] << " " << score[2] << endl;
    }
    return 0;
}