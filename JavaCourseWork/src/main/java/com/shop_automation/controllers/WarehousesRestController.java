package com.shop_automation.controllers;

import com.shop_automation.dto.WarehouseRequest;
import com.shop_automation.models.Warehouses;
import com.shop_automation.services.WarehousesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("warehouses")
public class WarehousesRestController {

    private final WarehousesService warehousesService;

    @Autowired
    public WarehousesRestController(WarehousesService warehousesService) {
        this.warehousesService = warehousesService;
    }

    @GetMapping("get-all")
    public List<Warehouses> getAllWarehouses() {
        return warehousesService.getWarehouses();
    }

    @GetMapping("get-id/{id}")
    public Warehouses findById(@PathVariable long id) {
        return warehousesService.getWarehouseById(id);
    }

    @PostMapping("add-through-http")
    public String registerNewWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        return warehousesService.saveWarehouse(warehouseRequest);
    }

    @PutMapping("replenishment")
    public String replenishmentOfWarehouse(@RequestBody WarehouseRequest warehouseRequest) {
        return warehousesService.addGoods(warehouseRequest);
    }

    @DeleteMapping("delete-name/{name}")
    public void deleteAllSalesByName(@PathVariable String name) {
        warehousesService.deleteAllSalesByName(name);
    }
}