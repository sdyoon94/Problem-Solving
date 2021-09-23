#include <bits/stdc++.h>

using namespace std;

int main(){
    int C;
    scanf("%d", &C);
    while(C--){
        vector<double> student;
        double N, sum=0, avg, overAvg=0;
        scanf("%lf", &N);
        for(int i=0; i<N; i++){
            double tmp;
            scanf("%lf",&tmp);
            student.push_back(tmp);
            sum+=tmp;
        }
        avg=sum/N;
        for(double i:student){
            if(i>avg) overAvg++;
        }
        printf("%0.3lf%%\n",overAvg*100/N);
    }
    return 0;
}
