package com.mc646.avaliacao06;

import org.junit.Test;
import org.junit.jupiter.api.Order;

import junit.framework.Assert;

public class Tests {

	private FileOpeneds fileOpeneds = new FileOpeneds();
	
	/**
	 * Quando o programa está executando pela primeira vez, essa lista está vazia;
	 * **/
	@Test
	@Order(0)
	public void Test_Tdd_01() {
		
		Assert.assertEquals(0, fileOpeneds.getFiles().size());
	}
}
