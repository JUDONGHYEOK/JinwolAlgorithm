#include<iostream>
#include<stack>
#include<utility>
#include<vector>

using namespace std;

int main(){

    int numberOfTop;
    cin>>numberOfTop;

    stack<pair<int,int>> stk;                       // 순서, 높이 형식으로 저장
    vector<int> answer;
    int height;
    for(int order=1;order<numberOfTop+1;order++){   // 인덱스와는 다르게 순서는 1번부터 시작하므로 1부터 시작해서 numberOfTop+1까지 반복
        cin>>height;
        while(!stk.empty()){
            if(stk.top().second>height)             // stack overflow를 방지하기 위해 분리, 이전 높이가 비교높이보다 높으면 바로 반복문 탈출
                break;
            stk.pop();                              // 비교 높이보다 낮다면 다 pop시킴
        }
        if(stk.empty()){
            answer.push_back(0);                    // stack에 비교 높이보다 큰 높이의 탑이 없을 경우 answer에 0 추가
        }else{
            answer.push_back(stk.top().first);      // 있을경우엔 해당 높이 추가
        }
        stk.push(make_pair(order,height));          // 스택에 순서, 비교 높이 추가
    }
    for(int i=0;i<numberOfTop;i++){
        cout<<answer[i]<<" ";
    }
    return 0;
}