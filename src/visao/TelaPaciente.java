package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.NumberFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import visaoCad.TelaCadastroPaciente;

import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;
import javax.swing.text.NumberFormatter;

import controle.CDao;
import modelo.MPaciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import java.awt.SystemColor;


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
	private JFormattedTextField txtProntuario;
	private JFormattedTextField txtCarteira;
	private JFormattedTextField txtContato;
	private JFormattedTextField txtCpf;
	private JTextField txtConvenio;
	private JTextField txtNome;
	
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
		setBounds(100, 100, 1010, 850);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setBounds(10, 75, 507, 293);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCpf.setBounds(304, 11, 182, 29);
		panel_3.add(lblCpf);
		
		JLabel lblNewLabel_1 = new JLabel("Prontuario *");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 265, 29);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNomeCompleto = new JLabel("Nome completo *");
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNomeCompleto.setBounds(10, 80, 127, 29);
		panel_3.add(lblNomeCompleto);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo *");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 150, 181, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(10, 218, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);
		
		JLabel lblDataDeNascimento = new JLabel("Data Nascimento *");
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblDataDeNascimento.setBounds(262, 150, 224, 29);
		panel_3.add(lblDataDeNascimento);
		
		try {
			txtProntuario = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtProntuario.setForeground(Color.BLACK);
		txtProntuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtProntuario.setColumns(10);
		txtProntuario.setBounds(10, 37, 265, 29);
		panel_3.add(txtProntuario);
		
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCpf.setColumns(10);
		txtCpf.setBounds(304, 36, 193, 29);
		panel_3.add(txtCpf);
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNome.setColumns(10);
		txtNome.setBounds(10, 107, 487, 29);
		panel_3.add(txtNome);
		
		JComboBox sexoBox = new JComboBox();
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		sexoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		sexoBox.setBounds(10, 179, 181, 29);
		panel_3.add(sexoBox);
		
		JComboBox<String> cbDia = new JComboBox<String>();
		cbDia.setBounds(262, 179, 68, 29);
		panel_3.add(cbDia);
		
		JComboBox<String> cbMes = new JComboBox<String>();
		cbMes.setBounds(340, 179, 68, 28);
		panel_3.add(cbMes);
		
		JComboBox<String> cbAno = new JComboBox<String>();
		cbAno.setBounds(418, 179, 79, 29);
		panel_3.add(cbAno);
		
		try {
			txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtContato.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtContato.setColumns(10);
		txtContato.setBounds(10, 242, 487, 29);
		panel_3.add(txtContato);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 11, 974, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel = new JLabel("PACIENTE");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 11, 304, 31);
		panel_1.add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 379, 974, 53);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 443, 974, 307);
		contentPane.add(scrollPane);
		
		
		dao = CDao.getInstancia();
		listaPaciente = dao.listarPaciente();
		tablePacientes = new JTable();

		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tablePacientes.getSelectedRow();
				pacienteSelecionado = listaPaciente.get(posicaoPessoa);
				txtProntuario.setText(String.valueOf(pacienteSelecionado.getProntuario()));
				txtCpf.setText(String.valueOf(pacienteSelecionado.getCpf()));
				txtNome.setText(pacienteSelecionado.getnomeCompleto());
				txtContato.setText(String.valueOf(pacienteSelecionado.getContato()));
				txtConvenio.setText(pacienteSelecionado.getConvenio());
				txtCarteira.setText(String.valueOf(pacienteSelecionado.getnCarteira()));
				cbDia.setSelectedIndex(pacienteSelecionado.getdataNasc().getDayOfMonth());
				cbMes.setSelectedIndex(pacienteSelecionado.getdataNasc().getMonthValue());
				cbAno.setSelectedItem(pacienteSelecionado.getdataNasc().getYear()+"");
				sexoBox.setSelectedItem(pacienteSelecionado.getSexo());
				if(pacienteSelecionado != null) {
					txtProntuario.disable();
				}
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
		btnNewButton_3.setBounds(887, 769, 97, 31);
		contentPane.add(btnNewButton_3);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroPaciente frame = null;
				frame = new TelaCadastroPaciente();

				MPaciente newPaciente = new MPaciente();
				String prontuario = txtProntuario.getText().replace("", "");
				if (prontuario == null || prontuario.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					newPaciente.setProntuario(Integer.valueOf(prontuario));
				}
				String nome = txtNome.getText();
				if (nome == null || nome.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					newPaciente.setnomeCompleto(nome);
				}

				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();

				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				newPaciente.setDataNasc(data);
	
				String cpf = txtCpf.getText().replace(".", "").replace("-", "");
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					newPaciente.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText().trim();
				if (carteira.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {//TODO erro de string vazia da carteira
					newPaciente.setnCarteira(Integer.valueOf(carteira));
				}
				String contato = txtContato.getText().replace("(", "").replace(")", "").replace("+", "").replace("-",
						"");
				if (contato == null || contato.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONTATO está vazio");
				} else {
					newPaciente.setContato(contato);
				}
				String convenio = txtConvenio.getText();
				if (convenio == null || convenio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONVENIO está vazio");
				} else {
					newPaciente.setConvenio(convenio);
				}
				String sexo = sexoBox.getSelectedItem().toString();
				newPaciente.setSexo(sexo);

				CDao tablePacientes = CDao.getInstancia();
				boolean insert = tablePacientes.inserir(newPaciente);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					sexoBox.setSelectedItem("Masculino");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				dispose();
				TelaPaciente frame1 = new TelaPaciente();
				frame1.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(10, 11, 175, 31);
		panel.add(btnNewButton);
		
		if(this.pacienteSelecionado != null) {
			txtProntuario.setText(String.valueOf(this.pacienteSelecionado.getProntuario()));
			txtNome.setText(this.pacienteSelecionado.getnomeCompleto());
			txtCpf.setText(String.valueOf(this.pacienteSelecionado.getCpf()));
			cbDia.setSelectedItem(this.pacienteSelecionado.getdataNasc());
			txtCarteira.setText(String.valueOf(this.pacienteSelecionado.getnCarteira()));
			txtContato.setText(this.pacienteSelecionado.getContato());
			txtConvenio.setText(this.pacienteSelecionado.getConvenio());
			sexoBox.setSelectedItem(this.pacienteSelecionado.getSexo());
		}
		
		btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String prontuario = txtProntuario.getText().replace("", "");
				if (prontuario == null || prontuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					pacienteSelecionado.setProntuario(Integer.valueOf(prontuario));
				}
				String nome = txtNome.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					pacienteSelecionado.setnomeCompleto(nome);
				}
				String cpf = txtCpf.getText().replace(".", "").replace("-", "");
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					pacienteSelecionado.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText();
				if (carteira == null || carteira.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {
					pacienteSelecionado.setnCarteira(Integer.valueOf(carteira));
				}
				String contato = txtContato.getText().replace("(", "").replace(")", "").replace("+", "").replace("-", "");
				if (contato == null || contato.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONTATO está vazio");
				} else {
					pacienteSelecionado.setContato(contato);
				}
				String convenio = txtConvenio.getText();
				if (convenio == null || convenio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONVENIO está vazio");
				} else {
					pacienteSelecionado.setConvenio(convenio);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();
				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				String sexo = sexoBox.getSelectedItem().toString();
					pacienteSelecionado.setSexo(sexo);

				CDao tablePacientes = CDao.getInstancia();
				boolean update = tablePacientes.update(pacienteSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtCpf.setText(null);
					cbDia.setSelectedItem(null);
					cbMes.setSelectedItem(null);
					cbAno.setSelectedItem(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					sexoBox.setSelectedItem("Masculino");
					
					dispose();
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(716, 11, 119, 31);
		panel.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			CDao c = new CDao();
			public void actionPerformed(ActionEvent e) {
				c.delete(pacienteSelecionado);
				listaPaciente.remove(pacienteSelecionado);
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
		btnNewButton_2.setBounds(845, 11, 119, 31);
		panel.add(btnNewButton_2);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(220, 220, 220));
		panel_1_1.setLayout(null);
		panel_1_1.setBounds(527, 75, 457, 168);
		contentPane.add(panel_1_1);
		
		try {
			NumberFormat format = NumberFormat.getInstance();
			format.setGroupingUsed(false);//Remove comma from number greater than 4 digit
			NumberFormatter sleepFormatter = new NumberFormatter(format);
			sleepFormatter.setValueClass(Integer.class);
			sleepFormatter.setMinimum(0);
			sleepFormatter.setMaximum(3600);
			sleepFormatter.setAllowsInvalid(false);

			sleepFormatter.setCommitsOnValidEdit(true);
			
			txtCarteira = new JFormattedTextField(sleepFormatter);
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		txtCarteira.setBounds(10, 115, 437, 29);
		panel_1_1.add(txtCarteira);
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCarteira.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtConvenio.setColumns(10);
		txtConvenio.setBounds(10, 41, 437, 29);
		panel_1_1.add(txtConvenio);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_2.setBounds(10, 81, 315, 29);
		panel_1_1.add(lblNewLabel_2_1_2_2);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 11, 315, 29);
		panel_1_1.add(lblNewLabel_2_1_2_1);
		
		JButton btnNewButton_1_1 = new JButton("+");
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaEndereco frame = new TelaEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1_1.setFocusPainted(false);
		btnNewButton_1_1.setBackground(Color.WHITE);
		btnNewButton_1_1.setBounds(527, 288, 457, 31);
		contentPane.add(btnNewButton_1_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(527, 254, 457, 31);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Adicionar Endereço *");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2.setBounds(10, 0, 437, 31);
		panel_2.add(lblNewLabel_2);
		atualizar();
		
		int ano = LocalDate.now().getYear();
		for (int i = 0; i < 110; i++) {
			cbAno.addItem(String.valueOf(ano));
			ano--;
		}
		int mes = 1;
		for (int i = 0; i < 12; i++) {
			cbMes.addItem(String.valueOf(mes));
			mes++;
		}
		int dia = 1;
		for (int i = 0; i < 31; i++) {
			cbDia.addItem(String.valueOf(dia));
			dia++;
		}

	}

	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "Prontuario", "Nome",
				"Data Nascimento", "CPF", "N° Carteira", "Contato", "Convenio", "Sexo" });

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
