package visao;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;

import javax.swing.table.DefaultTableModel;

import controle.CDao;
import modelo.MPaciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;


public class TelaPaciente extends JFrame {

	private JPanel contentPane;
	private JTable tablePacientes;
	private MPaciente pacienteSelecionado;
	private ArrayList<MPaciente> listaPaciente;
	private CDao dao;
	private JButton btnNewButton;
	private JButton btnNewButton_1;
	private JButton btnNewButton_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 2000, 1050);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);

		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel.setBackground(new Color(95, 158, 160));
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new MigLayout("", "[20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:100px,grow][20px:n:150px,grow][20px:n:100px,grow][20px:n:100px,grow]", "[20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:40px,grow][20px:n:60px,grow][20px:n:40px,grow]"));
		

		contentPane.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(66, 91, 700, 244);
		contentPane.add(scrollPane);

		listaPaciente = dao.listarPaciente();
		tablePacientes = new JTable();

		tablePacientes.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int posicaoPessoa = tablePacientes.getSelectedRow();
				pacienteSelecionado = listaPaciente.get(posicaoPessoa);
				pacienteSelecionado.getProntuario();
				pacienteSelecionado.getnomeCompleto();
				pacienteSelecionado.getdataNasc();
				pacienteSelecionado.getCpf();
				pacienteSelecionado.getnCarteira();
				pacienteSelecionado.getContato();
				pacienteSelecionado.getConvenio();
				pacienteSelecionado.getSexo();
			}
		});
		scrollPane.setViewportView(tablePacientes);
		
		btnNewButton = new JButton("Cadastrar");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
				TelaCadastroPaciente frame = new TelaCadastroPaciente();
				frame.setVisible(true);
			}
		});
		btnNewButton.setBounds(66, 57, 132, 23);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("Atualizar");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}
		});
		btnNewButton_1.setBounds(350, 57, 132, 23);
		contentPane.add(btnNewButton_1);
		
		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(pacienteSelecionado != null) {
					listaPaciente.remove(pacienteSelecionado);
					
					JOptionPane.showMessageDialog(null, "dado removido com sucesso");
					atualizar();
				}else {
					JOptionPane.showInternalMessageDialog(null, "erro na remoção do dado");
				}
			}
		});
		btnNewButton_2.setBounds(634, 57, 132, 23);
		contentPane.add(btnNewButton_2);

		atualizar();


	}

	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {}, new String[] { "prontuario", "nomeCompleto",
				"dataNasc", "cpf", "nCarteira", "contato", "convenio", "sexo" });

		tablePacientes.setModel(modelo);
		
		if (listaPaciente.size() > 0 && listaPaciente != null) {
			for (MPaciente paciente : listaPaciente) {
				if(paciente == null) {
					System.out.println("paciente está vazio");
				}else {
					modelo.addRow(new Object[] { paciente.getProntuario(), paciente.getnomeCompleto(),
							paciente.getdataNasc(), paciente.getCpf(), paciente.getnCarteira(), paciente.getContato(),
							paciente.getConvenio(), paciente.getSexo() });
				}
			}
		}
	}
}
