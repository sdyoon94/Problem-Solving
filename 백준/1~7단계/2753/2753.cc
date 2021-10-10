#include <bits/stdc++.h>

using namespace std;

int yoon(int year){
    int flag=0;
    if(year%4==0) flag=1;
    if(year%100==0) flag=0;
    if(year%400==0) flag=1;

    return flag;
}

int main(){
    int year;
    cin>>year;
    cout<<yoon(year);
    return 0;
}
