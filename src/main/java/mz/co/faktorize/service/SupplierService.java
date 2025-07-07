package mz.co.faktorize.service;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mz.co.faktorize.dtos.InvoiceDto;
import mz.co.faktorize.dtos.SupplierDto;
import mz.co.faktorize.models.Supplier;
import mz.co.faktorize.repository.SupplierRepository;

@Service
public class SupplierService {

    private final SupplierRepository supplierRepository;

    public SupplierService(SupplierRepository supplierRepository) {
        this.supplierRepository = supplierRepository;
    }

    public SupplierDto saveSupplier(SupplierDto supplierDto) {
        if (supplierDto.getName() == null || supplierDto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supplier name cannot be empty.");
        }
        Supplier supplier = SupplierDto.convertToEntity(supplierDto);
        supplierRepository.save(supplier);
        return SupplierDto.convertToDto(supplier);
    }

    public List<SupplierDto> findAllSuppliers() {
        return supplierRepository.findAll().stream()
            .map(SupplierDto::convertToDto)
            .toList();
    }

    public SupplierDto findSupplierById(Long id) {
        Supplier supplier = supplierRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found."));
        return SupplierDto.convertToDto(supplier);
    }

    public void deleteSupplierById(Long id) {
        if (!supplierRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found.");
        }
        supplierRepository.deleteById(id);
    }

    public void updateSupplierDto(Long supplierId, SupplierDto updatedSupplierDto) {
        Supplier existingSupplier = supplierRepository.findById(supplierId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found."));

        if (updatedSupplierDto.getName() == null || updatedSupplierDto.getName().isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supplier name cannot be empty.");
        }

        existingSupplier.setName(updatedSupplierDto.getName());
        existingSupplier.setAddress(updatedSupplierDto.getAdress());
        existingSupplier.setCity(updatedSupplierDto.getCity());
        existingSupplier.setCountry(updatedSupplierDto.getCountry());
        existingSupplier.setVatNumber(updatedSupplierDto.getVatNumber());

        if (updatedSupplierDto.getInvoices() != null) {
            existingSupplier.setInvoices(
                updatedSupplierDto.getInvoices().stream()
                    .map(InvoiceDto::convertToEntity)
                    .toList()
            );
        }

        supplierRepository.save(existingSupplier);
    }

}