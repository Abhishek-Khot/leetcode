class Solution {
    public double largestTriangleArea(int[][] points) {
        double maxArea = 0.0;
        int n = points.length;
        for(int i= 0;i<n;i++){
            for(int j = i+1;j<n;j++){
                for(int k = j+1;k<n;k++){
                    double x1 = points[i][0];
                    double y1 = points[i][1];

                    double x2 = points[j][0];
                    double y2 = points[j][1];

                    double x3 = points[k][0];
                    double y3 = points[k][1];

                    double edge1 = Math.hypot(x2-x1,y2-y1);
                    double edge2 = Math.hypot(x3-x2,y3-y2);
                    double edge3 = Math.hypot(x3-x1,y3-y1);
                    double s = (edge1 + edge2 + edge3) * 0.5;
                      double currArea = Math.abs(
                        x1 * (y2 - y3) +
                        x2 * (y3 - y1) +
                        x3 * (y1 - y2)
                    ) / 2.0;

                    maxArea = Math.max(maxArea,currArea);
                }
            }
        }
        return maxArea;
    }
}