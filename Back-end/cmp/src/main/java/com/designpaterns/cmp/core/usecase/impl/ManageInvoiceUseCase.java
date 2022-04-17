package com.designpaterns.cmp.core.usecase.impl;

import com.designpaterns.cmp.infrastructure.InvoiceProvider;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class ManageInvoiceUseCase {

	private final InvoiceProvider invoiceProvider;

}
