package mz.co.faktorize.dtos;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.co.faktorize.models.Invoice;


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

    public static InvoiceDto convertToDto(Invoice invoice) {
        if (invoice == null) return null;
        InvoiceDto dto = new InvoiceDto();
        dto.setId(invoice.getId());
        dto.setNumber(invoice.getNumber());
        dto.setGrossAmount(invoice.getGrossAmount());
        dto.setVatAmount(invoice.getVatAmount());
        dto.setDiscountPercentage(invoice.getDiscountPercentage());
        dto.setDiscountAmount(invoice.getDiscountAmount());
        dto.setNetAmount(invoice.getNetAmount());
        dto.setPaid(invoice.isPaid());
        dto.setSupplierId(invoice.getSupplier() != null ? invoice.getSupplier().getId() : null);
        if (invoice.getItems() != null) {
            dto.setItems(invoice.getItems().stream()
                .map(ItemDto::convertToDto)
                .toList());
        }
        return dto;
    }

    public static Invoice convertToEntity(InvoiceDto dto) {
        if (dto == null) return null;
        Invoice invoice = new Invoice();
        invoice.setId(dto.getId());
        invoice.setNumber(dto.getNumber());
        invoice.setGrossAmount(dto.getGrossAmount());
        invoice.setVatAmount(dto.getVatAmount());
        invoice.setDiscountPercentage(dto.getDiscountPercentage());
        invoice.setDiscountAmount(dto.getDiscountAmount());
        invoice.setNetAmount(dto.getNetAmount());
        invoice.setPaid(dto.isPaid());
        // You may need to fetch the Supplier entity by id elsewhere
        invoice.setSupplier(null);
        if (dto.getItems() != null) {
            invoice.setItems(dto.getItems().stream()
                .map(ItemDto::convertToEntity)
                .toList());
        }
        return invoice;
    }

}
