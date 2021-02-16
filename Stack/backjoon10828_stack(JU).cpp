#include<iostream>
#include<vector>
#include<string>

using namespace std;

void empty(vector<int> stack){
    stack.empty()?cout<<1<<endl:cout<<0<<endl;
}
void push(vector<int>&stack){
    int number;
    cin>>number;
    stack.push_back(number);
}
void pop(vector<int>&stack){
    if(!stack.empty()){
        cout<<stack.back()<<endl;
        stack.pop_back();
    }else{
        cout<<-1<<endl;;
    }
}
int top(vector<int> stack){
    if(!stack.empty()){
        return stack.back();
    }
    return -1;
}
int size(vector<int> stack){
    return stack.size();
}

int main(){
    int count;
    string command;
    cin>>count;
    vector<int> stack;
    for(int i=0;i<count;i++){
        cin>>command;
        if(command=="push"){
            push(stack);
        }else if(command=="pop"){
            pop(stack);
        }else if(command=="empty"){
            empty(stack);
        }else if(command=="top"){
            cout<<top(stack)<<endl;
        }else{
            cout<<size(stack)<<endl;
        }
    }
    return 0;
}
