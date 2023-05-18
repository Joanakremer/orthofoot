package visao;

import java.awt.EventQueue;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDao;
import controle.CDaoAgenda;
import controle.CDaoMedico;
import modelo.MAgenda;
import modelo.MMedico;
import modelo.MPaciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

public class TelaAgenda extends JFrame {

	private JPanel contentPane;
	private JTable tableAgenda;
	private Integer idConsulta;
	private JFormattedTextField txtData;
	private JTextField txtHora;
	CDaoAgenda daoAgenda;
	private MAgenda agendaSelecionada;
	private ArrayList<MAgenda> listAgendas;
	private JComboBox cbMedico;
	private JComboBox cbPaciente;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAgenda frame = new TelaAgenda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaAgenda() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 730, 554);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 243, 694, 261);
		contentPane.add(scrollPane);
		
		tableAgenda = new JTable();// TODO fazer a seleção das rows
		atualizar();
		tableAgenda.addMouseListener(new MouseAdapter() {
			
			
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoAgenda = tableAgenda.getSelectedRow();
				agendaSelecionada = listAgendas.get(posicaoAgenda);
			}
			
		});
		scrollPane.setViewportView(tableAgenda);

		txtData = new JFormattedTextField();
		txtData.setBounds(156, 212, 105, 20);
		contentPane.add(txtData);
		txtData.setColumns(10);

		JLabel lblNewLabel = new JLabel("Insira a data da consulta:");
		lblNewLabel.setBounds(10, 215, 161, 14);
		contentPane.add(lblNewLabel);

		txtHora = new JTextField();
		txtHora.setColumns(10);
		txtHora.setBounds(542, 212, 105, 20);
		contentPane.add(txtHora);

		JLabel lblInsiraOHorario = new JLabel("Insira o horario da consulta:");
		lblInsiraOHorario.setBounds(378, 215, 161, 14);
		contentPane.add(lblInsiraOHorario);

		JButton btnCad = new JButton("Cadastrar");
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				daoAgenda = new CDaoAgenda();

				MMedico medico = (MMedico) cbMedico.getSelectedItem();
				MPaciente paciente = (MPaciente) cbPaciente.getSelectedItem();
				MAgenda agenda = new MAgenda();
				String data = txtData.getText();
				String hora = txtHora.getText();

				agenda.setMedico(medico);
				agenda.setPaciente(paciente);
				agenda.setTitulo(paciente.getConvenio());

				SimpleDateFormat formater = new SimpleDateFormat("dd/MM/yyyy");
				try {
					Date dataFormatada = formater.parse(data);
					agenda.setData(new java.sql.Date(dataFormatada.getTime()));
				} catch (ParseException f) {
					JOptionPane.showMessageDialog(null, "formato de data invalida");
					// return;
					f.printStackTrace();
				}

				SimpleDateFormat formaterHora = new SimpleDateFormat("hh:mm");
				try {
					Date horaFormatada = formaterHora.parse(hora);
					agenda.setHora(new java.sql.Time(horaFormatada.getTime()));
				} catch (ParseException e3) {
					JOptionPane.showMessageDialog(null, "formato de hora invalido");
					e3.printStackTrace();
				}
				daoAgenda.inserir(agenda);
				
			}
		});
		btnCad.setBounds(156, 135, 89, 23);
		contentPane.add(btnCad);

		cbPaciente = new JComboBox();

		cbPaciente.setBounds(156, 69, 105, 22);
		daoAgenda = CDaoAgenda.getInstancia();
		CDao daoPaciente = new CDao();
		ArrayList<MPaciente> listPaciente = daoPaciente.listarPaciente();
		for (MPaciente mPaciente : listPaciente) {
			cbPaciente.addItem(mPaciente);
		}
		contentPane.add(cbPaciente);

		JLabel lblNewLabel_1 = new JLabel("Paciente");
		lblNewLabel_1.setBounds(125, 44, 46, 14);
		contentPane.add(lblNewLabel_1);

		cbMedico = new JComboBox();
		CDaoMedico daoMedico = new CDaoMedico();
		ArrayList<MMedico> listMedico = daoMedico.listarMedico();
		for (MMedico mMedico : listMedico) {
			cbMedico.addItem(mMedico);
		}
		cbMedico.setBounds(542, 69, 105, 22);
		contentPane.add(cbMedico);

		JLabel lblNewLabel_1_1 = new JLabel("Medico");
		lblNewLabel_1_1.setBounds(505, 44, 46, 14);
		contentPane.add(lblNewLabel_1_1);

		JButton btnDel = new JButton("Deletar");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDaoAgenda a = new CDaoAgenda();
				if (agendaSelecionada != null) {
					a.delete(agendaSelecionada);
					listAgendas.remove(agendaSelecionada);
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
				}
				atualizar();
			}
		});
		btnDel.setBounds(558, 135, 89, 23);
		contentPane.add(btnDel);
	}

	public void atualizar() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "idConsulta", "dataCons",
				"hora", "titulo", "nCartao", "prontuario", "crm", "nomeCompleto", });
		daoAgenda = new CDaoAgenda();
		listAgendas = daoAgenda.listarAgenda();
		
		if (listAgendas.size() > 0 && listAgendas != null) {
			for (MAgenda agenda : listAgendas) {
				modelo.addRow(new Object[] { agenda.getIdConsulta(), agenda.getData(), agenda.getHora(),
						agenda.getPaciente().getConvenio(), agenda.getPaciente().getnCarteira(), agenda.getPaciente().getProntuario(),
						agenda.getMedico().getCrm(), agenda.getPaciente().getNomeCompleto(),
						agenda.getPaciente().getContato() });
			}
		}
		tableAgenda.setModel(modelo);
	
	}
}
