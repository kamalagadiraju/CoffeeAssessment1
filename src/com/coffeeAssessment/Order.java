package com.coffeeAssessment;

import com.google.gson.annotations.SerializedName;

public class Order {

@SerializedName("user")
private String user;
@SerializedName("drink")
private String drink;
@SerializedName("size")
private String size;

public String getUser() {
return user;
}

public void setUser(String user) {
this.user = user;
}

public String getDrink() {
return drink;
}

public void setDrink(String drink) {
this.drink = drink;
}

public String getSize() {
return size;
}

public void setSize(String size) {
this.size = size;
}
}