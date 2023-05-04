package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.CDaoEndereco;
import modelo.MEndereco;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaAtualizarEndereco extends JFrame {

	private JPanel contentPane;
	private JTextField txtCep;
	private JTextField txtRua;
	private JTextField txtCidade;
	private MEndereco enderecoSelecionado;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaAtualizarEndereco frame = new TelaAtualizarEndereco();
					frame.setResizable(false);
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
	@SuppressWarnings("unchecked")
	public TelaAtualizarEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 444);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 67, 403, 263);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblEstado = new JLabel("Estado *");
		lblEstado.setBounds(137, 21, 256, 31);
		panel_1.add(lblEstado);
		lblEstado.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCep.setBounds(10, 52, 109, 31);
		panel_1.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cep *");
		lblNewLabel.setBounds(10, 20, 96, 32);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtCidade = new JTextField();
		txtCidade.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCidade.setBounds(10, 124, 383, 31);
		panel_1.add(txtCidade);
		txtCidade.setColumns(10);
		
		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setBounds(10, 93, 383, 31);
		panel_1.add(lblCidade);
		lblCidade.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtRua.setBounds(10, 196, 383, 31);
		panel_1.add(txtRua);
		txtRua.setColumns(10);
		
		JLabel lblRua = new JLabel("Rua *");
		lblRua.setBounds(10, 166, 383, 31);
		panel_1.add(lblRua);
		lblRua.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JComboBox estadoBox = new JComboBox();
		estadoBox.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal", "Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná", "Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina", "São Paulo", "Sergipe"}));
		estadoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		estadoBox.setBounds(137, 52, 256, 31);
		panel_1.add(estadoBox);
		
		JButton btnNewButton = new JButton("Atualizar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MEndereco newEndereco = new MEndereco();

				String cep = txtCep.getText().replace("-", "");
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
				String estado = estadoBox.getSelectedItem().toString();
				newEndereco.setEstado(estado);
				CDaoEndereco tableEndereco = CDaoEndereco.getInstancia();
				boolean insert = tableEndereco.inserir(newEndereco);
				txtCep.disable();
				txtCep.enable(false);
				txtCep.setText(String.valueOf(enderecoSelecionado.getCep()));
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");

					txtCep.setText(null);
					txtRua.setText(null);
					txtCidade.setText(null);
					estadoBox.setSelectedItem("Acre");
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				dispose();
				TelaEndereco frame = new TelaEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(10, 349, 157, 31);
		btnNewButton.setBackground(new Color(192, 192, 192));
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBackground(new Color(192, 192, 192));
		btnNewButton_1.setBounds(325, 349, 89, 31);
		btnNewButton_1.setFocusPainted(false);
		contentPane.add(btnNewButton_1);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setLayout(null);
		panel.setBounds(10, 11, 403, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("ATUALIZAR ENDEREÇO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(50, 8, 285, 27);
		panel.add(lblNewLabel_1);
		
		if(this.enderecoSelecionado != null) {
			txtCep.setText(String.valueOf(this.enderecoSelecionado.getCep()));
			txtRua.setText(this.enderecoSelecionado.getRua());
			txtCidade.setText(String.valueOf(this.enderecoSelecionado.getCidade()));
			estadoBox.setSelectedItem(String.valueOf(this.enderecoSelecionado.getEstado()));
		}
	}
}
