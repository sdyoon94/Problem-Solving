#include <bits/stdc++.h>

using namespace std;

int main(){
    int N;
    scanf("%d", &N);
    vector<pair<int, int>> students;
    while(N--){
        int x, y;
        scanf("%d %d", &x, &y);
        students.push_back(make_pair(x, y));
    }
    for(auto student : students){
        int ans=1;
        for(auto iter=students.begin(); iter!=students.end(); iter++){
            if(student.first<iter->first && student.second<iter->second) ans++;
        }
        printf("%d ", ans);
    }
    return 0;
}
