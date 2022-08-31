package com.logap.app.LAPrest.repository;

import com.logap.app.LAPrest.controller.models.SalesModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SaleRepository extends JpaRepository<SalesModel, Integer> {



}
