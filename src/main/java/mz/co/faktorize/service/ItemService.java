package mz.co.faktorize.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mz.co.faktorize.dtos.ItemDto;
import mz.co.faktorize.models.Invoice;
import mz.co.faktorize.models.Item;
import mz.co.faktorize.repository.InvoiceRepository;
import mz.co.faktorize.repository.ItemRepository;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;
    private final InvoiceRepository invoiceRepository;

    public ItemService(ItemRepository itemRepository, InvoiceRepository invoiceRepository) {
        this.itemRepository = itemRepository;
        this.invoiceRepository = invoiceRepository;
    }

    public ItemDto findItemById(Long id) {
        Item item = itemRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found."));
        return ItemDto.convertToDto(item);
    }

    public List<ItemDto> findItemsByInvoiceId(Long invoiceId) {
        Invoice invoice = invoiceRepository.findInvoiceById(invoiceId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice not found."));
        return itemRepository.findItemsByInvoiceId(invoice.getId()).stream()
            .map(ItemDto::convertToDto)
            .collect(Collectors.toList());
    }

    public ItemDto saveItem(ItemDto itemDto) {
        Invoice invoice = invoiceRepository.findInvoiceById(itemDto.getInvoiceId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice not found."));
        
        Item item = ItemDto.convertToEntity(itemDto);
        item.setInvoice(invoice);
        Item savedItem = itemRepository.save(item);
        return ItemDto.convertToDto(savedItem);
    }

    public void deleteItemById(Long id) {
        if (!itemRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Item not found.");
        }
        itemRepository.deleteItemById(id);
    }

}
