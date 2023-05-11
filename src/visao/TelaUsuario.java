package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDaoMedico;
import modelo.MMedico;

import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;
	private JTextField txtCrm;
	private JTextField txtNomeCompleto;
	private CDaoMedico daoMedico;
	private JComboBox<String> cbDia,cbMes,cbAno;
	private ArrayList<MMedico> listarMedico;
	private MMedico medicoSelecionado;
	private JTable table;
	private JComboBox cbSexo;
	private String crm;
	private JTable tableMedico;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaUsuario frame = new TelaUsuario();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaUsuario() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 643, 742);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 11, 607, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 326, 607, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("CADASTRAR MÉDICO");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(159, 11, 304, 31);
		panel_1.add(lblNewLabel);
		
		btnNewButton = new JButton("Cadastrar Médico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaMedico frame = null;
				frame = new TelaMedico();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setFocusPainted(false);
		btnNewButton.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton.setBounds(10, 11, 162, 31);
		panel.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				crm = txtCrm.getText().replace("", "");
				if (crm == null || crm.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					medicoSelecionado.setCrm(Long.valueOf(crm));
				}
				String nomeCompleto = txtNomeCompleto.getText();
				if (nomeCompleto == null || nomeCompleto.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					medicoSelecionado.setnomeCompleto(nomeCompleto);
				}
				String dia = (String) cbDia.getSelectedItem();
				String mes = (String) cbMes.getSelectedItem();
				String ano = (String) cbAno.getSelectedItem();

				LocalDate data = LocalDate.of(Integer.valueOf(ano), Integer.valueOf(mes), Integer.valueOf(dia));
				medicoSelecionado.setdataNasc(data);
				
				String sexo =String.valueOf(cbSexo.getSelectedItem().toString());
					medicoSelecionado.setSexo(sexo);

				CDaoMedico tableMedico = CDaoMedico.getInstancia();
				boolean update = tableMedico.update(medicoSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtCrm.setText(null);
					txtNomeCompleto.setText(null);
					atualizar();
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(349, 11, 119, 31);
		panel.add(btnNewButton_1);
		
		
		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			CDaoMedico c = new CDaoMedico();
			public void actionPerformed(ActionEvent e) {	
				if(medicoSelecionado != null) {
					c.delete(medicoSelecionado);
					listarMedico.remove(medicoSelecionado);
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(478, 11, 119, 31);
		panel.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Voltar");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VisaoPrincipal frame = new VisaoPrincipal();
				frame.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBackground(Color.WHITE);
		btnNewButton_3.setFocusPainted(false);
		btnNewButton_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_3.setBounds(520, 649, 97, 31);
		contentPane.add(btnNewButton_3);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 390, 607, 236);
		contentPane.add(scrollPane);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(220, 220, 220));
		panel_3.setLayout(null);
		panel_3.setBounds(10, 75, 607, 240);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel_2 = new JLabel("Data Nascimento *");
		lblNewLabel_2.setForeground(Color.BLACK);
		lblNewLabel_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2.setBounds(340, 152, 257, 29);
		panel_3.add(lblNewLabel_2);
		
		JComboBox<String> cbAno = new JComboBox<String>();
		cbAno.setBounds(518, 182, 79, 29);
		panel_3.add(cbAno);
		
		JComboBox<String> cbDia = new JComboBox<String>();
		cbDia.setBounds(340, 182, 79, 29);
		panel_3.add(cbDia);
		
		JComboBox<String> cbMes = new JComboBox<String>();
		cbMes.setBounds(429, 182, 79, 28);
		panel_3.add(cbMes);
		
		JLabel lblNomeCompleto = new JLabel("Nome Completo *");
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNomeCompleto.setBounds(10, 80, 487, 29);
		panel_3.add(lblNomeCompleto);
		
		txtNomeCompleto = new JTextField();
		txtNomeCompleto.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNomeCompleto.setColumns(10);
		txtNomeCompleto.setBounds(10, 110, 587, 29);
		panel_3.add(txtNomeCompleto);
		
		JLabel lblNewLabel_1 = new JLabel("CRM *");
		lblNewLabel_1.setForeground(Color.BLACK);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_1.setBounds(10, 11, 265, 29);
		panel_3.add(lblNewLabel_1);
		
		txtCrm = new JTextField();
		txtCrm.setForeground(Color.BLACK);
		txtCrm.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCrm.setColumns(10);
		txtCrm.setBounds(10, 40, 587, 29);
		panel_3.add(txtCrm);
		
		JLabel lblNewLabel_3 = new JLabel("Sexo *");
		lblNewLabel_3.setForeground(Color.BLACK);
		lblNewLabel_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_3.setBounds(10, 150, 181, 29);
		panel_3.add(lblNewLabel_3);
		
		JComboBox cbSexo = new JComboBox();
		cbSexo.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		cbSexo.setBounds(10, 179, 181, 29);
		panel_3.add(cbSexo);
		
		tableMedico.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tableMedico.getSelectedRow();
				medicoSelecionado = listarMedico.get(posicaoPessoa);
				txtNomeCompleto.setText(medicoSelecionado.getnomeCompleto());
				txtCrm.setText(String.valueOf(medicoSelecionado.getCrm()));
				cbDia.setSelectedIndex(medicoSelecionado.getdataNasc().getDayOfMonth());
				cbMes.setSelectedIndex(medicoSelecionado.getdataNasc().getMonthValue());
				cbAno.setSelectedItem(medicoSelecionado.getdataNasc().getYear()+"");
				cbSexo.setSelectedItem(medicoSelecionado.getSexo());
				if(medicoSelecionado != null) {
					txtCrm.disable();
				}
			}
		});
	}
	protected void limparCampos() {
		txtNomeCompleto.setText(null);
		txtCrm.setText(null);
		cbSexo.setSelectedItem(null);
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
