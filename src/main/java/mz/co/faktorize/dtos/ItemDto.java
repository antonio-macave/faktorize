package mz.co.faktorize.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor
public class ItemDto {

    private Long id;
    private int quantity;
    private String description;
    private double grossAmount;
    private Long invoiceId;

}
