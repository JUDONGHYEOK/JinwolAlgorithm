#include<iostream>
#include<map>

using namespace std;
int main(){
    int number;
    multimap<int,bool> mp;
    cin>>number;
    int count=0;
    int goodNumber;
    for(int i=0;i<number;i++){
        cin>>goodNumber;
        mp.insert(make_pair(goodNumber,false));
    }

    for(auto i=mp.begin();i!=mp.end();i++){
        for(auto j=mp.begin();j!=mp.end();j++){
            if(i!=j){
                int key=i->first+j->first;
                if(!mp.find(key)->second){
                    for(auto k=mp.lower_bound(key);k!=mp.upper_bound(key);k++){
                        
                        if(k!=i&&k!=j){
                            if(!k->second){
                                mp.erase(k);
                                mp.insert({key,true});
                                count++;
                            }
                        }
                        
                    }
                }
            }
        }
    }
    cout<<count<<endl;

    return 0;

}