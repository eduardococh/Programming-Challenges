class Solution {
		//My solution, good runtime better than 100%
		//Memory better than 55.62%, meh
		//Took me 40min to do, runtime o(n2), memory o(1)
    public void rotate(int[][] matrix) {
        int aux=0,aux1=0;
        final int length=matrix.length;
        for(int j=0;j<length/2;j++){
            for(int i=0;i<length-(j*2)-1;i++){

                //upper right corner matrix[j+i][length-j-1]
                aux=matrix[j+i][length-j-1];
                matrix[j+i][length-j-1]=matrix[j][j+i];

                //lower right corner matrix[length-j-1][length-j-i-1]
                aux1=matrix[length-j-1][length-j-i-1];
                matrix[length-j-1][length-j-i-1]=aux;

                //lower left corner matrix[length-j-i-1][j]
                aux=matrix[length-j-i-1][j];
                matrix[length-j-i-1][j]=aux1;

                //upper left corner matrix[j][j+i]
                matrix[j][j+i]=aux;

            }    
        }
    }
}

class Solution {
		//Clearer elegant solution by leetcode samples
		//Appeared as best runtime at 34672 kb but this measure is tricky in leetcode
		//Same runtime and memory
    public void rotate(int[][] matrix) {
        int n = matrix.length;
        int iMax = n/2 + (n % 2 == 1? 1 : 0);
        int temp = 0;
        for (int i = 0; i < iMax; i++) {
            for (int j = i; j < n-i-1; j++) {
                temp = matrix[i][j];
                matrix[i][j] = matrix[n-j-1][i];
                matrix[n-j-1][i] = matrix[n-i-1][n-j-1];
                matrix[n-i-1][n-j-1] = matrix[j][n-i-1];
                matrix[j][n-i-1] = temp;
            }
        }
    }
}


//Solution by shichaotan

/*
 * clockwise rotate
 * first reverse up to down, then swap the symmetry 
 * 1 2 3     7 8 9     7 4 1
 * 4 5 6  => 4 5 6  => 8 5 2
 * 7 8 9     1 2 3     9 6 3
*/
void rotate(vector<vector<int> > &matrix) {
    reverse(matrix.begin(), matrix.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}

/*
 * anticlockwise rotate
 * first reverse left to right, then swap the symmetry
 * 1 2 3     3 2 1     3 6 9
 * 4 5 6  => 6 5 4  => 2 5 8
 * 7 8 9     9 8 7     1 4 7
*//*
void anti_rotate(vector<vector<int> > &matrix) {
    for (auto vi : matrix) reverse(vi.begin(), vi.end());
    for (int i = 0; i < matrix.size(); ++i) {
        for (int j = i + 1; j < matrix[i].size(); ++j)
            swap(matrix[i][j], matrix[j][i]);
    }
}*/