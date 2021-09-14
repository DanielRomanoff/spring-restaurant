package ru.restaurant.controllers;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;
import ru.restaurant.db.Supplier;
import ru.restaurant.services.SupplierService;

import javax.validation.Valid;
import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@Slf4j
@RequiredArgsConstructor
@RestController
@RequestMapping("/api/suppliers")
public class SupplierController {

    private final SupplierService supplierService;

    @GetMapping(produces = APPLICATION_JSON_VALUE)
    public List<Supplier> suppliers() {
        log.info("Get suppliers");
        return supplierService.getSuppliers();
    }

    @PostMapping(produces = APPLICATION_JSON_VALUE)
    public Supplier createSupplier(@Valid @RequestBody Supplier supplier) {
        log.info("Create supplier - {}", supplier);
        return supplierService.createSupplier(supplier);
    }
}
