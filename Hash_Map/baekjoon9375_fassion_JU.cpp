#include <string>
#include <vector>
#include <unordered_map>
#include<iostream>

using namespace std;

int solution(vector<vector<string>> clothes) {
    int answer = 1;
    unordered_map<string,int> allClothes;
    pair<string,int> cloth;
    string cl,ca;
    
    for(int i=0,j=clothes.size();i<j;i++){
        if(allClothes.count(clothes[i][1])){
            auto it=allClothes.find(clothes[i][1]);
            int number=it->second+1;
            allClothes.erase(clothes[i][1]);
            cloth={clothes[i][1],number};
            allClothes.insert(cloth);
        }else{
            cloth={clothes[i][1],1};
            allClothes.insert(cloth);
        }
    }
    for(auto it=allClothes.begin();it!=allClothes.end();it++){
        answer*=(it->second+1);
    }
    answer-=1;
    return answer;
}

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