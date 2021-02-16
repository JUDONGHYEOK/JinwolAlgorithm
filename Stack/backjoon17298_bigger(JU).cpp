#include<iostream>
#include<stack>
#include<vector>
#include<utility>

using namespace std;

int main(){
    int number;
    cin>>number;
    vector<int> answer(number,-1);
    stack<pair<int,int>> stk;
    int target;
    for(int i=0;i<number;i++){
        cin>>target;
        while(!stk.empty()){
            if(stk.top().second>=target)
                break;
            answer[stk.top().first]=target;
            stk.pop();
        }
        stk.push(make_pair(i,target));
    }
    for(int i=0;i<number;i++){
        cout<<answer[i]<<" ";
    }
    return 0;
}