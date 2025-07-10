package mz.co.faktorize.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import mz.co.faktorize.dtos.InvoiceDto;
import mz.co.faktorize.models.Invoice;
import mz.co.faktorize.models.Supplier;
import mz.co.faktorize.repository.InvoiceRepository;
import mz.co.faktorize.repository.SupplierRepository;

@Service
public class InvoiceService {

    private final InvoiceRepository invoiceRepository;
    private final SupplierRepository supplierRepository;

    public InvoiceService(InvoiceRepository invoiceRepository, SupplierRepository supplierRepository) {
        this.invoiceRepository = invoiceRepository;
        this.supplierRepository = supplierRepository;
    }

    public Invoice saveInvoice(InvoiceDto invoiceDto) {
        if (invoiceDto.getSupplierId() == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Supplier ID cannot be null.");
        }
        Invoice invoice = InvoiceDto.convertToEntity(invoiceDto);
        supplierRepository.findById(invoiceDto.getSupplierId())
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found."));
        return invoiceRepository.save(invoice);
    }

    public List<InvoiceDto> findAllInvoices() {
        return invoiceRepository.findAll()
            .stream()
            .map(InvoiceDto::convertToDto)
            .collect(Collectors.toList());
    }

    public Invoice findInvoiceById(Long id) {
        return invoiceRepository.findById(id)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice not found."));
    }

    public List<Invoice> findInvoicesBySupplierId(Long supplierId) {
        Supplier supplier = supplierRepository.findById(supplierId)
            .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Supplier not found"));
        if (supplier != null) {
            return invoiceRepository.findInvoicesBySupplierId(supplierId)
                .stream()
                .map(a -> new Invoice())
                .collect(Collectors.toList());
        } else {
            return null;
        }
    }

    public void deleteInvoiceById(Long id) {
        if (!invoiceRepository.existsById(id)) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Invoice not found.");
        }
        invoiceRepository.deleteById(id);
    }
}
