package visao;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import controle.CDao;
import modelo.MPaciente;

public class TelaCadastroPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtProntuario;
	private JTextField txtNome;
	private JTextField txtDMA;
	private JTextField txtCpf;
	private JTextField txtCarteira;
	private JTextField txtContato;
	private JTextField txtConvenio;
	private JTextField txtSexo;

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
		setBounds(100, 100, 539, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);

		txtProntuario = new JTextField();
		txtProntuario.setBounds(10, 24, 157, 20);
		contentPane.add(txtProntuario);
		txtProntuario.setColumns(10);

		txtNome = new JTextField();
		txtNome.setBounds(10, 68, 157, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);

		txtDMA = new JTextField();
		txtDMA.setBounds(10, 112, 157, 20);
		contentPane.add(txtDMA);
		txtDMA.setColumns(10);

		txtCpf = new JTextField();
		txtCpf.setBounds(10, 156, 157, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);

		txtCarteira = new JTextField();
		txtCarteira.setBounds(10, 200, 157, 20);
		contentPane.add(txtCarteira);
		txtCarteira.setColumns(10);

		txtContato = new JTextField();
		txtContato.setBounds(10, 244, 157, 20);
		contentPane.add(txtContato);
		txtContato.setColumns(10);

		txtConvenio = new JTextField();
		txtConvenio.setBounds(10, 288, 157, 20);
		contentPane.add(txtConvenio);
		txtConvenio.setColumns(10);

		txtSexo = new JTextField();
		txtSexo.setBounds(10, 332, 157, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);

		JLabel lblNewLabel = new JLabel("Prontuario");
		lblNewLabel.setBounds(10, 11, 112, 14);
		contentPane.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("Nome completo");
		lblNewLabel_1.setBounds(10, 55, 112, 14);
		contentPane.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("Data de nascimento");
		lblNewLabel_2.setBounds(10, 99, 112, 14);
		contentPane.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("CPF");
		lblNewLabel_3.setBounds(10, 143, 112, 14);
		contentPane.add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("Numero Carteira");
		lblNewLabel_4.setBounds(10, 187, 112, 14);
		contentPane.add(lblNewLabel_4);

		JLabel lblNewLabel_5 = new JLabel("Contato");
		lblNewLabel_5.setBounds(10, 231, 112, 14);
		contentPane.add(lblNewLabel_5);

		JLabel lblNewLabel_6 = new JLabel("Convenio");
		lblNewLabel_6.setBounds(10, 275, 112, 14);
		contentPane.add(lblNewLabel_6);

		JLabel lblNewLabel_7 = new JLabel("Sexo");
		lblNewLabel_7.setBounds(10, 319, 112, 14);
		contentPane.add(lblNewLabel_7);

		JButton btnCadastrar = new JButton("Cadastar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MPaciente newPaciente = new MPaciente();

				String prontuario = txtProntuario.getText();
				if (prontuario == null || prontuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					newPaciente.setProntuario(Integer.valueOf(prontuario));
				}
				String nome = txtNome.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					newPaciente.setnomeCompleto(nome);
				}
				String dataNascimento = txtDMA.getText();
				if (dataNascimento == null || dataNascimento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo DATA DE NASCIMENTO está vazio");
				} else {
					newPaciente.setdataNasc(Date.valueOf(dataNascimento));
				}
				String cpf = txtCpf.getText();
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					newPaciente.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText();
				if (carteira == null || carteira.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {
					newPaciente.setnCarteira(carteira);
				}
				String contato = txtContato.getText();
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

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtDMA.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					txtSexo.setText(null);
				}
				dispose();
				TelaPaciente frame = new TelaPaciente();
				frame.setVisible(true);
			}
		});
		btnCadastrar.setBounds(278, 88, 163, 37);
		contentPane.add(btnCadastrar);

		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaPaciente frame = new TelaPaciente();
				frame.setVisible(true);
			}
		});
		btnVoltar.setBounds(321, 199, 89, 23);
		contentPane.add(btnVoltar);
	}
}
