package mz.co.faktorize.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.co.faktorize.models.Supplier;

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
    private List<InvoiceDto> invoices;


    public static SupplierDto convertToDto(Supplier supplier) {
        if (supplier == null) return null;
        SupplierDto dto = new SupplierDto();
        dto.setId(supplier.getId());
        dto.setVatNumber(supplier.getVatNumber());
        dto.setName(supplier.getName());
        dto.setAdress(supplier.getAddress());
        dto.setCity(supplier.getCity());
        dto.setCountry(supplier.getCountry());
        return dto;
    }

    public static Supplier convertToEntity(SupplierDto dto) {
        if (dto == null) return null;
        Supplier supplier = new Supplier();
        supplier.setId(dto.getId());
        supplier.setVatNumber(dto.getVatNumber());
        supplier.setName(dto.getName());
        supplier.setAddress(dto.getAdress());
        supplier.setCity(dto.getCity());
        supplier.setCountry(dto.getCountry());
        return supplier;
    }
}
