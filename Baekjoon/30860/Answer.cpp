#include <iostream>

int main()
{
	int num, count=0, min_supply, next_start=0;
	scanf("%d",&num);
	int* supplies = new int[num*2];

	for(int i=0;i<num;i++)
	{
		scanf("%d %d",&supplies[2*i],&supplies[2*i+1]);
	}

	while(supplies[(num-1)*2]>0)
	{
		min_supply=0;
		for(int i=next_start;i<num;i++)
		{	
			if(min_supply<=supplies[2*i+1])
			{
				if(min_supply<supplies[2*i]) min_supply=supplies[2*i];
				supplies[2*i]-=min_supply;
				supplies[2*i+1]-=min_supply;
			}
			else
			{
				next_start=i;
				break;
			}
		}
		count++;

	}

	printf("%d",count);
	return 0;

}
