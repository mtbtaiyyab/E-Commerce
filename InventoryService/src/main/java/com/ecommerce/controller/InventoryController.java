package com.ecommerce.controller;

import com.ecommerce.service.InventoryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/inventory")
@RequiredArgsConstructor
public class InventoryController {

    private final InventoryService inventoryService;
    @GetMapping("/{sku_code}")
    @ResponseStatus(HttpStatus.OK)
    public boolean inStock(@PathVariable("sku_code") String skuCode){
        return inventoryService.isInStock(skuCode);
    }
}
