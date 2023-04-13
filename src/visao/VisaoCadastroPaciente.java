package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.CDao;
import modelo.MPaciente;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.FlowLayout;
import javax.swing.border.LineBorder;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class VisaoCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtNome;
	private JTextField txtCpf;
	private JTextField txtSexo;
	private JTextField txtDMA;
	private JTextField txtContato;
	private JTextField txtConvenio;
	private JTextField txtCarteira;
	private JTable table;
	private JTextField textField;

	public VisaoCadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1060, 727);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 14, 115, 38);
		contentPane.add(panel);

		JLabel lblNewLabel = new JLabel("Cadastrar Paciente");
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 39));
		lblNewLabel.setBounds(121, 14, 372, 38);
		contentPane.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(95, 158, 160));
		panel_1.setBounds(24, 81, 483, 357);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(21, 27, 68, 64);
		panel_1.add(lblNewLabel_1);
		lblNewLabel_1.setIcon(new ImageIcon(VisaoCadastroPaciente.class.getResource("/imagens/avatar64.png")));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_2 = new JLabel("* Nome Completo");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2.setBounds(107, 27, 351, 29);
		panel_1.add(lblNewLabel_2);

		txtNome = new JTextField();
		txtNome.setForeground(Color.BLACK);
		txtNome.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtNome.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtNome.setBounds(107, 54, 351, 29);
		panel_1.add(txtNome);
		txtNome.setColumns(10);

		JLabel lblNewLabel_2_1 = new JLabel("* CPF");
		lblNewLabel_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1.setBounds(21, 107, 437, 29);
		panel_1.add(lblNewLabel_2_1);

		new JTextField();
		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
			txtCpf.setForeground(Color.BLACK);
			txtCpf.setBorder(new LineBorder(Color.WHITE, 4, true));
			txtCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf.setBounds(21, 135, 437, 29);
		panel_1.add(txtCpf);
		txtCpf.setColumns(10);

		JLabel lblNewLabel_2_1_1 = new JLabel("Sexo");
		lblNewLabel_2_1_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1_1.setBounds(21, 184, 203, 29);
		panel_1.add(lblNewLabel_2_1_1);

		txtSexo = new JTextField();
		txtSexo.setForeground(Color.BLACK);
		txtSexo.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtSexo.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtSexo.setBounds(21, 213, 203, 29);
		panel_1.add(txtSexo);
		txtSexo.setColumns(10);

		new JTextField();
		try {
			txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
			txtContato.setForeground(Color.BLACK);
			txtContato.setBorder(new LineBorder(Color.WHITE, 4, true));
			txtContato.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtContato.setBounds(21, 291, 437, 29);
		panel_1.add(txtContato);
		txtContato.setColumns(10);

		JLabel lblNewLabel_2_1_3 = new JLabel("* Contato");
		lblNewLabel_2_1_3.setForeground(Color.WHITE);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1_3.setBounds(21, 263, 437, 29);
		panel_1.add(lblNewLabel_2_1_3);

		new JTextField();
		try {
			txtDMA = new JFormattedTextField(new MaskFormatter("##/##/####"));
			txtDMA.setForeground(Color.BLACK);
			txtDMA.setBorder(new LineBorder(Color.WHITE, 4, true));
			txtDMA.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		} catch (ParseException e2) {
			e2.printStackTrace();
		}
		txtDMA.setBounds(258, 213, 200, 29);
		panel_1.add(txtDMA);
		txtDMA.setColumns(10);

		JLabel lblNewLabel_2_1_2 = new JLabel("* Data Nascimento");
		lblNewLabel_2_1_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1_2.setBounds(258, 184, 200, 29);
		panel_1.add(lblNewLabel_2_1_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(95, 158, 160));
		panel_2.setBounds(24, 447, 483, 230);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1_2_1.setBounds(23, 23, 315, 29);
		panel_2.add(lblNewLabel_2_1_2_1);

		txtConvenio = new JTextField();
		txtConvenio.setForeground(Color.BLACK);
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtConvenio.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtConvenio.setColumns(10);
		txtConvenio.setBounds(23, 52, 433, 29);
		panel_2.add(txtConvenio);

		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setForeground(Color.WHITE);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_2_1_2_2.setBounds(23, 112, 315, 29);
		panel_2.add(lblNewLabel_2_1_2_2);

		txtCarteira = new JTextField();
		txtCarteira.setForeground(Color.BLACK);
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtCarteira.setBorder(new LineBorder(Color.WHITE, 4, true));
		txtCarteira.setColumns(10);
		txtCarteira.setBounds(23, 141, 433, 29);
		panel_2.add(txtCarteira);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				VisaoPaciente frame = new VisaoPaciente();
				frame.setVisible(true);
			}
		});
		btnVoltar.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnVoltar.setBounds(927, 642, 89, 35);
		btnVoltar.setForeground(Color.WHITE);
		btnVoltar.setBackground(new Color(95, 158, 160));
		btnVoltar.setFocusPainted(false);
		contentPane.add(btnVoltar);

		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MPaciente newPaciente = new MPaciente();
				String nome = txtNome.getText();
				if (nome == null || nome.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					newPaciente.setnomeCompleto(nome);
				}
				String dataNascimento = txtDMA.getText().replace("/", "");
				if (dataNascimento == null || dataNascimento.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo DATA DE NASCIMENTO está vazio");
				} else {
					DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
					LocalDate date = LocalDate.parse(dataNascimento, formatter);
					newPaciente.setDataNasc(date);
				}
				String cpf = txtCpf.getText().replace(".", "").replace("-", "");
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					newPaciente.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText();
				if (carteira == null || carteira.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {
					newPaciente.setnCarteira(carteira);
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
				String sexo = txtSexo.getText();
				if (sexo == null || sexo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo SEXO está vazio");
				} else {
					newPaciente.setSexo(sexo);
				}

				CDao tablePacientes = CDao.getInstancia();
				boolean insert = tablePacientes.inserir(newPaciente);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");

					txtNome.setText(null);
					txtDMA.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					txtSexo.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				dispose();
				VisaoPaciente frame = new VisaoPaciente();
				frame.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		btnCadastrar.setBounds(517, 642, 224, 35);
		btnCadastrar.setForeground(Color.WHITE);
		btnCadastrar.setBackground(new Color(95, 158, 160));
		btnCadastrar.setFocusPainted(false);
		contentPane.add(btnCadastrar);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(95, 158, 160));
		panel_3.setBounds(517, 81, 499, 357);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 132, 479, 214);
		panel_3.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {}, new String[] { "CEP", "Rua", "Cidade", "Estado" }));
		scrollPane.setViewportView(table);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 46, 479, 45);
		panel_3.add(panel_4);
		panel_4.setLayout(null);

		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.setBackground(new Color(95, 158, 160));
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		btnNewButton.setBounds(394, 11, 75, 27);
		btnCadastrar.setFocusPainted(false);
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("Deletar");
		btnNewButton_1.setBackground(new Color(95, 158, 160));
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		btnNewButton_1.setBounds(309, 11, 75, 27);
		btnCadastrar.setFocusPainted(false);
		panel_4.add(btnNewButton_1);

		JButton btnNewButton_2 = new JButton("Cadastrar");
		btnNewButton_2.setBackground(new Color(95, 158, 160));
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 10));
		btnCadastrar.setFocusPainted(false);
		btnNewButton_2.setBounds(182, 10, 117, 28);
		panel_4.add(btnNewButton_2);

		textField = new JTextField();
		textField.setBounds(8, 9, 137, 29);
		panel_4.add(textField);
		textField.setColumns(10);
	}
}
