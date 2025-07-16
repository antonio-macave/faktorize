package mz.co.faktorize.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import mz.co.faktorize.models.Invoice;

public interface InvoiceRepository extends JpaRepository<Invoice, Long> {
    Optional<Invoice> findInvoiceById(Long id);
    Optional<Invoice> findInvoiceByNumber(String name);
    Optional<List<Invoice>> findInvoicesBySupplierId(Long supplierId);
}
