#include<iostream>

using namespace std;

int main()
{
    int input_num=0;
    int count=0;
    char input[50];

    scanf("%d", &input_num);
    int* answer = new int[input_num];

    for(int i=0;i<input_num;i++){
        scanf("%s", input);
        for(int j=0;input[j]!='\0';j++){
            if(input[j]=='('){
                count++;
            }
            else if(input[j]==')'){
                count--;
                if(count<0){
                    break;
                }
            }
        }
        if(count==0){
            answer[i]=1;
        }
        else{
            answer[i]=0;
        }
        count=0;
    }

    for(int i=0;i<input_num;i++){
        if(answer[i]==1){
            printf("YES\n");
        }
        else if(answer[i]==0){
            printf("NO\n");
        }
    }
}