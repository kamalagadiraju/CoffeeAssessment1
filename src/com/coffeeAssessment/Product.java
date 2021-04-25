

package com.coffeeAssessment;

import java.util.Map;

import com.google.gson.annotations.SerializedName;

public class Product {

@SerializedName("drink_name")
private String drinkName;
@SerializedName("prices")
private Map<String,Double> prices;

public String getDrinkName() {
return drinkName;
}

public void setDrinkName(String drinkName) {
this.drinkName = drinkName;
}

public Map<String,Double> getPrices() {
return prices;
}

public void setPrices(Map<String,Double> prices) {
this.prices = prices;
}

}