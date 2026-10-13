package com.zepto.invoice.service;

import org.springframework.stereotype.Service;

import com.zepto.invoice.entity.InvoiceEntity;
import com.zepto.invoice.repository.InvoiceRepository;
import com.zepto.invoice.request.InvoiceRequest;
import com.zepto.invoice.response.InvoiceResponse;

@Service
public class InvoiceService {

	private InvoiceRepository invoiceRepository;

	public InvoiceService(InvoiceRepository invoiceRepository) {
		super();
		this.invoiceRepository = invoiceRepository;
	}

	public InvoiceResponse createInvoice(InvoiceRequest invoiceRequest) {

		InvoiceEntity entity = new InvoiceEntity();

		entity.setCustomerName(invoiceRequest.getCustomerName());
		entity.setGst(invoiceRequest.getGst());
		entity.setStatus("PAID");
		entity.setInvId("INV1234");

		entity = invoiceRepository.save(entity);

		InvoiceResponse invoiceResponse = new InvoiceResponse();

		if (entity.getId() > 0) {
			invoiceResponse.setCustomerName(entity.getCustomerName());
			invoiceResponse.setGst(entity.getGst());
			invoiceResponse.setStatus(entity.getStatus());
			invoiceResponse.setInvId(entity.getInvId());
			invoiceResponse.setId(entity.getId());
		}

		return invoiceResponse;

	}

}
