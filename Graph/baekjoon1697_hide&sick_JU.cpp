#include<iostream>
#include<queue>

using namespace std;

int main(){

    int start,target;
    cin>>start>>target;

    queue<pair<int,int>>graph;
    bool isVisited[100001]={0,};
    graph.push({0,start});
    int count,number;
    while(1){
        count=graph.front().first;
        number=graph.front().second;
        
        if(number==target){
            break;
        }

        if(number-1==target||number+1==target||2*number==target){
            count++;
            break;
        }
        isVisited[number]=1;
        graph.pop();
        if(number-1>=0&&!isVisited[number-1]){
            graph.push({count+1,number-1});
        }
        if(number+1<=100000&&!isVisited[number+1]){
            graph.push({count+1,number+1});
        }
        if(2*number<=100000&&!isVisited[2*number]){
            graph.push({count+1,2*number});
        }
    }
    
    cout<<count<<'\n';

    return 0;
}