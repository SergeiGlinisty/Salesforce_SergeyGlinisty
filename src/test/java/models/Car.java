package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder(builderClassName = "qwe", setterPrefix = "with")

public class Car {
    private String make, model;
    private int price;


}
