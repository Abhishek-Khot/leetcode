// store the steps bcz of fixed perimeter every time moves iterate 
// east 0, west 1,south 2, north 3

class Robot {
    public List<int[]> moves = new ArrayList<>();
    public int idx = 0;
    public boolean moved = false;

    public Robot(int width, int height) {
        // start from 0,0 to 0 to width 
        for (int x = 0; x < width; x++) {
            moves.add(new int[] { x, 0, 0 });// east going 
        }
        // from 1 to height north 
        for (int y = 1; y < height; y++) {
            moves.add(new int[] { width - 1, y, 3 });
        }
        // from height - 2 to 0 fix the height 
        for (int x = width - 2; x >= 0; x--) {
            moves.add(new int[] { x, height - 1, 1 });//west going
        }

        // from width - 2 to 1 
        for (int y = height - 2; y > 0; y--) {
            moves.add(new int[] { 0, y, 2 });
        }
        // to handle the cover case of 0,0 ,, one circle complete then 
        // it will facing to south so start with south and if no moves done
        // then just return the east 
        if (moves.size() > 0) {

            moves.get(0)[2] = 2;
        }
    }

    public void step(int num) {
        moved = true;
        idx = (idx + num) % moves.size();
    }

    public int[] getPos() {
        return new int[] { moves.get(idx)[0], moves.get(idx)[1] };
    }

    public String getDir() {
        // corner case 
        if (!moved) {
            return "East";
        }
        int dir = moves.get(idx)[2];
        if (dir == 0) {
            return "East";
        } else if (dir == 1) {
            return "West";
        } else if (dir == 2) {
            return "South";
        } else {
            return "North";
        }

    }
}

/**
 * Your Robot object will be instantiated and called as such:
 * Robot obj = new Robot(width, height);
 * obj.step(num);
 * int[] param_2 = obj.getPos();
 * String param_3 = obj.getDir();
 */