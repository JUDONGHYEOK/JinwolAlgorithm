#include<set>
#include<iostream>
#include<string>

using namespace std;

int main(){
    cin.tie(NULL);
    ios::sync_with_stdio(false);

    int number;
    set<string,greater<string>> st;
    string name,toWork;
    cin>>number;

    for(int i=0;i<number;i++){
        cin>>name;
        cin>>toWork;
        if(toWork=="enter"){
            if(st.count(name)){
                st.erase(name);
            }
            st.insert(name);
        }else{
            if(st.count(name)){
            st.erase(name);}
        }
    }

    for(auto i=st.begin();i!=st.end();i++){
        cout<<*i<<'\n';
    }
    return 0;


}