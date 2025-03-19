#include<stdio.h>
int main()
{
    char str1[4],str2[4];
    int answ1,answ2;
    scanf(" %c %c %c",&str1[0],&str1[1],&str1[2]);
    scanf(" %c %c %c",&str2[0],&str2[1],&str2[2]);
    
    str1[3]=str1[0];
    str1[0]=str1[2];
    str1[2]=str1[3];
    
    str2[3]=str2[0];
    str2[0]=str2[2];
    str2[2]=str2[3];
    
    answ1 = 100*(str1[0]-'0')+10*(str1[1]-'0')+(str1[2]-'0');
    answ2 = 100*(str2[0]-'0')+10*(str2[1]-'0')+(str2[2]-'0');
    
    if(answ1>answ2)
        printf("%d",answ1);
    else
        printf("%d",answ2);
    
    
    return 0;
}