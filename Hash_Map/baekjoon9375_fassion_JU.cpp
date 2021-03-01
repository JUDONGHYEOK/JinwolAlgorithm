#include <string>
#include <vector>
#include <unordered_map>
#include<iostream>

using namespace std;

int main(){
    int number,size;
    string clothes,category;
    unordered_map<string,int> allClothes;
    cin>>number;


    for(int i=0;i<number;i++){
        cin>>size;
        int answer=1;
        for(int j=0;j<size;j++){
            cin>>clothes;
            cin>>category;
            if(allClothes.count(category)){
                auto it=allClothes.find(category);
                int p=it->second+1;
                allClothes[category]=p;
            }else{
                allClothes.insert({category,1});
            }
        }
        for(auto it=allClothes.begin();it!=allClothes.end();it++){
            answer*=(it->second+1);
        }
        answer-=1;
        cout<<answer<<'\n';
        allClothes.clear();
    }
    return 0;
}