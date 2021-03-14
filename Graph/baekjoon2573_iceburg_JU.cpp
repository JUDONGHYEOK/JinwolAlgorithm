#include<iostream>
#include<vector>
#include<queue>

using namespace std;

bool isDivided(vector<int>land[],int row,int column){
    
    int x=0,y=0;
    vector<bool> on[column];
    for(int i=0;i<column;i++){
        on[i].resize(row);
    }
    
    for(int i=1;i<column-1;i++){
        for(int j=1;j<row-1;j++){
            if(land[i][j]!=0){
                on[i][j]=true;
                x=i;
                y=j;
            }
        }
    }
    queue<pair<int,int>>q;
    q.push({x,y});
    on[x][y]=false;
    while(!q.empty()){
        int a=q.front().first;
        int b=q.front().second;
        q.pop();
        if(on[a-1][b]){
            q.push({a-1,b});
            on[a-1][b]=false;
        }
        if(on[a][b-1]){
            q.push({a,b-1});
            on[a][b-1]=false;
        }
        if(on[a+1][b]){
            q.push({a+1,b});
            on[a+1][b]=false;
        }
        if(on[a][b+1]){
            q.push({a,b+1});
            on[a][b+1]=false;
        }
    }
    for(x=1;x<column-1;x++){
        for(y=1;y<row-1;y++){
            if(on[x][y]!=0){
                return false;
            }
        }
    }

    return true;
}

bool isZero(vector<int>land[],int row,int column){

    for(int i=1;i<column-1;i++){
        for(int j=1;j<row-1;j++){
            if(land[i][j]!=0)
                return false;
        }
    }
    return true;
}

int main(){
    int row,column;
    cin>>column>>row;

    vector<int>graph[column];
    vector<bool>isOn[column];
    for(int i=0;i<column;i++){
        graph[i].resize(row);
        isOn[i].resize(row);
    }
    for(int i=0;i<column;i++){
        for(int j=0;j<row;j++){   
            int number;
            cin>>number;
            if (i == 0 || i == column - 1 || j == 0 || j == row - 1) {
                graph[i][j] = 0;
                continue;
                }
            if(number!=0){
                graph[i][j]=number;
                isOn[i][j]=true;
            }
        }
    }
    int count=0;
    while(isDivided(graph,row,column)){
        count++;
        for(int i=1;i<column-1;i++){
            for(int j=1;j<row-1;j++){
                int minus=0;
                if(!isOn[i-1][j]){
                    minus++;
                }
                if(!isOn[i][j-1]){
                    minus++;
                }
                if(!isOn[i+1][j]){
                    minus++;
                }
                if(!isOn[i][j+1]){
                    minus++;
                }
                if(graph[i][j]>minus){
                    graph[i][j]-=minus;
                }else{
                    graph[i][j]=0;
                }
            }
        }
        for(int i=1;i<column-1;i++){
            for(int j=1;j<row-1;j++){
                if(graph[i][j]==0){
                    isOn[i][j]=false;
                }
            }
        }
        if(isZero(graph,row,column)){
            count=0;
            break;
        }
    }
    cout<<count;
    
    return 0;

}