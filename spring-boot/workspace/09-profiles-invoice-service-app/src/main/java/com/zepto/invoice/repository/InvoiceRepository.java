package com.zepto.invoice.repository;

import org.springframework.data.repository.CrudRepository;

import com.zepto.invoice.entity.InvoiceEntity;

public interface InvoiceRepository extends CrudRepository<InvoiceEntity, Integer> {

}
