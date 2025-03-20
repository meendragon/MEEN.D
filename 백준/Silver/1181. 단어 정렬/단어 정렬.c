#include<stdio.h>
#include<stdlib.h>
#include<string.h>
int compare(const void* a, const void* b);
int compare(const void* a, const void* b)
{
	int difference_len = strlen(*(char**)a) - strlen(*(char**)b);
	if (difference_len == 0)
		return strcmp(*(char**)a, *(char**)b);
	return difference_len;
}
int main()
{
	int N;
	scanf("%d", &N);
	char** str = (char*)malloc(sizeof(char*) * N);
	for (int i = 0; i < N; i++) {
		str[i] = (char*)malloc(sizeof(char) * 51);
	}
	for (int i = 0; i < N;i++)
	{
		scanf("%s", str[i]);
	}
	qsort(str,N,sizeof(char*),compare);
	for (int i = 0; i < N; i++)
	{
		if (i != (N - 1))
		{
			if (strcmp(str[i], str[i + 1]) == 0)
				continue;
		}
		
		printf("%s\n", str[i]);
	}

	free(str);
	return 0;
}