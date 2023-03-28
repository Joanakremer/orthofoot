package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CDao;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import modelo.MPaciente;
import controle.CDao;
public class TelaAtualizarPaciente extends JFrame {

	private JPanel contentPane;
	private JTextField txtProntuario;
	private JTextField txtNome;
	private JTextField txtDMA;
	private JTextField txtCpf;
	private JTextField txtCarteira;
	private JTextField txtContato;
	private JTextField txtConvenio;
	private JTextField txtSexo;
	private MPaciente pacienteSelecionado;
	
	/**
	 * Create the frame.
	 */
	/*public TelaAtualizarPaciente(MPaciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}*/
	
	public TelaAtualizarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 537, 413);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtProntuario = new JTextField();
		txtProntuario.setBounds(10, 23, 131, 20);
		contentPane.add(txtProntuario);
		txtProntuario.setColumns(10);
		
		txtNome = new JTextField();
		txtNome.setBounds(10, 66, 131, 20);
		contentPane.add(txtNome);
		txtNome.setColumns(10);
		
		txtDMA = new JTextField();
		txtDMA.setBounds(10, 109, 131, 20);
		contentPane.add(txtDMA);
		txtDMA.setColumns(10);
		
		txtCpf = new JTextField();
		txtCpf.setBounds(10, 152, 131, 20);
		contentPane.add(txtCpf);
		txtCpf.setColumns(10);
		
		txtCarteira = new JTextField();
		txtCarteira.setBounds(10, 195, 131, 20);
		contentPane.add(txtCarteira);
		txtCarteira.setColumns(10);
		
		txtContato = new JTextField();
		txtContato.setBounds(10, 238, 131, 20);
		contentPane.add(txtContato);
		txtContato.setColumns(10);
		
		txtConvenio = new JTextField();
		txtConvenio.setBounds(10, 281, 131, 20);
		contentPane.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		txtSexo = new JTextField();
		txtSexo.setBounds(10, 324, 131, 20);
		contentPane.add(txtSexo);
		txtSexo.setColumns(10);
		
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
		
		JLabel lblNewLabel = new JLabel("Prontuario");
		lblNewLabel.setBounds(10, 11, 106, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNomeCompleto = new JLabel("Nome completo");
		lblNomeCompleto.setBounds(10, 52, 106, 14);
		contentPane.add(lblNomeCompleto);
		
		JLabel lblDataDeNascimento = new JLabel("Data de nascimento");
		lblDataDeNascimento.setBounds(10, 97, 106, 14);
		contentPane.add(lblDataDeNascimento);
		
		JLabel lblCpf = new JLabel("CPF");
		lblCpf.setBounds(10, 140, 106, 14);
		contentPane.add(lblCpf);
		
		JLabel lblNumeroCarteira = new JLabel("Numero carteira");
		lblNumeroCarteira.setBounds(10, 183, 106, 14);
		contentPane.add(lblNumeroCarteira);
		
		JLabel lblContato = new JLabel("Contato");
		lblContato.setBounds(10, 226, 106, 14);
		contentPane.add(lblContato);
		
		JLabel lblConvenio = new JLabel("Convenio");
		lblConvenio.setBounds(10, 269, 106, 14);
		contentPane.add(lblConvenio);
		
		JLabel lblSexo = new JLabel("Sexo");
		lblSexo.setBounds(10, 312, 106, 14);
		contentPane.add(lblSexo);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String prontuario = txtProntuario.getText();
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
				String dataNascimento = txtDMA.getText();
				if (dataNascimento == null || dataNascimento.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo DATA DE NASCIMENTO está vazio");
				} else {
					pacienteSelecionado.setdataNasc(Date.valueOf(dataNascimento));
				}
				String cpf = txtCpf.getText();
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
				String contato = txtContato.getText();
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
					JOptionPane.showMessageDialog(null, "Erro inesperado");
				}
			}
		});
		btnAtualizar.setBounds(279, 86, 163, 37);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setBounds(316, 194, 89, 23);
		contentPane.add(btnVoltar);
	}
}
