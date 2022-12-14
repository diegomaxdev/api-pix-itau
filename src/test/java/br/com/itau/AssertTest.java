package br.com.itau;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

import java.time.LocalDateTime;

import org.junit.Assert;
import org.junit.jupiter.api.Test;

import br.com.itau.application.core.domain.Conta;

public class AssertTest {

	@Test
	public void teste() {
	
		//SEMPRE VALOR ESPERADO , VALOR ATUAL
		assertTrue(true);
		assertTrue(!false);
				
		assertFalse(false);
		assertFalse(!true);
		
		
		assertEquals(2,2);
		//Precisa de uma margem de erro - Sempre para numeros flutuantes
		assertEquals(0.51,0.51, 0.01);
		
		//Não permite classe wapper com tipo primitivo
		Integer i = 10;
		int ii = 10;
		assertEquals(i.intValue(),ii);
		
		//String
		assertEquals("bola", "bola");
		assertTrue("bola".equalsIgnoreCase("Bola"));
		assertTrue("bola".startsWith("bo"));
		
		LocalDateTime data1 = LocalDateTime.now();
		LocalDateTime data2 = LocalDateTime.now();
		assertEquals(data1, data2);
		
		//PARA GARANTIR TEMOS QUE USAR O EQUAL DA CLASSE
		Conta conta1 = new Conta();
		Conta conta2 = null;
		var conta3 = conta1; 
		//Diferentes
		assertNotEquals(conta1,conta2);
		
		//Mesma instância
		assertSame(conta3,conta1);
		//Assert.assertSame("Erro de Comparação",conta2,conta1);
		assertNotSame("Erro de Comparação",conta2,conta1);
		
		assertTrue(conta2 == null);
		assertNull(conta2);
		assertNotNull(conta1);
		
		//VERIFIQUE QUE
		//Assert.assertThat(0.51,0.51, 0.01);
		
		
		
	}
}
