#include<iostream>
#include<stack>
#include<string>
#include<vector>

using namespace std;

int main(){
    string sentense;
    stack<char> right;
    vector<char> answer;
    int number;
    char command,ch;

    cin>>sentense;
    cin>>number;

    for(int i=0,j=sentense.length();i<j;i++){
        answer.push_back(sentense[i]);
    }

    for(int i=0;i<number;i++){
        cin>>command;
        if(command=='L'){
            if(!answer.empty()){
                right.push(answer.back());
                answer.pop_back();
            }
        }else if(command=='D'){
            if(!right.empty()){
                answer.push_back(right.top());
                right.pop();
            }
        }else if(command=='P'){
            cin>>ch;
            answer.push_back(ch);
        }else{
            if(!answer.empty()){
                answer.pop_back();
            }
        }
    }
    while(!right.empty()){
        answer.push_back(right.top());
        right.pop();
    }
    for(int i=0,j=answer.size();i<j;i++){
        cout<<answer[i];
    }



    return 0;
}