#include<iostream>
#include<vector>
#include<string>
using namespace std;

class Sudoku {
public:
    vector<vector<int>> board;  // 전체 9x9 보드
    vector<vector<bool>> rowCheck,colCheck,boxCheck;
    vector<pair<int,int>> empties;
    Sudoku() :
    board(9, vector<int>(9, 0)),
    rowCheck(9,vector<bool>(9,false)),
    colCheck(9,vector<bool>(9,false)),
    boxCheck(9,vector<bool>(9,false)){}

    void inputBoard() {
        for (int i = 0; i < 9; ++i) {
            string line;
            cin >> line;
            for (int j = 0; j < 9; ++j) {
                board[i][j] = line[j] - '0';
                int boxIdx = (i / 3) * 3 + (j / 3);     // 박스 번호 0~8
                if (board[i][j]!=0) {
                    int temp = board[i][j] - 1;
                    rowCheck[i][temp] = true;
                    colCheck[j][temp] = true;
                    boxCheck[boxIdx][temp] = true;
                }else {
                    empties.emplace_back(i,j);
                }


            }
        }
    }
    bool check(int row, int col,int k) {
        int rowI = row - 1;
        int colI = col - 1;
        int boxI = (row / 3) * 3 + (col / 3);
        int kI = k-1;
        if (rowCheck[rowI][kI] || colCheck[colI][kI] || boxCheck[boxI][kI]) {
            return false;
        }
        return true;
    }
    bool solve(int idx) {
        // 1) 모든 빈 칸을 다 채웠으면 성공
        if (idx == (int)empties.size()) return true;

        auto [r,c] = empties[idx];
        int b = (r/3)*3 + (c/3);
        for(int v=1; v<=9; v++){
            int k = v-1;
            if (!rowCheck[r][k] && !colCheck[c][k] && !boxCheck[b][k]) {
                // 놓기
                board[r][c] = v;
                rowCheck[r][k] = colCheck[c][k] = boxCheck[b][k] = true;

                // 재귀: 다음 빈 칸으로
                if (solve(idx+1)) return true;

                // 백트래킹
                board[r][c] = 0;
                rowCheck[r][k] = colCheck[c][k] = boxCheck[b][k] = false;
            }
        }
        // 1~9 전부 실패
        return false;
    }
    void printBoard() {
        for (int i = 0;i<9;i++) {
            for (int j = 0;j<9;j++) {
                cout << board[i][j];
            }
            cout << '\n';
        }
    }
};
int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    Sudoku game = Sudoku();
    game.inputBoard();
    if (game.solve(0))
        game.printBoard();
    else
        cout << "wrong!";
    return 0;

}