#include<iostream>
#include<string>


using namespace std;

bool three(int a,int b){
    if(a<10){
        cout<<b;
        return (a==3||a==6||a==9);
    }
    three(a,b++);
}

int main(){
    int number=1234567;
    

}