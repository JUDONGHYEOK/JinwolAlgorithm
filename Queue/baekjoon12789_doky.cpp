#include<iostream>
#include<stack>
#include<queue>

using namespace std;

int main(){
    int number;                                 // 학생들의 수
    int list;                                   // 번호표
    queue<int> q;                               // 현재 줄서 있는곳
    stack<int> st;                              // 한명씩만 설수있는공간

    cin>>number;
    for(int i=0;i<number;i++){
        cin>>list;
        q.push(list);
    }

    int count=1;                                // 간식받는 순서
    while(1){
        if(!q.empty()&&q.front()==count){       // q의 앞과 순서가 일치할경우 pop,count++
            q.pop();
            count++;
        }else if(!st.empty()&&st.top()==count){ // 한명씩 설수있는 공간의 앞과 순서와 일치할경우 pop,count++
            st.pop();
            count++;
        }else if(q.empty()){                    // 앞선 두 경우를 확인하고 q에 더이상 빠질 학생수가없다면 sad
            cout<<"Sad";
            break;
        }else{                                  // q에 아직 원소가 남아있다면 stack으로 push
            st.push(q.front());
            q.pop();
        }
        if(count>number){                       // 순서가 학생수보다 더큰경우 Nice
            cout<<"Nice";
            break;
        }
    }
    return 0;
}