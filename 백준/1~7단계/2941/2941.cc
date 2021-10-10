#include <bits/stdc++.h>

using namespace std;

int main(){
    string s;
    int num=0;
    cin>>s;
    for(auto iter=s.rbegin(); iter!=s.rend(); iter++){
        if(*iter=='='){
            if(*(iter+1)=='c'){
                num++;
                iter++;
                continue;
            }
            else if(*(iter+1)=='s'){
                num++;
                iter++;
                continue;
            }
            else if(*(iter+1)=='z'&&*(iter+2)=='d'){
                num++;
                iter+=2;
                continue;
            }
            else if(*(iter+1)=='z'){
                num++;
                iter++;
                continue;
            }
        }
        else if(*iter=='-'){
            if(*(iter+1)=='c'){
                num++;
                iter++;
                continue;
            }
            else if(*(iter+1)=='d'){
                num++;
                iter++;
                continue;
            }
        }
        else if(*iter=='j'){
            if(*(iter+1)=='l'){
                num++;
                iter++;
                continue;
            }
            else if(*(iter+1)=='n'){
                num++;
                iter++;
                continue;
            }
        }
        num++;
    }
    printf("%d\n",num);
    return 0;
}
