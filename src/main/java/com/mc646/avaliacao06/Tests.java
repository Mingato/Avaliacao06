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
		
		Assert.assertEquals(0, fileOpeneds.getCountFile());
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
	
	/**
	 * Se a lista alcança seu limite (normalmente de 10 a 15 itens na lista), 
	 * o item mais antigo é removido quando um novo item é adicionado.
	 * **/
	@Test
	@Order(3)
	public void Test_Tdd_04() {
		FileOpeneds.File oldestFile = null;
		
		fileOpeneds.openFile("files/File01.txt");
		fileOpeneds.openFile("files/File02.txt");
		fileOpeneds.openFile("files/File03.txt");
		fileOpeneds.openFile("files/File04.txt");
		fileOpeneds.openFile("files/File05.txt");
		fileOpeneds.openFile("files/File06.txt");
		fileOpeneds.openFile("files/File07.txt");
		fileOpeneds.openFile("files/File08.txt");
		fileOpeneds.openFile("files/File09.txt");
		fileOpeneds.openFile("files/File10.txt");
		oldestFile = fileOpeneds.openFile("files/File11.txt");
		
		fileOpeneds.deleteFile("files/File01.txt");
		
		Assert.assertEquals(10, fileOpeneds.getCountFile());
		
		Assert.assertEquals("files/File01.txt", oldestFile.getName());
	}
}
