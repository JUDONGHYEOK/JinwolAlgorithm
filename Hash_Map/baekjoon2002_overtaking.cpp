#include<iostream>
#include<unordered_map>
#include<string>
#include<vector>

using namespace std;

int main(){
    int number;
    string car;
    unordered_map<string,int> carIndex;
    vector<int>carAfterTunnel;
    cin>>number;
    int i=0;
    do{
        cin>>car;
        carIndex[car]=i;
        i++;
    }while(i!=number);

    i=0;
    do{
        cin>>car;
        carAfterTunnel.push_back(carIndex[car]);
        i++;
    }while(i!=number);

    int count=0;
    for(int i=0;i<number-1;i++){
        for(int j=i+1;j<number;j++){
            if(carAfterTunnel[i]>carAfterTunnel[j]){
                count++;
                break;
            }
        }
    }    
    cout<<count;

    return 0;
}