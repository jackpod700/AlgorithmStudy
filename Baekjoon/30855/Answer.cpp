#include <iostream>

using namespace std;

int input_num;
int count=0;

long gcd(long a, long b)
{
    long c;
	while(b)
	{
		c = a % b;
		a = b;
		b = c;
	}
    return a;
}

pair<long,long> fraction_calc(){
	pair<long,long> answer;
	char input[3];
    char close_parentheses;
	pair<long,long> input_pair[3];
	long g, denom, numer;
	for(int i=0;i<3;i++){
        if(++count>input_num){
            answer.first=-1;
            return answer;
        }
        cin>>input[i];
        if(input[i]>='0' && input[i]<='9'){
            input_pair[i].first=input[i]-'0';
            input_pair[i].second=1;
        }
        else if(input[i]=='('){
            input_pair[i]=fraction_calc();
            if(input_pair[i].first==-1){
                answer.first=-1;
                return answer;
            }
        }
        else{
            answer.first=-1;
            return answer;
        }
	}
    if(++count>input_num){
        answer.first=-1;
        return answer;
    }
    cin>>close_parentheses;
	if(close_parentheses==')'){
		numer = input_pair[0].first*input_pair[1].second*input_pair[2].first + input_pair[0].second*input_pair[1].first*input_pair[2].second;
		denom = input_pair[0].second*input_pair[1].second*input_pair[2].first;
		g = gcd(numer,denom);
		answer.first=numer/g;
		answer.second=denom/g;
	}
	else{
		answer.first=-1;
		return answer;
	}
    return answer;
}

int main()
{
	pair<long, long> answer;

	char first;
    cin>>input_num;
    if(++count>input_num){
        printf("-1");
        return 0;
    }
    cin>>first;
	if(first=='('){
		answer = fraction_calc();
	}
	else{
		printf("-1");
        return 0;
	}

	if(answer.first==-1 || count!=input_num){
		printf("-1");
	}
	else{
        cout<<answer.first<<" "<<answer.second;
	}

    return 0;
	
}
