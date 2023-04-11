package visao;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
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
		setBounds(100, 100, 527, 393);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(43, 111, 424, 212);
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
		
		JButton btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroEndereco frame = new TelaCadastroEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(42, 77, 89, 23);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaAtualizarEndereco frame = new TelaAtualizarEndereco();
				frame.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(211, 77, 89, 23);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Deletar");
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
		btnNewButton_2.setBounds(381, 77, 89, 23);
		contentPane.add(btnNewButton_2);
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
