package mz.co.faktorize.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import mz.co.faktorize.dtos.InvoiceDto;
import mz.co.faktorize.models.Invoice;
import mz.co.faktorize.service.InvoiceService;

@RestController
public class InvoiceController {


    private final InvoiceService invoiceService;

    public InvoiceController(InvoiceService invoiceService) {
        this.invoiceService = invoiceService;
    }

    @GetMapping("/invoices/{id}")
    public ResponseEntity<Invoice> getInvoices(@PathVariable Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(invoiceService.findInvoiceById(id));
    }

    @PostMapping("/invoices")
    public ResponseEntity<Invoice> saveInvoice(InvoiceDto invoice) {
        return ResponseEntity.status(HttpStatus.CREATED).body(invoiceService.saveInvoice(invoice));
    }

}
