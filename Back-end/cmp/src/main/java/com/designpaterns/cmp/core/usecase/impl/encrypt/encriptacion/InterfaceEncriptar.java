/*
 * Asignatura: Patrones de Diseño de Software
 * Patrón Estructural - > Bridge
 * Tipo de Clase: Interface
 * Interface común para todas las implementaciones de algoritmos de encriptamiento.
 */
package com.designpaterns.cmp.core.usecase.impl.encrypt.encriptacion;

/**
 *
 * @author Fabrizio Bolaño
 */
public interface InterfaceEncriptar {
	public String encryptar(String message, String password) throws Exception;

	public String encryptar(String message) throws Exception;


}