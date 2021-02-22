#include<iostream>
#include<string>

using namespace std;
void printReverse(const char *str) {
  cout<<endl<<"call"<<endl;
  if (!*str){
    return;}
  cout<<str;
  printReverse(str + 1);

  putchar(*str);

}
int main(){
    cout<<"put your sentense"<<endl;
    string test;
    getline(cin,test);
    printReverse(test.c_str());
    return 0;
}