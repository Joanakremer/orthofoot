package teste;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;

import controle.CDaoMedico;
import modelo.MMedico;

class TesteMedico {
	@Test
	@Order(1)
	void inserirmedicoteste() {
		CDaoMedico dao = new CDaoMedico();
		MMedico mmedico = new MMedico();
		mmedico.setCrm(123456);
		mmedico.setdataNasc(null);
		mmedico.setnomeCompleto("Leonardo");
		mmedico.setSexo("Masculino");
		assertTrue(dao.inserir(mmedico));
	}
	@Test
	@Order(2)
	void alterarmedicoteste() {
		CDaoMedico dao = new CDaoMedico();
		MMedico mmedico = new MMedico();
		assertTrue(dao.update(mmedico));
	}
	

}
