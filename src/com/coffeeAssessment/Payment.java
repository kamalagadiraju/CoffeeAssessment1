package com.coffeeAssessment;

import com.google.gson.annotations.SerializedName;

public class Payment {

@SerializedName("user")
private String user;
@SerializedName("amount")
private Double amount;

public String getUser() {
return user;
}

public void setUser(String user) {
this.user = user;
}

public Double getAmount() {
return amount;
}

public void setAmount(Double amount) {
this.amount = amount;
}

}