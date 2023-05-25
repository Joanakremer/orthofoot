package visao;

import java.awt.EventQueue; 
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.text.ParseException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.text.MaskFormatter;

import controle.CDaoEndereco;
import controle.CDaoMedico;
import modelo.MEndereco;


import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JFormattedTextField;
import javax.swing.JFormattedTextField.AbstractFormatter;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import java.awt.SystemColor;



public class TelaEndereco extends JFrame {

	private JPanel contentPane;
	private JTable tableEndereco;
	private ArrayList<MEndereco> listaEndereco;
	private MEndereco enderecoSelecionado;
	private CDaoEndereco daoEndereco;
	private JFormattedTextField txtCep;
	private JTextField txtCidade;
	private JTextField txtRua;
	private JComboBox estadoBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaEndereco frame = new TelaEndereco();
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
	public TelaEndereco() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 690, 800);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 397, 656, 302);
		contentPane.add(scrollPane);
		
		daoEndereco = CDaoEndereco.getInstancia();
		listaEndereco = daoEndereco.listarEndereco();
		
		tableEndereco = new JTable();
		tableEndereco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableEndereco.getSelectedRow();
				enderecoSelecionado = listaEndereco.get(posicaoPessoa);
				txtCep.setText(String.valueOf(enderecoSelecionado.getCep()));
				txtRua.setText(enderecoSelecionado.getRua());
				txtCidade.setText(enderecoSelecionado.getCidade());
				estadoBox.setSelectedItem(enderecoSelecionado.getEstado());
				enderecoSelecionado.getEstado();
				if(enderecoSelecionado != null) {
					txtCep.disable();
					
					
				}
			}
		});
		scrollPane.setViewportView(tableEndereco);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(569, 718, 97, 31);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 333, 654, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setBounds(10, 75, 656, 247);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Cep *");
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 96, 32);
		panel_3.add(lblNewLabel_1);
		
		try {
			txtCep = new JFormattedTextField(new MaskFormatter("#####-###-##"));
		} catch (ParseException e1) {
			e1.printStackTrace();
		}
		txtCep.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCep.setBounds(10, 52, 109, 31);
		panel_3.add(txtCep);
		txtCep.setColumns(10);
		
		JLabel lblEstado = new JLabel("Estado *");
		lblEstado.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblEstado.setBounds(137, 21, 256, 31);
		panel_3.add(lblEstado);
		
		estadoBox = new JComboBox();
		estadoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		estadoBox.setModel(new DefaultComboBoxModel(new String[] {"Acre", "Alagoas", "Amapá", "Amazonas", "Bahia", "Ceará", "Distrito Federal",
				"Espírito Santo", "Goiás", "Maranhão", "Mato Grosso", "Mato Grosso do Sul", "Minas Gerais", "Pará", "Paraíba", "Paraná",
				"Pernambuco", "Piauí", "Rio de Janeiro", "Rio Grande do Norte", "Rio Grande do Sul", "Rondônia", "Roraima", "Santa Catarina",
				"São Paulo", "Sergipe"}));
		estadoBox.setBounds(137, 52, 256, 31);
		panel_3.add(estadoBox);
		
		JLabel lblCidade = new JLabel("Cidade *");
		lblCidade.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCidade.setBounds(10, 94, 383, 31);
		panel_3.add(lblCidade);
		
		txtCidade = new JFormattedTextField();
		txtCidade.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCidade.setColumns(10);
		txtCidade.setBounds(10, 125, 636, 31);
		panel_3.add(txtCidade);
		
		JLabel lblRua = new JLabel("Rua *");
		lblRua.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblRua.setBounds(10, 157, 383, 31);
		panel_3.add(lblRua);
		
		txtRua = new JTextField();
		txtRua.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtRua.setColumns(10);
		txtRua.setBounds(10, 187, 636, 31);
		panel_3.add(txtRua);
		
		JButton btnCad = new JButton("Cadastrar");
		btnCad.setBackground(Color.WHITE);
		btnCad.setFocusPainted(false);
		btnCad.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnCad.setBounds(10, 11, 175, 31);
		panel.add(btnCad);
		
		JButton btnDel = new JButton("Deletar");
		btnDel.setBackground(Color.WHITE);
		btnDel.setFocusPainted(false);
		btnDel.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnDel.setBounds(527, 11, 119, 31);
		panel.add(btnDel);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setBackground(Color.WHITE);
		btnAtualizar.setFocusPainted(false);
		btnAtualizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnAtualizar.setBounds(401, 11, 119, 31);
		panel.add(btnAtualizar);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 11, 656, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR ENDEREÇO");
		lblNewLabel.setBounds(184, 11, 285, 27);
		panel_1.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		atualizar();
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MEndereco newEndereco = new MEndereco();

				String cep = txtCep.getText().replace("-", "");
				if (cep == null || cep.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CEP está vazio");
				} else {
					newEndereco.setCep(Long.valueOf(cep));
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
				CDaoEndereco tableEndereco = CDaoEndereco.getInstancia();//TODO errado
				
				boolean update = tableEndereco.update(newEndereco);
				txtCep.setText(String.valueOf(enderecoSelecionado.getCep()));
				System.out.println(newEndereco);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");
					atualizar();
					txtCep.setText(null);
					txtRua.setText(null);
					txtCidade.setText(null);
					estadoBox.setSelectedItem(null);
					atualizar();
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar cadastro");
				}
				atualizar();
			}
			
		});
		atualizar();
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CDaoEndereco s = new CDaoEndereco();
				if(enderecoSelecionado != null) {
					s.delete(enderecoSelecionado);
					listaEndereco.remove(enderecoSelecionado);
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
			}
		});
		atualizar();
		btnCad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MEndereco newEndereco = new MEndereco();

				String cep= txtCep.getText().replace("-", "");
				if (cep == null || cep.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CEP está vazio");
				} else {
					newEndereco.setCep(Long.valueOf(cep));
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
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
					txtCep.setText(null);
					txtRua.setText(null);
					txtCidade.setText(null);
					estadoBox.setSelectedItem("Acre");
					atualizar();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
				atualizar();
			}
		});

	}
	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "cep", "rua",
				"cidade", "estado"});
		listaEndereco = daoEndereco.listarEndereco();
		if (listaEndereco.size() > 0 && listaEndereco != null) {
			for (MEndereco endereco : listaEndereco) {
				if(endereco == null) {
					System.out.println("paciente está vazio");
				}else {
					modelo.addRow(new Object[] { endereco.getCep(), endereco.getRua(),
							endereco.getCidade(), endereco.getEstado()});
				}
			}
		}
		tableEndereco.setModel(modelo);
	}
	protected void limparCampos() {
		txtCep.setText(null);
		txtCidade.setText(null);
		txtRua.setText(null);
		estadoBox.setSelectedItem(null);
	}
}
