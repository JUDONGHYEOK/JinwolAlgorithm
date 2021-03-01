#include<map>
#include<iostream>
#include<string>

using namespace std;

int main() {
	map<string, int>mp;
	int num;
	cin >> num;

	for (int i = 0; i < num; i++) {
		string book;
		cin >> book;
		if (mp.count(book)) {
			int number = mp[book];
			mp[book] = number + 1;
		}
		else {
			mp.insert({ book, 1 });
		}
	}
	string answer;
	int count = 0;
	for (auto i = mp.begin(); i != mp.end(); i++) {
		if ((i->second) > count) {
			count = i->second;
			answer = i->first;
		}
	}
	cout << answer;

	return 0;
}