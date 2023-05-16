package visao;

import java.util.Date;

import javax.swing.JOptionPane;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import controle.CDao;
import controle.CDaoAgenda;
import controle.CDaoMedico;
import modelo.MAgenda;
import modelo.MMedico;
import modelo.MPaciente;

public class testeAgenda {

	public static void main(String[] args) {
		CDaoAgenda dao = new CDaoAgenda();
			
		CDaoMedico daoMedico = new CDaoMedico();
		CDao daoPaciente = new CDao();
			ArrayList<MMedico> listMedico = daoMedico.listarMedico();
			MMedico medico = listMedico.get(0);
			
			ArrayList<MPaciente> listPaciente = daoPaciente.listarPaciente();
			MPaciente paciente = listPaciente.get(0);
			
			MAgenda agenda = new MAgenda();
			String data = "01/05/2022";
			String hora = "05:00";
			
			agenda.setMedico(medico);
			agenda.setPaciente(paciente);
			agenda.setTitulo(paciente.getConvenio());
			SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date dataFormatada = formater.parse(data);
				agenda.setData(new java.sql.Date(dataFormatada.getTime()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "formato de data invalida");
				e.printStackTrace();
			}
			
			SimpleDateFormat formaterHora = new SimpleDateFormat("hh:mm");
			try {
				Date horaFormatada = formaterHora.parse(hora);
				agenda.setHora(new java.sql.Time(horaFormatada.getTime()));
			} catch (ParseException e) {
				JOptionPane.showMessageDialog(null, "formato de hora invalido");
				e.printStackTrace();
			}
			dao.inserir(agenda);
			

	}

}
