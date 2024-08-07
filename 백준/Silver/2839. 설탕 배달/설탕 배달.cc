#include <iostream>

using namespace std;

int n;
int result;

int main() {

	cin.tie(0);
	ios::sync_with_stdio(false);


	cin >> n;

	while (n >= 0) {

		if (n % 5 == 0) {
			result += (n / 5);
			cout << result;
			return 0;
		}
		n -= 3;
		result++;

	}

	cout << -1;
	

	
}