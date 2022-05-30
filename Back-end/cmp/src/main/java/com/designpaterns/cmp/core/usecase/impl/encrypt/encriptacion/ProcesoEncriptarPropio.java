package com.designpaterns.cmp.core.usecase.impl.encrypt.encriptacion;

import java.util.Base64;

public class ProcesoEncriptarPropio implements InterfaceEncriptar {

	@Override
	public String encryptar(final String message, final String password) throws Exception {

		return null;
	}

	@Override
	public String encryptar(final String message) throws Exception {

		String b64encoded = Base64.getEncoder().encodeToString(message.getBytes());

		// Reverse the string
		String reverse = new StringBuffer(b64encoded).reverse().toString();

		StringBuilder tmp = new StringBuilder();
		final int OFFSET = 4;
		for (int i = 0; i < reverse.length(); i++) {
			tmp.append((char)(reverse.charAt(i) + OFFSET));
		}
		return tmp.toString();
	}
}
