#include<iostream>
#include<vector>

using namespace std;


void reverseString(vector<char>& s) {
    vector<char>::iterator it;
    cout<<"call"<<endl;
    for (it = s.begin(); it < s.end(); it++) cout << " " << *it;
         cout << endl;
    for(int i=0,j=s.size();i<j;i++)
    {
        s.erase(s.begin());
        s.push_back(s.front());
        reverseString(s);
    }
    // s.pop_back();
    // reverseString(s);

    // for (it = s.begin(); it < s.end(); it++) cout << " " << *it;
    //      cout << endl;
    // reverseString(s);
    // s.push_back(s.front());
    
}

int main(){
    vector<char>::iterator it;
    vector<char> test={'H','a','n','n'};
    reverseString(test);
    for (it = test.begin(); it < test.end(); it++) cout << " " << *it;
         cout << endl;
    return 0;
}