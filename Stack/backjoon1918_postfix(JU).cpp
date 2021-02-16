#include<iostream>
#include<string>
#include<stack>
#include<vector>

using namespace std;

int main(){
    string infix;
    getline(cin,infix);
    stack<char> oper;
    vector<char> answer;

    for(int i=0,j=infix.size();i<j;i++){
        if(infix[i]=='+'){
            while(!oper.empty()){
                    if(oper.top()=='(')
                        break;
                    answer.push_back(oper.top());
                    oper.pop();
                }
            oper.push(infix[i]);
        }else if (infix[i]=='-'){
            while(!oper.empty()){
                    if(oper.top()=='(')
                        break;
                    answer.push_back(oper.top());
                    oper.pop();
                }
            oper.push(infix[i]);
        }else if (infix[i]=='*'){
            while(!oper.empty()){
                    if(oper.top()=='('||oper.top()=='+'||oper.top()=='-')
                        break;
                    answer.push_back(oper.top());
                    oper.pop();
                }
            oper.push(infix[i]);
        }else if (infix[i]=='/'){
            while(!oper.empty()){
                    if(oper.top()=='('||oper.top()=='+'||oper.top()=='-')
                        break;
                    answer.push_back(oper.top());
                    oper.pop();
                }
            oper.push(infix[i]);
        }else if(infix[i]=='('){
            oper.push(infix[i]);
        }else if (infix[i]==')'){
            while(!oper.empty()){
                    if(oper.top()=='('){
                        oper.pop();
                        break;}
                    answer.push_back(oper.top());
                    oper.pop();
                }
        }else{
            answer.push_back(infix[i]);
        }
    }
    
    while(!oper.empty()){
        answer.push_back(oper.top());
        oper.pop();
    }
    
    for(int i=0,j=answer.size();i<j;i++){
        cout<<answer[i];
    }

    return 0;
}
