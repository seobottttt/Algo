#include <iostream>
#include <algorithm>

using namespace std;

int dp[301];
int point[301];
int stair;
int stair_point;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(false);

	cin >> stair;

	for (int i = 1; i <= stair; i++) {
		cin >> stair_point;
		point[i] = stair_point;
	}

	dp[1] = point[1];
	dp[2] = point[1] + point[2];
	dp[3] = max(point[1] + point[3], point[2] + point[3]);
	
	for (int i = 4; i <= stair; i++) {
		dp[i] = max(dp[i - 2] + point[i], dp[i - 3] + point[i] + point[i - 1]);
	}

	cout << dp[stair];


}