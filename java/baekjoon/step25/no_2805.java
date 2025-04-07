package step25;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class no_2805 {

    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String[] parameters = reader.readLine().split(" ");
        int needTreeLength = Integer.parseInt(parameters[1]);
        Trees trees = new Trees(
                Arrays.stream(reader.readLine().split(" ")).mapToInt(Integer::parseInt).toArray()
        );
        TreeCutter treeCutter = new TreeCutter(trees);
        int result = treeCutter.cut(needTreeLength);
        System.out.println(result);
    }
}

class TreeCutter {

    private final Trees trees;

    TreeCutter(Trees trees) {
        this.trees = trees;
    }

    public int cut(int needTreeLength) {
        int left = 0;
        int right = trees.getLongestTree();

        while (left < right) {
            int mid = (left + right) / 2;
            long currentLength = trees.cut(mid);
            if (currentLength >= needTreeLength) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return left - 1;
    }
}

class Trees {

    private final int[] trees;

    public Trees(int[] trees) {
        this.trees = trees;
    }

    public int count() {
        return trees.length;
    }

    public long cut(int length) {
        long currentLength = 0;
        for (int tree : trees) {
            if (tree > length) {
                currentLength += tree - length;
            }
        }
        return currentLength;
    }

    public int getLongestTree() {
        return Arrays.stream(trees).max().orElse(0);
    }
}