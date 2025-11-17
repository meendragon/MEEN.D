#include<stdio.h>
#include<stdlib.h>
int find_Bmax(char** str, int start_row, int start_col);
int find_Wmax(char** str, int start_row, int start_col);
int find_min(int x, int y);
int main()
{
	int min = 64;
	int row, col;
	scanf("%d %d", &row, &col);
	char** chess = (char**)malloc(sizeof(char*) * row);
	for (int i = 0; i < row; i++)
	{
		chess[i] = (char*)malloc(col * sizeof(char));
	}
	for (int i = 0; i < row; i++)
	{
		for (int j = 0; j < col; j++)
		{
			scanf(" %c", &chess[i][j]);
		}
	}
	int end_row = row - 7;
	int end_col = col - 7;
	for (int i = 0; i < end_row; i++)
	{
		for (int j = 0; j < end_col; j++)
		{
			int a = find_Bmax(chess, i, j);
			int b = find_Wmax(chess, i, j);
			min = find_min(a, min);
			min = find_min(b, min);
		}
	}

	printf("%d", min);
	free(chess);
	return 0;
}
int find_Bmax(char** str,int start_row, int start_col)
{
	int count = 0;
	for (int i = start_row; i < start_row + 8; i++)
	{
		int key_row = i - start_row;
		for (int j = start_col; j < start_col + 8; j++)
		{
			int key_col = j - start_col;
			int stand = key_row + key_col;
			if (stand % 2 == 0)
			{
				if (str[i][j] == 'W')
					count++;
			}
			else if (stand % 2 != 0)
			{
				if (str[i][j] == 'B')
					count++;
			}
		}
	}
	return count;

}
int find_Wmax(char** str, int start_row, int start_col)
{
	int count = 0;
	for (int i = start_row; i < start_row + 8; i++)
	{
		int key_row = i - start_row;
		for (int j = start_col; j < start_col + 8; j++)
		{
			int key_col = j - start_col;
			int stand = key_row + key_col;
			if (stand % 2 == 0)
			{
				if (str[i][j] == 'B')
					count++;
			}
			else if (stand % 2 != 0)
			{
				if (str[i][j] == 'W')
					count++;
			}
		}
	}
	return count;

}
int find_min(int x, int y)
{
	if (x > y)
		return y;
	else
		return x;
}