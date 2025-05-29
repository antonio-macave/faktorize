package mz.co.faktorize.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class InvoiceDto {

    private Long id;
    private String number;
    private double grossAmount;
    private double vatAmount;
    private double discountPercentage;
    private double discountAmount;
    private double netAmount;
    private boolean paid;
    private Long supplierId;

    private List<ItemDto> items;

}
