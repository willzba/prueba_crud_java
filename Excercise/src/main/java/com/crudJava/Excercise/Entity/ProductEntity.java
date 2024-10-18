package com.crudJava.Excercise.Entity;
import lombok.*;

import java.util.UUID;

@Data
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class ProductEntity {

    UUID id;
    String name;
    String category;
    double price;
    int stock;

}
