package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;

import controle.CDao;
import modelo.MPaciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


public class TelaPaciente extends JFrame {

	private JPanel contentPane;
	private JTable tablePacientes;
	private MPaciente pacienteSelecionado;
	private ArrayList<MPaciente> listaPaciente;
	private CDao dao;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JLabel lblNewLabel;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 993, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 11, 957, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("PACIENTE");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 11, 304, 31);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 84, 957, 53);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 957, 294);
		contentPane.add(scrollPane);
		
		
		dao = CDao.getInstancia();
		listaPaciente = dao.listarPaciente();
		tablePacientes = new JTable();

		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tablePacientes.getSelectedRow();
				pacienteSelecionado = listaPaciente.get(posicaoPessoa);
				pacienteSelecionado.getProntuario();
				pacienteSelecionado.getnomeCompleto();
				pacienteSelecionado.getdataNasc();
				pacienteSelecionado.getCpf();
				pacienteSelecionado.getnCarteira();
				pacienteSelecionado.getContato();
				pacienteSelecionado.getConvenio();
				pacienteSelecionado.getSexo();
			}
		});
		scrollPane.setViewportView(tablePacientes);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoPrincipal frame = new VisaoPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(870, 459, 97, 31);
		contentPane.add(btnNewButton_3);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente frame = null;
				try {
					frame = new TelaCadastroPaciente();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(10, 11, 175, 31);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarPaciente frame = null;
				frame = new TelaAtualizarPaciente();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(699, 11, 119, 31);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pacienteSelecionado != null) {
					listaPaciente.remove(pacienteSelecionado);
					
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(828, 11, 119, 31);
		panel.add(btnNewButton_2);
		atualizar();

	}
	
	

	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Prontuario", "Nome",
				"Data Nascimento", "CPF", "Sexo", "Contato", "Convenio", "N° Carteira" });

		tablePacientes.setModel(modelo);
		
		if (listaPaciente.size() > 0 && listaPaciente != null) {
			for (MPaciente paciente : listaPaciente) {
				if(paciente == null) {
					System.out.println("paciente está vazio");
				}else {
					modelo.addRow(new Object[] { paciente.getProntuario(), paciente.getnomeCompleto(),
							paciente.getdataNasc(), paciente.getCpf(), paciente.getnCarteira(), paciente.getContato(),
							paciente.getConvenio(), paciente.getSexo() });
				}
			}
		}
	}
}
