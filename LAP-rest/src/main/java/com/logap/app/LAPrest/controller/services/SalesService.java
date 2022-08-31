package com.logap.app.LAPrest.controller.services;

import com.logap.app.LAPrest.controller.models.SalesModel;
import com.logap.app.LAPrest.repository.SaleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SalesService {

    final SaleRepository saleRepository;

    public SalesService(SaleRepository saleRepository){
        this.saleRepository = saleRepository;
    }

    public List<SalesModel> findAll(){
        return saleRepository.findAll();
    }

}
