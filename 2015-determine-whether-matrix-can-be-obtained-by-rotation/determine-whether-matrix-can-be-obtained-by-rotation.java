class Solution {
    public boolean findRotation(int[][] mat, int[][] target) {
        for(int i =0;i<4;i++){
            if(isSame(mat,target)){
                return true;
            }
            rotate90(mat);
        }
        return false;
    }
    public boolean isSame(int[][] mat,int[][] target){
        int row = mat.length;
        int col = mat[0].length;
        for(int i =0;i<row;i++){
            for(int j =0;j<col;j++){
                if(mat[i][j] != target[i][j]){
                    return false;
                }
            }
        }
        return true;
    }
    public void rotate90(int[][] mat){
        int row = mat.length;
        int col = mat[0].length;
        //transpose
        for(int i =0;i<row;i++){
            for(int j =i;j<col;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[j][i];
                mat[j][i] = temp;
            }
        }
        //reverse 
        int lastIdx = mat[0].length-1;
        for(int i =0;i<row;i++){
            //j is iterating on the each row
            //going on the each row and swaping the j and index -j
            //and it is going half 
            //that i the row length
            for(int j =0;j<mat[i].length/2;j++){
                int temp = mat[i][j];
                mat[i][j] = mat[i][lastIdx -j];
                mat[i][lastIdx -j] = temp;
            }
        }
    }
}
    