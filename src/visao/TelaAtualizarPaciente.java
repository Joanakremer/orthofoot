package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CDao;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import modelo.MPaciente;
import controle.CDao;
import javax.swing.JComboBox;
public class TelaAtualizarPaciente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtProntuario;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCarteira;
	private JFormattedTextField txtContato;
	private JTextField txtConvenio;
	private MPaciente pacienteSelecionado;
	
	/**
	 * Create the frame.
	 */
	/*public TelaAtualizarPaciente(MPaciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}*/
	
	public TelaAtualizarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 640);
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
		
		JLabel lblNewLabel_1 = new JLabel("ATUALIZAR PACIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 507, 293);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtProntuario = new JFormattedTextField();
		txtProntuario.setBounds(10, 40, 265, 29);
		panel_3.add(txtProntuario);
		txtProntuario.setForeground(Color.BLACK);
		txtProntuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtProntuario.setColumns(10);
		
		if(this.pacienteSelecionado != null) {
			
			txtProntuario.setText(String.valueOf(this.pacienteSelecionado.getProntuario()));
			txtNome.setText(this.pacienteSelecionado.getnomeCompleto());
			txtDMA.setText(String.valueOf(this.pacienteSelecionado.getdataNasc()));
			txtCpf.setText(String.valueOf(this.pacienteSelecionado.getCpf()));
			txtCarteira.setText(this.pacienteSelecionado.getnCarteira());
			txtContato.setText(this.pacienteSelecionado.getContato());
			txtConvenio.setText(this.pacienteSelecionado.getConvenio());
			txtSexo.setText(this.pacienteSelecionado.getSexo());
		}
		
		JLabel lblNewLabel = new JLabel("Prontuario *");
		lblNewLabel.setBounds(10, 11, 351, 29);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JLabel lblNomeCompleto = new JLabel("Nome completo *");
		lblNomeCompleto.setBounds(10, 80, 127, 29);
		panel_3.add(lblNomeCompleto);
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 110, 476, 29);
		panel_3.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCpf.setBounds(304, 11, 182, 29);
		panel_3.add(lblCpf);
		
		txtCpf = new JFormattedTextField();
		txtCpf.setBounds(304, 39, 181, 29);
		panel_3.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data Nascimento *");
		lblDataDeNascimento.setBounds(174, 150, 312, 29);
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_3.add(lblDataDeNascimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox.setBounds(172, 178, 59, 29);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1.setBounds(232, 178, 152, 29);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1_1.setBounds(386, 178, 100, 29);
		panel_3.add(comboBox_1_1);
		
		JComboBox comboBox_2 = new JComboBox();
		comboBox_2.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_2.setBounds(10, 179, 134, 29);
		panel_3.add(comboBox_2);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo *");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 150, 127, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(10, 218, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);
		
		txtCarteira = new JFormattedTextField();
		txtCarteira.setBounds(9, 246, 477, 29);
		panel_3.add(txtCarteira);
		txtCarteira.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 371, 507, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 11, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_1);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(10, 41, 487, 29);
		panel_1.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_2.setBounds(10, 81, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_2);
		
		txtContato = new JFormattedTextField();
		txtContato.setBounds(10, 112, 487, 29);
		panel_1.add(txtContato);
		txtContato.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
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
				String dataNascimento = txtDMA.getText().replace("/", "");
				if (dataNascimento == null || dataNascimento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo DATA DE NASCIMENTO está vazio");
				} else {
					// TODO arrumar
//					pacienteSelecionado.setDataNasc(Date.valueOf(dataNascimento));
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
					pacienteSelecionado.setnCarteira(carteira);
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
				String sexo = txtSexo.getText();
				if (sexo == null || sexo.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo SEXO está vazio");
				} else {
					pacienteSelecionado.setSexo(sexo);
				}

				CDao tablePacientes = CDao.getInstancia();
				boolean update = tablePacientes.update(pacienteSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtDMA.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					txtSexo.setText(null);
					
					dispose();
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnAtualizar.setBounds(10, 544, 163, 37);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(428, 544, 89, 37);
		contentPane.add(btnVoltar);
	}
}
