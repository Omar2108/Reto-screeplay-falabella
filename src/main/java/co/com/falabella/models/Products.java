package co.com.falabella.models;


import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Products {
    private String productName;
    private int productQuantity;
}
