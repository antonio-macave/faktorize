package mz.co.faktorize.service;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

}