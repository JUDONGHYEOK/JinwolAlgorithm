#include<iostream>
#include<stack>
#include<stdio.h>

using namespace std;


int number(stack<int>st,int number){
    while(!st.empty()){
        if(st.top()>number)
            return st.size();
        st.pop();
    }
    return 0;
}
int main(){

    int number1;
    scanf("%d",&number1);

    stack<int> st;
    int number2;
    for(int j=0;j<number1;j++){
        scanf("%d",&number2);
        st.push(number2);
        printf("%d ",number(st,number2));
    }
    return 0;
}