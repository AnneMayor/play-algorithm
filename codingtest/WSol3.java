package codingtest;

import java.util.HashMap;
import java.util.Map;

public class WSol3 {

    static class ProductInfo {
        private String name;
        private int price;

        public ProductInfo(String name, int price) {
            this.name = name;
            this.price = price;
        }

        public String getName() {
            return name;
        }

        public int getPrice() {
            return price;
        } 
    }

    public String[] solution(String[] productInfo, String[] dailyProductSales) {
        int numOfDailyProductSales = dailyProductSales.length;
        String[] answer = new String[numOfDailyProductSales];

        Map<String, ProductInfo> productInfoMap = new HashMap<>();

        for(String product : productInfo) {
            String[] productInfoArray = product.split(",");
            productInfoMap.put(productInfoArray[0], new ProductInfo(productInfoArray[1], Integer.parseInt(productInfoArray[2])));
        }


        for(int index = 0; index < numOfDailyProductSales; index++) {
            String[] dailyProductSaleArray = dailyProductSales[index].split(",");

            StringBuilder sb = new StringBuilder();
            sb.append(dailyProductSaleArray[0]).append(",");
            sb.append(dailyProductSaleArray[1]).append(",");

            ProductInfo foundProduct = productInfoMap.get(dailyProductSaleArray[1]);
            sb.append(foundProduct.getName()).append(",");
            sb.append(foundProduct.getPrice() * Integer.parseInt(dailyProductSaleArray[2]));

            answer[index] = sb.toString();
        }

        return answer;
    }
    
}
