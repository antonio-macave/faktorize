package mz.co.faktorize.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mz.co.faktorize.models.Invoice;
import mz.co.faktorize.models.Item;

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

    public static ItemDto convertToDto(Item item) {
        if (item == null) return null;
        ItemDto dto = new ItemDto();
        dto.setId(item.getId());
        dto.setQuantity(item.getQuantity());
        dto.setDescription(item.getDescription());
        dto.setGrossAmount(item.getGrossAmount());
        dto.setInvoiceId(item.getInvoice() != null ? item.getInvoice().getId() : null);
        return dto;
    }

    public static Item convertToEntity(ItemDto dto) {
        if (dto == null) return null;

        Invoice invoice = new Invoice();
        if (dto.getInvoiceId() != null) {
            invoice.setId(dto.getInvoiceId());
        }

        Item item = new mz.co.faktorize.models.Item();
        item.setId(dto.getId());
        item.setQuantity(dto.getQuantity());
        item.setDescription(dto.getDescription());
        item.setGrossAmount(dto.getGrossAmount());
        item.setInvoice(invoice);
        return item;
    }

}
