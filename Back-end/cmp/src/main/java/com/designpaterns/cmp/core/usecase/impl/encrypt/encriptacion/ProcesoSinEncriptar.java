/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Java
 * Clase que hereda de InterfaceEncriptar y regresa el mensaje sin ningún proceso de encriptación.
 */
package com.designpaterns.cmp.core.usecase.impl.encrypt.encriptacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public class ProcesoSinEncriptar implements InterfaceEncriptar {

	@Override
	public String encryptar(String message, String password) throws Exception {
		return message;
	}

	@Override public String encryptar(final String message) throws Exception {

		return null;
	}

}