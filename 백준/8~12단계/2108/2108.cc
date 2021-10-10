#include <bits/stdc++.h>
#include <unordered_map>
using namespace std;

bool compare(pair<int, int> a, pair<int, int> b){
    if(a.second == b.second) return a.first < b.first;
    else return a.second > b.second;
}

int main(){
    long long min=4001, max=-4001, sum=0;
    double avg;
    vector<long long> n;
    int N, CBP;
    unordered_map<int, int> many;
    scanf("%d", &N);
    for(int i=0; i<N; i++){
        long long tmp;
        scanf("%lld", &tmp);
        n.push_back(tmp);
        sum+=tmp;
        if(tmp>max) max=tmp;
        if(tmp<min) min=tmp;
        many[tmp]++;
    }
    vector<pair<int, int>> many_sort(many.begin(), many.end());
    sort(many_sort.begin(), many_sort.end(), compare);
    if(many_sort.begin()->second==(many_sort.begin()+1)->second) CBP = (many_sort.begin()+1)->first;
    else CBP = many_sort.front().first;
    avg=(double)sum/N;
    sort(n.begin(), n.end());
    printf("%.0lf\n%lld\n%d\n%lld\n", avg, n[(N-1)/2], CBP, max-min);
    return 0;
}
