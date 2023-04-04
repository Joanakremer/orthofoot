package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CDaoEndereco;
import modelo.MEndereco;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaAtualizarEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private MEndereco enderecoSelecionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarEndereco frame = new TelaAtualizarEndereco();
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
	public TelaAtualizarEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 534, 416);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCep = new JTextField();
		txtCep.setBounds(10, 54, 86, 20);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(10, 114, 86, 20);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(10, 181, 86, 20);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(10, 251, 86, 20);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		if(this.enderecoSelecionado != null) {
			txtCep.setText(String.valueOf(this.enderecoSelecionado.getCep()));
			txtRua.setText(this.enderecoSelecionado.getRua());
			txtCidade.setText(String.valueOf(this.enderecoSelecionado.getCidade()));
			txtEstado.setText(String.valueOf(this.enderecoSelecionado.getEstado()));
		}
		
		JLabel Cep = new JLabel("Cep");
		Cep.setBounds(10, 40, 46, 14);
		contentPane.add(Cep);
		
		JLabel Rua = new JLabel("Rua");
		Rua.setBounds(10, 99, 46, 14);
		contentPane.add(Rua);
		
		JLabel Cidade = new JLabel("Cidade");
		Cidade.setBounds(10, 167, 46, 14);
		contentPane.add(Cidade);
		
		JLabel Estado = new JLabel("Estado");
		Estado.setBounds(10, 238, 46, 14);
		contentPane.add(Estado);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MEndereco newEndereco = new MEndereco();

				String cep= txtCep.getText().replace("-", "");
				if (cep == null || cep.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CEP está vazio");
				} else {
					newEndereco.setCep(Integer.valueOf(cep));
				}
				String rua = txtRua.getText();
				if (rua == null || rua.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo RUA está vazio");
				} else {
					newEndereco.setRua(rua);
				}
				String cidade = txtCidade.getText();
				if (cidade == null || cidade.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CIDADE está vazio");
				} else {
					newEndereco.setCidade(cidade);
				}
				String estado = txtEstado.getText();
				if (estado == null || estado.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo ESTADO está vazio");
				} else {
					newEndereco.setEstado(estado);
				}
				CDaoEndereco tableEndereco = CDaoEndereco.getInstancia();
				boolean insert = tableEndereco.inserir(newEndereco);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");

					txtCep.setText(null);
					txtRua.setText(null);
					txtCidade.setText(null);
					txtEstado.setText(null);
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				dispose();
				TelaEndereco frame = new TelaEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(271, 113, 89, 23);
		contentPane.add(btnNewButton);
	}

}
