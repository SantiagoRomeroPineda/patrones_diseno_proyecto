package com.designpaterns.cmp.infrastructure;

import java.util.Optional;

import com.designpaterns.cmp.infrastructure.database.model.invoice.Invoice;
import com.designpaterns.cmp.infrastructure.database.model.invoice.InvoiceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceProvider {

	private final InvoiceRepository invoiceRepository;

	public Optional<Invoice> findById(final String id){
			return invoiceRepository.findById(id);
	}

	public void save(Invoice invoice){
		invoiceRepository.save(invoice);
	}

}
