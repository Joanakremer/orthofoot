package visao;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDao;
import controle.CDaoMedico;
import modelo.MMedico;
import modelo.MPaciente;

import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
	private JComboBox<String> cbDia,cbMes,cbAno;
	private ArrayList<MMedico> listarMedico;
	private MMedico medicoSelecionado;
	private JTextField txtSexo;
	private JTable table;
	
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
		
		cbAno = new JComboBox<>();
		int ano = LocalDate.now().getYear();
		for (int i = 0; i < 110; i++) {
			cbAno.addItem(String.valueOf(ano));
			ano--;
		}
		cbAno.setBounds(281, 170, 77, 22);
		contentPane.add(cbAno);
		
		cbDia = new JComboBox<>();
		int dia = 0;
		for (int i = 0; i < 31; i++) {
			cbDia.addItem(String.valueOf(dia));
			dia++;
		}
		cbDia.setBounds(127, 170, 62, 22);
		contentPane.add(cbDia);
		
		cbMes = new JComboBox<>();
		int mes = 0;
		for (int i = 0; i < 13; i++) {
			cbMes.addItem(String.valueOf(mes));
			mes++;
		}
		cbMes.setBounds(199, 170, 60, 22);
		contentPane.add(cbMes);
		
		lblNewLabel_3 = new JLabel("Sexo");
		lblNewLabel_3.setBounds(298, 43, 46, 14);
		contentPane.add(lblNewLabel_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 304, 429, 224);
		contentPane.add(scrollPane);
		
		
		JButton btnCadastrar = new JButton("Cadastrar");
		btnCadastrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				MMedico newMedico = new MMedico();
				String crm = txtCrm.getText();
				if (crm == null || crm.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CRM está vazio");
				} else {
					newMedico.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNomeCompleto.getText();
				if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME COMPLETO está vazio");
				} else {
					newMedico.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();
				
				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				newMedico.setdataNasc(data);
			
				
				String sexo = (String) txtSexo.getText();
				if (sexo == null || sexo.trim().isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo SEXO está vazio");
				} else {
					newMedico.setSexo(sexo);
				}
				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				boolean insert = tableMedico.inserir(newMedico);
				if (insert == true) {
					JOptionPane.showMessageDialog(null, "Cadastro realizado");
					atualizar();
					limparCampos();
				} else {
					JOptionPane.showMessageDialog(null, "Erro ao fazer o cadastro");
				}
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
		
		txtSexo = new JTextField();
		txtSexo.setColumns(10);
		txtSexo.setBounds(334, 40, 86, 20);
		contentPane.add(txtSexo);
		
		daoMedico = CDaoMedico.getInstancia();
		
		tableMedico = new JTable();
		scrollPane.setViewportView(tableMedico);

		
		atualizar();
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
		
	}
	protected void limparCampos() {
		txtNomeCompleto.setText(null);
		txtCrm.setText(null);
		txtSexo.setText(null);
	}

	public void atualizar() {
		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] {"crm", "nomeCompleto", "dataNasc", "sexo"});
		listarMedico = daoMedico.listarMedico();

		if (listarMedico.size() > 0 && listarMedico != null) {
			for (MMedico medico : listarMedico) {
				modelo.addRow(new Object[] { medico.getCrm(), medico.getnomeCompleto(), medico.getdataNasc(),
						medico.getSexo()});
			}
		}

		tableMedico.setModel(modelo);
		
	}
}
