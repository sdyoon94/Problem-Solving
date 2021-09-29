#include <bits/stdc++.h>

using namespace std;

int main(){
    int num[3];
    for(int i=0; i<3; i++){
        string tmp;
        cin>>tmp;
        if(tmp.compare("black")==0) num[i]=0;
        else if(tmp.compare("brown")==0) num[i]=1;
        else if(tmp.compare("red")==0) num[i]=2;
        else if(tmp.compare("orange")==0) num[i]=3;
        else if(tmp.compare("yellow")==0) num[i]=4;
        else if(tmp.compare("green")==0) num[i]=5;
        else if(tmp.compare("blue")==0) num[i]=6;
        else if(tmp.compare("violet")==0) num[i]=7;
        else if(tmp.compare("grey")==0) num[i]=8;
        else if(tmp.compare("white")==0) num[i]=9;
    }
    if(num[0]==0){
        if(num[1]==0){
            printf("0");
        }
        else{
            printf("%d",num[1]);
            for(int i=0; i<num[2]; i++) printf("0");
        }
        return 0;
    }
    for(int i=0; i<2; i++){
        printf("%d",num[i]);
    }
    for(int i=0; i<num[2]; i++) printf("0");

    return 0;
}
