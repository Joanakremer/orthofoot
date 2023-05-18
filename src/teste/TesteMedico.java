package teste;

import static org.junit.Assert.assertTrue;


import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import controle.CDaoMedico;


import modelo.MMedico;
@TestMethodOrder(OrderAnnotation.class)
class TesteMedico {
	@Test
	@Order(1)
	void inserirmedicoteste() {
		CDaoMedico dao = new CDaoMedico();
		MMedico mmedico = new MMedico();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		mmedico.setCrm(123456);
		mmedico.setnomeCompleto("Leonardo");
		mmedico.setdataNasc(LocalDate.parse("26/04/2004", formatter));
		mmedico.setSexo("Masculino");
		
		assertTrue(dao.inserir(mmedico));
	}
	@Test
	@Order(2)
	void alterarmedicoteste() {
		CDaoMedico dao = new CDaoMedico();
		MMedico mmedico = new MMedico();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		mmedico.setCrm(123456);
		mmedico.setnomeCompleto("Kaillane");
		mmedico.setdataNasc(LocalDate.parse("16/10/2004", formatter));
		mmedico.setSexo("Feminino");
		
		assertTrue(dao.update(mmedico));
	}
	
	@Test
	@Order(3)
	void excluirmedicoteste() {
		CDaoMedico dao = new CDaoMedico();
		MMedico mmedico = new MMedico();
		mmedico.setCrm(123456);
		
		assertTrue(dao.delete(mmedico));
	}

}
