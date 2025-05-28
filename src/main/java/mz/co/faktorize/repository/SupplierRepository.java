package mz.co.faktorize.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import mz.co.faktorize.models.Supplier;

public interface SupplierRepository extends JpaRepository<Supplier, Long>{
    Optional<Supplier> findSupplierById(Long id);
    Optional<Supplier> findSupplierByName(String name);
}
