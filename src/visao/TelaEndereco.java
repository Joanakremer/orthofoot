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

import controle.CDaoEndereco;
import modelo.MEndereco;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.border.LineBorder;



public class TelaEndereco extends JFrame {

	private JPanel contentPane;
	private JTable tableEndereco;
	private ArrayList<MEndereco> listaEndereco;
	private MEndereco enderecoSelecionado;
	private CDaoEndereco daoEndereco;

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
		setBounds(100, 100, 690, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 148, 656, 300);
		contentPane.add(scrollPane);
		
		daoEndereco = CDaoEndereco.getInstancia();
		listaEndereco = daoEndereco.listarEndereco();
		
		tableEndereco = new JTable();
		tableEndereco.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableEndereco.getSelectedRow();
				enderecoSelecionado = listaEndereco.get(posicaoPessoa);
				enderecoSelecionado.getCep();
				enderecoSelecionado.getRua();
				enderecoSelecionado.getCidade();
				enderecoSelecionado.getEstado();
			}
		});
		scrollPane.setViewportView(tableEndereco);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(569, 459, 97, 31);
		contentPane.add(btnNewButton_3);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 84, 656, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(10, 11, 175, 31);
		panel.add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(527, 11, 119, 31);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(401, 11, 119, 31);
		panel.add(btnNewButton_1);
		
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
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaAtualizarEndereco frame = new TelaAtualizarEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(enderecoSelecionado != null) {
					listaEndereco.remove(enderecoSelecionado);
					
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroEndereco frame = null;
				try {
					frame = new TelaCadastroEndereco();
				} catch (ParseException e1) {
					e1.printStackTrace();
				}
				frame.setVisible(true);
			}
		});
	atualizar();
	}
	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "cep", "rua",
				"cidade", "estado"});

		tableEndereco.setModel(modelo);
		
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
	}
}
