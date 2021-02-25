#include<map>
#include<iostream>
#include<string>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int number,answer;
    string id,password;
    map<string,string>mp;
    cin>>number;
    cin>>answer;
    for(int i=0;i<number;i++){
        cin>>id;
        cin>>password;
        mp.insert({id,password});
    }
    for(int i=0;i<answer;i++){
        cin>>id;
        cout<<mp.find(id)->second<<endl;
    }
    return 0;
}