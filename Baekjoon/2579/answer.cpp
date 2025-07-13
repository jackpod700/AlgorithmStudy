#include<iostream>
#include<algorithm>

using namespace std;

int S[301];
int DT[301];
int DF[301];

int getD(int n, bool is_sequence){
    if(n==0){
        return 0;
    }
    if(n==1){
        return S[1];
    }
    if(is_sequence==true){
        if(DT[n]!=0){
            return DT[n];
        }
        DT[n] = getD(n-2, false) + S[n];
        return DT[n];
    }
    else{
        if(DF[n]!=0){
            return DF[n];
        }
        DF[n] = max(getD(n-1, true),getD(n-2, false)) + S[n];
        return DF[n];
    }
}

int main(){
    int n;
    cin >> n;
    for(int i=1; i<=n; i++){
        cin >> S[i];
    }
    fill(DT, DT+n+1, 0);
    fill(DF, DF+n+1, 0);
    cout << getD(n, false) << endl;
    return 0;
}