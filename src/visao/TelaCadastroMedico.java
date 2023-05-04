package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDao;
import controle.CDaoMedico;
import modelo.MMedico;
import modelo.MPaciente;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCrm;
	private JTextField txtNomeCompleto;
	private JLabel lblNewLabel_3;
	private JTable tableMedico;
	private CDaoMedico daoMedico;
	private JComboBox<String> cbDia,cbMes,cbAno;
	private ArrayList<MMedico> listarMedico;
	private MMedico medicoSelecionado;
	private JTable table;
	private JComboBox comboSexo;
	private String crm;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico frame = new TelaCadastroMedico();
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
	public TelaCadastroMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 670);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 507, 45);
		contentPane.add(panel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 507, 240);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAR MÉDICO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data Nascimento *");
		lblNewLabel_2.setBounds(262, 150, 224, 29);
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_3.add(lblNewLabel_2);
		
		cbAno = new JComboBox<>();
		int ano = LocalDate.now().getYear();
		for (int i = 0; i < 110; i++) {
			cbAno.addItem(String.valueOf(ano));
			ano--;
		}
		cbAno.setBounds(418, 182, 79, 29);
		panel_3.add(cbAno);
		
		cbDia = new JComboBox<>();
		int dia = 0;
		for (int i = 0; i < 31; i++) {
			cbDia.addItem(String.valueOf(dia));
			dia++;
		}
		cbDia.setBounds(262, 182, 68, 29);
		panel_3.add(cbDia);
		
		cbMes = new JComboBox<>();
		int mes = 0;
		for (int i = 0; i < 13; i++) {
			cbMes.addItem(String.valueOf(mes));
			mes++;
		}
		cbMes.setBounds(340, 182, 68, 28);
		panel_3.add(cbMes);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 374, 507, 190);
		contentPane.add(scrollPane);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo *");
		lblNomeCompleto.setBounds(10, 80, 487, 29);
		panel_3.add(lblNomeCompleto);
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNomeCompleto.setBounds(10, 110, 487, 29);
		panel_3.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CRM *");
		lblNewLabel.setBounds(10, 11, 265, 29);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtCrm = new JTextField();
		txtCrm.setBounds(10, 40, 487, 29);
		panel_3.add(txtCrm);
		txtCrm.setForeground(Color.BLACK);
		txtCrm.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCrm.setColumns(10);

		
		lblNewLabel_3 = new JLabel("Sexo *");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 150, 181, 29);
		panel_3.add(lblNewLabel_3);
		
		comboSexo = new JComboBox();
		comboSexo.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		comboSexo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboSexo.setBounds(10, 179, 181, 29);
		panel_3.add(comboSexo);
		
		daoMedico = CDaoMedico.getInstancia();
		
		tableMedico = new JTable();
		scrollPane.setViewportView(tableMedico);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 318, 507, 45);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.setBounds(10, 7, 160, 31);
		panel_1.add(btnCadastrar);
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MMedico newMedico = new MMedico();
				String crm = txtCrm.getText();
				if (crm == null || crm.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CRM está vazio");
				} else {
					newMedico.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNomeCompleto.getText();
				if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME COMPLETO está vazio");
				} else {
					newMedico.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();
				
				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				newMedico.setdataNasc(data);
			
				
				String sexo =String.valueOf(comboSexo.getSelectedItem().toString());
				newMedico.setSexo(sexo);
				
				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				boolean insert = tableMedico.inserir(newMedico);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
					atualizar();
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
			}
		});
		btnCadastrar.setBackground(Color.WHITE);
		btnCadastrar.setFocusPainted(false);
		btnCadastrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBounds(240, 7, 119, 31);
		panel_1.add(btnAtualizar);
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				crm = txtCrm.getText().replace("", "");
				if (crm == null || crm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					medicoSelecionado.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNomeCompleto.getText();
				if (nomeCompleto == null || nomeCompleto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					medicoSelecionado.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();

				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				medicoSelecionado.setdataNasc(data);
				
				String sexo =String.valueOf(comboSexo.getSelectedItem().toString());
					medicoSelecionado.setSexo(sexo);

				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				boolean update = tableMedico.update(medicoSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtCrm.setText(null);
					txtNomeCompleto.setText(null);
					
					
					dispose();
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.setBounds(378, 7, 119, 31);
		panel_1.add(btnDeletar);
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar.setBackground(Color.WHITE);
		btnDeletar.setFocusPainted(false);
		btnDeletar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setBounds(420, 585, 97, 31);
		contentPane.add(btnNewButton_3);

		
		atualizar();
		tableMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableMedico.getSelectedRow();
				medicoSelecionado = listarMedico.get(posicaoPessoa);
				txtNomeCompleto.setText(medicoSelecionado.getnomeCompleto());
				txtCrm.setText(String.valueOf(medicoSelecionado.getCrm()));
				cbDia.setSelectedIndex(medicoSelecionado.getdataNasc().getDayOfMonth());
				cbMes.setSelectedIndex(medicoSelecionado.getdataNasc().getMonthValue());
				cbAno.setSelectedItem(e);
			}
		});	
		
	}
	protected void limparCampos() {
		txtNomeCompleto.setText(null);
		txtCrm.setText(null);
		comboSexo.setSelectedItem(null);
	}

	public void atualizar() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] {"crm", "nomeCompleto", "dataNasc", "sexo"});
		listarMedico = daoMedico.listarMedico();

		if (listarMedico.size() > 0 && listarMedico != null) {
			for (MMedico medico : listarMedico) {
				modelo.addRow(new Object[] { medico.getCrm(), medico.getnomeCompleto(), medico.getdataNasc(),
						medico.getSexo()});
			}
		}

		tableMedico.setModel(modelo);
		
	}
}
