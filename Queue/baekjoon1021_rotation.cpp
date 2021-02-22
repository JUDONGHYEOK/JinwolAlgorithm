#include<iostream>
#include<deque>

using namespace std;

int findlist(deque<int>dq,int number){
    for(int i=0,j=dq.size();i<j;i++){
        if(dq.front()==number)
            return i;
        dq.pop_front();
    }
    return -1;
}

void print(deque<int>dq){
    for(int i=0,j=dq.size();i<j;i++){
        cout<<dq.front()<<" ";
        dq.pop_front();
    }
    cout<<endl;
}

int main(){
    int number,count,targetNumber,answer=0;
    deque<int> dq,left,right;


    cin>>number;
    for(int i=0;i<number;i++){
        dq.push_back(i+1);
    }
    cin>>count;
    for(int i=0;i<count;i++){
        cin>>targetNumber;
        int targetIndex=findlist(dq,targetNumber);
        if(targetIndex<=(dq.size()/2)){
            for(int j=0;j<targetIndex;j++){
                dq.push_back(dq.front());
                dq.pop_front();
                answer++;
            }
            dq.pop_front();
        }else{
            for(int j=0;j<dq.size()-targetIndex;j++){
                dq.push_front(dq.back());
                dq.pop_back();
                answer++;
            }
            dq.pop_front();
        }
    }
    cout<<answer;
    return 0;
}