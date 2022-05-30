/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Java
 * Clase que representa al bridge o puente..
 * La clase implementa InterfaceMensajeEncriptacion y delega la responsabilidad al método de encriptamiento asignado durante la creación del objeto.
 */
package com.designpaterns.cmp.core.usecase.impl.encrypt.implementacion;

import com.designpaterns.cmp.core.usecase.impl.encrypt.encriptacion.InterfaceEncriptar;

/**
 *
 * @author Fabrizio Bolaño
 */
public class PuenteMensajeEncriptacion implements InterfaceMensajeEncriptacion {
	private InterfaceEncriptar ProcesoEncryptacion;

	public PuenteMensajeEncriptacion(InterfaceEncriptar ProcesoEncryptacion){
		this.ProcesoEncryptacion = ProcesoEncryptacion;
	}

	@Override
	public String EncryptarMensaje(String message, String password) throws Exception {
		return ProcesoEncryptacion.encryptar(message, password);
	}

	@Override
	public String EncryptarMensaje(String message) throws Exception {
		return ProcesoEncryptacion.encryptar(message);
	}

}