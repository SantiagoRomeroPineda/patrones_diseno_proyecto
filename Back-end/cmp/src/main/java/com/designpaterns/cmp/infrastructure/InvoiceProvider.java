package com.designpaterns.cmp.infrastructure;

import com.designpaterns.cmp.infrastructure.database.model.invoice.InvoiceRepository;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class InvoiceProvider {

	private final InvoiceRepository invoiceRepository;

}
