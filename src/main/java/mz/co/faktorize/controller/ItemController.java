package mz.co.faktorize.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import mz.co.faktorize.dtos.ItemDto;
import mz.co.faktorize.service.ItemService;

@RestController
public class ItemController {

    private final ItemService itemService;

    public ItemController(ItemService itemService) {
        this.itemService = itemService;
    }

    @PostMapping("/items")
    public ResponseEntity<ItemDto> createItem(@RequestBody ItemDto itemDto) {
        ItemDto savedItem = itemService.saveItem(itemDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(savedItem);
    }

    @GetMapping("/items/{id}")
    public ResponseEntity<ItemDto> getItemById(@PathVariable("id") Long id) {
        ItemDto itemDto = itemService.findItemById(id);
        return ResponseEntity.ok(itemDto);
    }

    @GetMapping("/invoices/{invoiceId}/items")
    public ResponseEntity<List<ItemDto>> getItemsByInvoiceId(@PathVariable("invoiceId") Long invoiceId) {
        List<ItemDto> items = itemService.findItemsByInvoiceId(invoiceId);
        return ResponseEntity.ok(items);
    }

    @PutMapping("/items/{id}")
    public ResponseEntity<ItemDto> updateItem(@PathVariable("id") Long id, @RequestBody ItemDto updatedItemDto) {
        ItemDto updatedItem = itemService.updateItemDto(id, updatedItemDto);
        return ResponseEntity.ok(updatedItem);
    }

    @DeleteMapping("/items/{id}")
    public ResponseEntity<Void> deleteItemById(@PathVariable("id") Long id) {
        itemService.deleteItemById(id);
        return ResponseEntity.noContent().build();
    }

}
