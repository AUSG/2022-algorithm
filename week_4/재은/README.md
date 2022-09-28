https://www.hackerearth.com/practice/algorithms/dynamic-programming/2-dimensional/practice-problems/algorithm/gcd-game-11/

Problem

Life and death, win or lose - both have two sides to each other. And that's what **Arjit** and **Chandu Don** are fighting about. They are tired of gang-wars between each other, and thus decide to settle like men in a field, of Mathematics.

But even while going to play the game of Mathematics, they have not given up on their tactics of hurting each other. So, **Arjit** carries a number of rubber bullets with himself, and **Chandu Don** carries b number of rubber bullets. Since, Little Chandu is a more dangerous gangster of the two, he decides to give the first chance to Arjit.

The way they’re going to decide who wins the entire land of **HEpur** is by playing the age-old game of **GCD-DCG**. The first one to end up with only 1 bullet is going to lose.

This is how the game progresses:

```
1.  If GCD (a, b) is greater than 1, then, the player can:
        a.) Subtract 1 from opposite player’s bullets.   
        **OR**
        b.) Divide the number of bullets of opposite player by GCD (a, b).
 2. If GCD (a, b) is equal to 1, then, the player can:
      a.) Subtract 1 from the opposite player’s bullets.
```

**Note** : Player can choose only one move out of two if GCD(A,B)>1 .
The one who ends up with only one bullet loses the battle, and his life, and the land of **HEpur**.

Determine who is going to rule, once and for all!

**input:**
First line contains number of test cases **T**, next **T** lines contains two numbers **A** and **B** taken by **Arjit** and **Chandu Don** respectively.

**Output:**
Print the name of winner of the game in case of draw print **Draw**.

**Constraints**
1<=**T**<=1000
1<=**A**<=1000
1<=**B**<=1000

**Problem Statement Credit : Arjit Srivastava**.

Sample Input

```
4
2 1
3 4
5 5
1 1
```

Sample Output

```
Arjit
Chandu Don
Arjit
Draw
```

```c++
#include <bits/stdc++.h>
using namespace std;
int GCD[1002][1002];
bool vis[1002][1002][2];
int dp[1002][1002][2];
void pre()
{
	for ( int i = 1; i <= 1000; i++ ) {
		for ( int j = 1; j <= i; j++ ) {
			GCD[i][j] = GCD[j][i] = __gcd(i,j);
		}
	}
	return;
}
int f(int a, int b, int turn)
{
	if ( turn == 0 ) {
		if ( a == 1 ) return 0;
	}	
	if ( turn == 1 ) {
		if ( b == 1 ) return 0;
	}
	if ( vis[a][b][turn] ) return dp[a][b][turn];
	vis[a][b][turn] = true;
	int ans = 0;
	if ( turn == 0 ) {
		ans |= (!f(a,b-1,turn^1));
		if ( GCD[a][b] != 1 ) ans |= (!f(a,b/GCD[a][b],turn^1));
	}
	else {
		ans |= (!f(a-1,b,turn^1));
		if ( GCD[a][b] != 1 ) ans |= (!f(a/GCD[a][b],b,turn^1));
	}
	dp[a][b][turn] = ans;
	return ans;
}
int main() {
	int t,A,B;
	pre();
	cin >> t;
	while ( t-- ) {
		cin >> A >> B;
		if(A==1 && B==1)
			cout<<"Draw"<<endl;
		else if(A==1)
			cout<<"Prateek"<<endl;
		else if(B==1)
			cout<<"Gautam"<<endl;
		else{
			if ( f(A,B,0) ) cout << "Gautam"<<endl ;
			else cout << "Prateek"<<endl;
		}
	}
	return 0;
}
```
