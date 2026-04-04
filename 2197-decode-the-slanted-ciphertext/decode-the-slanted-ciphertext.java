class Solution {
    public String decodeCiphertext(String encodedText, int rows) {
        // in between zeros are present so delete the trailing zeros 
        StringBuilder sb = new StringBuilder();
        int n = encodedText.length();// total need to travel
        int cols = n / rows; // total cols 

        // iterate on the column peck up col element and jump until length with jump of cols + 1 
        for(int col = 0;col < cols;col++){
            for(int j = col;j < n;j +=cols +1){
                sb.append(encodedText.charAt(j));
            }
        }
        // strip the trailing zeros 
        for(int i = sb.length() - 1;i >= 0;i--){
            if(sb.charAt(i) == ' '){
                sb.deleteCharAt(sb.length() -1);
            }
            else{
                break;
            }
        }
        return sb.toString();
    }
}