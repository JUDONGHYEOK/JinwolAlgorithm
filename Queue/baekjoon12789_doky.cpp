#include<iostream>
#include<string>
#include<stack>
#include<queue>

using namespace std;

int main(){
    int number;
    cin>>number;
    int list;
    queue<int> q;
    stack<int> st;
    for(int i=0;i<number;i++){
        cin>>list;
        q.push(list);
    }
    int count=1;
    while(1){
        if(!q.empty()&&q.front()==count){
            q.pop();
            count++;
        }else if(!st.empty()&&st.top()==count){
            st.pop();
            count++;
        }else if(q.empty()){
            cout<<"Sad";
            break;
        }else{
            st.push(q.front());
            q.pop();
        }
        if(count>number){
            cout<<"Nice";
            break;
        }
    }
    return 0;
}