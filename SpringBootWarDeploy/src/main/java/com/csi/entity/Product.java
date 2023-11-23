package com.csi.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Product {

    @Id
    @GeneratedValue
    private int prodId;

    @Size(min = 2, message = "Product Name Must Have Atleast 2 characters")
    private String prodName;

    private double prodPrice;

    @JsonFormat(pattern = "dd-MM-yyyy")
    private Date prodLaunchDate;


}
