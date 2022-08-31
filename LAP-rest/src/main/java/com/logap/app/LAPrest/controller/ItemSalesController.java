package com.logap.app.LAPrest.controller;

import com.logap.app.LAPrest.controller.models.SalesModel;
import com.logap.app.LAPrest.controller.services.SalesService;
import com.logap.app.LAPrest.repository.SaleRepository;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
public class ItemSalesController {

    final SalesService salesService;

    public ItemSalesController(SalesService salesService) {
        this.salesService = salesService;
    }

    @Autowired
    private SaleRepository repository;

    @GetMapping(path = "/api/sales")
    public ResponseEntity<List<SalesModel>> getAllItems(){
        return ResponseEntity.status(HttpStatus.OK).body(salesService.findAll());
    }

    @GetMapping(path = "/api/sales/{code}")
    public ResponseEntity getConsult(@NotNull @PathVariable("code") Integer code){
        return repository.findById(code).map(record -> ResponseEntity.ok().body(record))
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping(path = "/api/sales/saveItem")
    public SalesModel saveItem(@RequestBody SalesModel item){
        return repository.save(item);
    }


}
