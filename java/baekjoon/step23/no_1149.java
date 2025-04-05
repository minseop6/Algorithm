package step23;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class no_1149 {

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int count = Integer.parseInt(reader.readLine());
        List<HouseColorPrice> prices = IntStream.rangeClosed(1, count).boxed().map(index -> {
            try {
                return HouseColorPrice.from(reader.readLine());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }).collect(Collectors.toList());

        HouseColorPriceDP houseColorPriceDP = new HouseColorPriceDP(prices);
        int result = houseColorPriceDP.calculatePrice();
        System.out.println(result);
    }
}

class HouseColorPrice {

    private final Map<Color, Integer> colorPriceMap;

    static HouseColorPrice from(String rawPrices) {
        String[] prices = rawPrices.split(" ");
        return new HouseColorPrice(
                Integer.parseInt(prices[0]),
                Integer.parseInt(prices[1]),
                Integer.parseInt(prices[2])
        );
    }

    private HouseColorPrice(int redPrice, int greenPrice, int bluePrice) {
        colorPriceMap = Map.of(
                Color.RED, redPrice,
                Color.GREEN, greenPrice,
                Color.BLUE, bluePrice
        );
    }

    public int getPrice(Color color) {
        return colorPriceMap.get(color);
    }
}

class HouseColorPriceDP {

    private final List<HouseColorPrice> houseColorPrices;
    private final int[][] dp = new int[1001][3];

    public HouseColorPriceDP(List<HouseColorPrice> houseColorPrices) {
        this.houseColorPrices = houseColorPrices;
    }

    public int calculatePrice() {
        for (int index = 1; index <= houseColorPrices.size(); index++) {
            HouseColorPrice houseColorPrice = houseColorPrices.get(index - 1);
            int redPrice = houseColorPrice.getPrice(Color.RED);
            int greenPrice = houseColorPrice.getPrice(Color.GREEN);
            int bluePrice = houseColorPrice.getPrice(Color.BLUE);

            dp[index][Color.RED.getIndex()] =
                    Math.min(dp[index - 1][Color.GREEN.getIndex()], dp[index - 1][Color.BLUE.getIndex()]) + redPrice;
            dp[index][Color.GREEN.getIndex()] =
                    Math.min(dp[index - 1][Color.RED.getIndex()], dp[index - 1][Color.BLUE.getIndex()]) + greenPrice;
            dp[index][Color.BLUE.getIndex()] =
                    Math.min(dp[index - 1][Color.RED.getIndex()], dp[index - 1][Color.GREEN.getIndex()]) + bluePrice;
        }

        return Stream.of(dp[houseColorPrices.size()][Color.RED.getIndex()],
                dp[houseColorPrices.size()][Color.GREEN.getIndex()],
                dp[houseColorPrices.size()][Color.BLUE.getIndex()]
        ).min(Integer::compareTo).orElse(Integer.MAX_VALUE);
    }
}

enum Color {
    RED(0),
    GREEN(1),
    BLUE(2);

    private final int index;

    Color(int index) {
        this.index = index;
    }

    public int getIndex() {
        return index;
    }
}