public class 자물쇠와열쇠 {
    private static int[][] key;
    private static int[][] lock;
    public boolean solution(int[][] key, int[][] lock) {
        this.key = key;
        this.lock = lock;

        for (var index = 0; index < 4; index++) {
            if (index > 0) {
                rotate();
            }
            for (var row = -(lock.length - 1); row < lock.length - 1; row++) {
                for (var col = -(lock.length - 1); col < lock.length - 1; col++) {
                    if (unlock(row, col)) {
                        return true;
                    }
                }
            }
        }

        return false;
    }

    private boolean unlock(int row, int col) {
        for (var currentRow = 0; currentRow < lock.length; currentRow++) {
            for (var currentCol = 0; currentCol < lock.length; currentCol++) {
                if (row + currentRow >= 0 && col + currentCol >= 0 && row + currentRow < key.length && col + currentCol < key.length) {
                    if (lock[currentRow][currentCol] == key[currentRow + row][currentCol + col]) {
                        return false;
                    }
                } else {
                    if (lock[currentRow][currentCol] == 0) {
                        return false;
                    }
                }
            }
        }

        return true;
    }


    private void rotate() {
        int[][] result = new int[key.length][key.length];
        for(int row = 0; row < key.length; row++){
            for(int col = 0; col < key.length; col++){
                result[row][col] = key[key.length - 1 - col][row];
            }
        }
        key = result;
    }
}
