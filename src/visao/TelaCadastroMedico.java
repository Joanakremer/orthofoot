package visao;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDaoMedico;
import modelo.MMedico;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaCadastroMedico extends JFrame {

	private JPanel contentPane;
	private JTextField txtCrm;
	private JTextField txtNomeCompleto;
	private JLabel lblNewLabel_3;
	private JTable tableMedico;
	private CDaoMedico daoMedico;
	private JComboBox<String> txtDia,txtMes,txtAno;
	private ArrayList<MMedico> listarMedico;
	private MMedico medicoSelecionado;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaCadastroMedico frame = new TelaCadastroMedico();
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
	public TelaCadastroMedico() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 547, 578);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		txtCrm = new JTextField();
		txtCrm.setBounds(173, 40, 86, 20);
		contentPane.add(txtCrm);
		txtCrm.setColumns(10);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setBounds(173, 97, 86, 20);
		contentPane.add(txtNomeCompleto);
		txtNomeCompleto.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("CRM");
		lblNewLabel.setBounds(33, 43, 46, 14);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Nome completo");
		lblNewLabel_1.setBounds(33, 100, 84, 14);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Data de Nascimento");
		lblNewLabel_2.setBounds(10, 174, 107, 14);
		contentPane.add(lblNewLabel_2);
		
		JComboBox txtSexo = new JComboBox();
		txtSexo.setBounds(143, 228, 53, 22);
		contentPane.add(txtSexo);
		
		txtAno = new JComboBox();
		txtAno.setBounds(281, 170, 46, 22);
		contentPane.add(txtAno);
		
		txtDia = new JComboBox();
		txtDia.setBounds(143, 170, 46, 22);
		contentPane.add(txtDia);
		
		txtMes = new JComboBox();
		txtMes.setBounds(199, 170, 46, 22);
		contentPane.add(txtMes);
		
		lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(33, 232, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 304, 429, 224);
		contentPane.add(scrollPane);
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCadastrar.setBounds(206, 228, 89, 23);
		contentPane.add(btnCadastrar);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnAtualizar.setBounds(305, 228, 89, 23);
		contentPane.add(btnAtualizar);
		
		JButton btnDeletar = new JButton("Deletar");
		btnDeletar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnDeletar.setBounds(404, 228, 89, 23);
		contentPane.add(btnDeletar);
		
		daoMedico = CDaoMedico.getInstancia();
		listarMedico = daoMedico.listarMedico();
		
		tableMedico = new JTable();
		
		tableMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableMedico.getSelectedRow();
				medicoSelecionado = listarMedico.get(posicaoPessoa);
				medicoSelecionado.getCrm();
				medicoSelecionado.getnomeCompleto();
				medicoSelecionado.getdataNasc();
				medicoSelecionado.getSexo();
			}
		});
		/*
		public void atualizar () {
			DefaultTableModel modelo = new DeufaltTableModel (new Object[][] {}, new String [] 
					{"crm","nomeCompleto","dataNasc","sexo"} );
			
			table.setModel(modelo);
			
			if (listaMedico.size() > 0 && listaMedico != null) {
				for (MMedico medico : listaMedico) {
					if (medico == null) {
						System.out.println("medico esta vazio");
					} else {
						modelo.addRow(new Objetc[] {medico.getcrm(),medico.getnomeCompleto(),medico.getdataNasc(),medico.getsexo()});
					}
				}
			}
		}*/
	}
}
