package mz.co.faktorize.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter

@AllArgsConstructor
@NoArgsConstructor

public class SupplierDto {
    
    private Long id;
    private String vatNumber;
    private String name;
    private String adress;
    private String city;
    private String country;
}
