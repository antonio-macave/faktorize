package mz.co.faktorize.service;

import org.springframework.stereotype.Service;

import mz.co.faktorize.repository.ItemRepository;

@Service
public class ItemService {
    
    private final ItemRepository itemRepository;

    public ItemService(ItemRepository itemRepository) {
        this.itemRepository = itemRepository;
    }

}
