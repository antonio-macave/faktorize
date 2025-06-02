package mz.co.faktorize.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;
import java.util.Optional;

import mz.co.faktorize.dtos.ItemDto;
import mz.co.faktorize.models.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
    List<Item> findItemsByInvoiceId(Long invoiceId);
    Optional<Item> findItemById(Long itemId);
    void deleteItemById(Long id);
    void deleteItemsByInvoiceId(Long invoiceId);
}
