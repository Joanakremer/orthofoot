package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.MaskFormatter;

import controle.CDao;
import controle.CDaoEndereco;
import modelo.MEndereco;
import modelo.MPaciente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.text.ParseException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;

public class TelaCadastroEndereco extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtCep;
	private JTextField txtRua;
	private JTextField txtCidade;
	private JTextField txtEstado;
	private JPanel panel;
	private JLabel lblNewLabel_1;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroEndereco frame = new TelaCadastroEndereco();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaCadastroEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 439, 495);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###-##"));
		} catch (ParseException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		txtCep.setBounds(20, 111, 383, 31);
		contentPane.add(txtCep);
		txtCep.setColumns(10);
		
		txtRua = new JTextField();
		txtRua.setBounds(20, 184, 383, 31);
		contentPane.add(txtRua);
		txtRua.setColumns(10);
		
		txtCidade = new JTextField();
		txtCidade.setBounds(20, 256, 383, 31);
		contentPane.add(txtCidade);
		txtCidade.setColumns(10);
		
		txtEstado = new JTextField();
		txtEstado.setBounds(20, 329, 383, 31);
		contentPane.add(txtEstado);
		txtEstado.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Cep");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel.setBounds(20, 79, 383, 32);
		contentPane.add(lblNewLabel);
		
		JLabel lblRua = new JLabel("Rua");
		lblRua.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblRua.setBounds(20, 153, 383, 31);
		contentPane.add(lblRua);
		
		JLabel lblCidade = new JLabel("Cidade");
		lblCidade.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCidade.setBounds(20, 225, 383, 31);
		contentPane.add(lblCidade);
		
		JLabel lblEstado = new JLabel("Estado");
		lblEstado.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblEstado.setBounds(20, 298, 383, 31);
		contentPane.add(lblEstado);
		
		JButton btnNewButton = new JButton("Cadastrar");
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
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(147, 400, 157, 31);
		contentPane.add(btnNewButton);
		
		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 11, 403, 45);
		contentPane.add(panel);
		
		lblNewLabel_1 = new JLabel("CADASTRAR ENDEREÇO");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(50, 8, 285, 27);
		panel.add(lblNewLabel_1);
		
		btnNewButton_1 = new JButton("Voltar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(314, 400, 89, 31);
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		contentPane.add(btnNewButton_1);
	}
}
