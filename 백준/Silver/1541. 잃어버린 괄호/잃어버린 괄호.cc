#include <bits/stdc++.h>
#define MAX 55

using namespace std;

char expression[MAX];
int main(){
    scanf("%s", expression);
    vector<int> num;
    vector<char> oper;
    vector<int> cal;
    int n;
    bool chk=false;
    for(int i=0; expression[i]!='\0'; i++){
        if('0'<=expression[i]&&expression[i]<='9'){
            if(chk){
                n=n*10+expression[i]-'0';
            }
            else{
                n=expression[i]-'0';
                chk=true;
            }
        }
        else{
            chk=false;
            num.push_back(n);
            oper.push_back(expression[i]);
        }
    }
    num.push_back(n);
    int number=num[0];
    int size=oper.size();
    for(int i=0; i<size; i++){
        if(oper[i]=='-'){
            cal.push_back(number);
            number=num[i+1];
        }
        else if(oper[i]=='+'){
            number+=num[i+1];
        }
    }
    cal.push_back(number);
    size=cal.size();
    for(int i=1; i<size; i++) cal[0]-=cal[i];
    printf("%d\n", cal[0]);
    return 0;
}
