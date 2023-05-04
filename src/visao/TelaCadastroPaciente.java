package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.time.LocalDate;

import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.CDao;
import modelo.MPaciente;
import javax.swing.JComboBox;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtProntuario;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCarteira;
	private JFormattedTextField txtContato;
	private JTextField txtConvenio;
	private JComboBox<String> cbDia, cbMes, cbAno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroPaciente frame = new TelaCadastroPaciente();
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
	public TelaCadastroPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 650);
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
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 371, 507, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("CADASTRAR PACIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 507, 293);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		try {
			txtProntuario = new JFormattedTextField(new MaskFormatter("####"));
		} catch (ParseException e3) {
			e3.printStackTrace();
		}
		txtProntuario.setBounds(10, 40, 265, 29);
		panel_3.add(txtProntuario);
		txtProntuario.setForeground(Color.BLACK);
		txtProntuario.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtProntuario.setColumns(10);

		txtNome = new JTextField();
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNome.setBounds(10, 110, 487, 29);
		panel_3.add(txtNome);
		txtNome.setColumns(10);

		try {
			txtCpf = new JFormattedTextField(new MaskFormatter("###.###.###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCpf.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCpf.setBounds(304, 39, 193, 29);
		panel_3.add(txtCpf);
		txtCpf.setColumns(10);

		try {
			txtCarteira = new JFormattedTextField(new MaskFormatter("#####################"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCarteira.setBounds(10, 115, 477, 29);
		panel_1.add(txtCarteira);
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCarteira.setColumns(10);

		try {
			txtContato = new JFormattedTextField(new MaskFormatter("(+##)## #####-####"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtContato.setBounds(10, 245, 487, 29);
		panel_3.add(txtContato);
		txtContato.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtContato.setColumns(10);

		txtConvenio = new JTextField();
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtConvenio.setBounds(10, 41, 487, 29);
		panel_1.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JComboBox sexoBox = new JComboBox();
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		sexoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		sexoBox.setBounds(10, 179, 181, 29);
		panel_3.add(sexoBox);

		JLabel lblNewLabel = new JLabel("Prontuario *");
		lblNewLabel.setBounds(10, 11, 265, 29);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));	
		
		JLabel lblNomeCompleto = new JLabel("Nome completo *");
		lblNomeCompleto.setBounds(10, 80, 127, 29);
		panel_3.add(lblNomeCompleto);
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));

		JLabel lblDataDeNascimento = new JLabel("Data Nascimento *");
		lblDataDeNascimento.setBounds(262, 150, 224, 29);
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_3.add(lblDataDeNascimento);

		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCpf.setBounds(304, 11, 182, 29);
		panel_3.add(lblCpf);

		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_2.setBounds(10, 81, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_2);

		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(10, 218, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);

		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 11, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_1);

		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo *");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 150, 181, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
				cbDia = new JComboBox<>();
				cbDia.setBounds(262, 182, 68, 29);
				panel_3.add(cbDia);
				
						cbMes = new JComboBox<>();
						cbMes.setBounds(340, 182, 68, 28);
						panel_3.add(cbMes);
						
								cbAno = new JComboBox<>();
								cbAno.setBounds(418, 182, 79, 29);
								panel_3.add(cbAno);

		JButton btnCadastrar = new JButton("Confirmar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
				/*
				 * LocalDate data1 = LocalDate.parse(dataNascimento);
				 * newPaciente.setdataNasc(Date.valueOf(dataNascimento));
				 */

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
				String sexo = sexoBox.getSelectedItem().toString();
				newPaciente.setSexo(sexo);

				CDao tablePacientes = CDao.getInstancia();
				boolean insert = tablePacientes.inserir(newPaciente);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					//txtDia.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					sexoBox.setSelectedItem("Masculino");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				dispose();
				TelaPaciente frame = new TelaPaciente();
				frame.setVisible(true);
			}
		});
		btnCadastrar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnCadastrar.setBounds(395, 553, 122, 37);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Cadastrar Endereço *");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEndereco frame = null;
				try {
					frame = new TelaCadastroEndereco();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				frame.setVisible(true);
				
			}
		});
		btnVoltar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnVoltar.setBounds(10, 553, 211, 37);
		contentPane.add(btnVoltar);
		
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
}
