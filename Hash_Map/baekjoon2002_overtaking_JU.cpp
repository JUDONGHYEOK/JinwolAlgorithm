#include<iostream>
#include<unordered_map>
#include<string>
#include<set>

using namespace std;

void printCar(unordered_map<string,set<string>> c){
    for(auto i=c.begin();i!=c.end();i++){
        cout<<"now: "<<i->first;
        for(auto j=i->second.begin();j!=i->second.end();j++){
           cout<<" before: "<<*j;}
    cout<<endl;
    }
}

bool isOvertaking(set<string>before,set<string>after){
    for(auto i=before.begin();i!=before.end();i++){
        if(after.count(*i)==0){
            return true;
        }
    }
    return false;
}

int main(){
    int number;
    string car,beforeCar;
    unordered_map<string,set<string>> orderBefore;
    set<string> cars;

    cin>>number;
    int i=0;
    do{
        cin>>car;
        orderBefore.insert(make_pair(car,cars));
        cars.insert(car);
        i++;
    }while(i!=number);

    cars.clear();
    i=0;
    int count=0;
    do{
        cin>>car;
        cars.insert(car);
        if(isOvertaking(orderBefore.find(car)->second, cars)){
            count++;
        }
        i++;
    }while(i!=number);

    cout<<count;

    return 0;
}