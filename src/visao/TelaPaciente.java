package visao;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import controle.CDao;
import modelo.MPaciente;

import javax.swing.JScrollPane;
import javax.swing.JTable;

public class TelaPaciente extends JFrame {

	private JPanel contentPane;
	private JTable tablePacientes;
	private MPaciente pacienteSelecionado;
	private ArrayList<MPaciente> listaPaciente;
	private CDao dao; 

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaPaciente frame = new TelaPaciente();
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
	public TelaPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 849, 412);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(105, 91, 625, 244);
		contentPane.add(scrollPane);
		
		atualizar();
		
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
		
	}
	public void atualizar() {

		DefaultTableModel modelo = new DefaultTableModel(new Object[][] {},
				new String[] { "prontuario", "nomeCompleto", "dataNasc", "cpf", "nCarteira", "contato", "convenio", "sexo" });

		if (listaPaciente.size() > 0 && listaPaciente != null) {
			for (MPaciente paciente : listaPaciente) {
				modelo.addRow(new Object[] { paciente.getProntuario(), paciente.getnomeCompleto(), paciente.getdataNasc(),
						paciente.getCpf(), paciente.getnCarteira(), paciente.getContato(), paciente.getConvenio(), paciente.getSexo() });
			}
		}

		tablePacientes.setModel(modelo);
	}
}
