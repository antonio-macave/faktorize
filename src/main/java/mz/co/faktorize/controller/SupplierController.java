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

import jakarta.websocket.server.PathParam;
import mz.co.faktorize.dtos.SupplierDto;
import mz.co.faktorize.service.SupplierService;

@RestController
public class SupplierController {

    private SupplierService supplierService;

    public SupplierController(SupplierService supplierService) {
        this.supplierService = supplierService;
    }

    @PostMapping("/suppliers")
    public ResponseEntity<SupplierDto> createSupplier(@RequestBody SupplierDto body) {
        return ResponseEntity.status(HttpStatus.CREATED).body(supplierService.saveSupplier(body));
    }

    @PutMapping("/suppliers/{id}")
    public ResponseEntity<SupplierDto> updateSupplier(@PathVariable("id") Long id, @RequestBody SupplierDto body) {
        return ResponseEntity.ok(supplierService.updateSupplier(id, body));
    }

    @GetMapping("/suppliers/{id}")
    public ResponseEntity<SupplierDto> getSupplierById(@PathParam("id") Long id) {
        return ResponseEntity.ok(supplierService.findSupplierById(id));
    }

    @GetMapping("/suppliers")
    public ResponseEntity<List<SupplierDto>> getAllSuppliers() {
        return ResponseEntity.ok(supplierService.findAllSuppliers());
    }

    @DeleteMapping("/suppliers/{id}")
    public ResponseEntity<Void> deleteSupplierById(@PathParam("id") Long id) {
        supplierService.deleteSupplierById(id);
        return ResponseEntity.noContent().build();
    }

}
