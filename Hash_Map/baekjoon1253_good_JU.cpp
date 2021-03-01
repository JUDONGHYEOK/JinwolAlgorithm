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
        mp.insert(make_pair(goodNumber,false));                                 // 중복 체크 방지를 위해 해당 숫자와 false의 형태로 저장한다.
    }

    for(auto i=mp.begin();i!=mp.end();i++){             
        for(auto j=mp.begin();j!=mp.end();j++){
            if(i!=j){                                                           // 같은 인덱스를 참조하는 것을 방지
                int key=i->first+j->first;                  
                if(!mp.find(key)->second){                                      // 두수의 합이 먼저 체크 되어있었는지 확인
                    for(auto k=mp.lower_bound(key);k!=mp.upper_bound(key);k++){ // 두 수의 합의 가장 낮은 인덱스부터 큰 인덱스까지
                        
                        if(k!=i&&k!=j){                                         // 자신을 제외한 두수의 합이므로
                            if(!k->second){                                     // 표시 되지 않은 수라면
                                mp.erase(k);                                    // 지우고
                                mp.insert({key,true});                          // 다시 true로 삽입 & count++
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