package com.mc646.avaliacao06;

import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.Order;


public class Tests {

	private FileOpeneds fileOpeneds = new FileOpeneds();
	
	/**
	 * Quando o programa está executando pela primeira vez, essa lista está vazia;
	 * **/
	@Test
	@Order(0)
	public void Test_Tdd_01() {
		
		Assert.assertEquals(0, fileOpeneds.getFileCount());
	}
	
	/**
	 * Quando um arquivo é aberto, ele é adicionado à lista de arquivos recentes;
	 * **/
	@Test
	@Order(1)
	public void Test_Tdd_02() {
		fileOpeneds.openFile("files/File01.txt");
		
		Assert.assertEquals(1, fileOpeneds.getCountFile());
		
		Assert.assertEquals("files/File01.txt", fileOpeneds.getFiles().get(0).getName());
	}
	
	/**
	 * Se um arquivo aberto já está na lista, este é levado ao topo da lista, 
	 * sem conter itens duplicados na lista
	 * **/
	@Test
	@Order(2)
	public void Test_Tdd_03() {
		fileOpeneds.openFile("files/File02.txt");
		
		Assert.assertEquals("files/File02.txt", fileOpeneds.getTop().getName());
		
		Assert.assertEquals(1, fileOpeneds.getCountFileByName("files/File02.txt"));
		
		fileOpeneds.openFile("files/File01.txt");
		
		Assert.assertEquals("files/File01.txt", fileOpeneds.getTop().getName());
		
		Assert.assertEquals(1, fileOpeneds.getCountFileByName("files/File01.txt"));
	}
}
