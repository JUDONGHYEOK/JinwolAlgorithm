#include<iostream>
#include<set>
#include<queue>

using namespace std;

int main(){
    int time;
    cin>>time;
    for(int j=0;j<time;j++){
        int size, targetIndex;
        int number;
        queue<pair<int,int>>q;
        multiset<int,greater<int>> st;

        cin>>size;
        cin>>targetIndex;
        for(int i=0;i<size;i++){
            int number;
            cin>>number;
            q.push(make_pair(i,number));
            st.insert(number);
        }
        int count=0;
        while(1){
            if(q.front().second==*st.begin()){
                st.erase(st.begin());
                count++;
                if(targetIndex==q.front().first){
                    break;
                }
                q.pop();
            }else{
                q.push(q.front());
                q.pop();
            }
        }
        cout<<count<<endl;
    }
    return 0;
}