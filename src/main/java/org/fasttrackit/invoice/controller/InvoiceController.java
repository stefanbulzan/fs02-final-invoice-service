package org.fasttrackit.invoice.controller;

import org.fasttrackit.invoice.model.Invoice;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin("http://localhost:4200")
@RestController
@RequestMapping("invoices")
public class InvoiceController {
    private final List<Invoice> invoices = new ArrayList<>(List.of(
            new Invoice("laptop", 2500, "Maria", "Emag", true),
            new Invoice("Frigider", 3000, "Ioan", "Altex", false),
            new Invoice("Cartofi", 10, "Mihai", "Carrefour", false),
            new Invoice("monitor", 1800, "Darius", "Emag", true)
    ));

    @GetMapping
    List<Invoice> getAll() {
        return invoices;
    }

    @PostMapping
    Invoice add(@RequestBody Invoice invoice) {
        invoices.add(invoice.withSender("me"));
        return invoice;
    }
}
