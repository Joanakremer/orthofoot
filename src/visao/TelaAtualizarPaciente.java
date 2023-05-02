package visao;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import controle.CDao;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;

import java.awt.event.ActionListener;
import java.sql.Date;
import java.awt.event.ActionEvent;
import modelo.MPaciente;
import controle.CDao;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
public class TelaAtualizarPaciente extends JFrame {

	private JPanel contentPane;
	private JFormattedTextField txtProntuario;
	private JTextField txtNome;
	private JFormattedTextField txtCpf;
	private JFormattedTextField txtCarteira;
	private JFormattedTextField txtContato;
	private JTextField txtConvenio;
	private MPaciente pacienteSelecionado;
	
	/**
	 * Create the frame.
	 */
	/*public TelaAtualizarPaciente(MPaciente pacienteSelecionado) {
		this.pacienteSelecionado = pacienteSelecionado;
	}*/
	
	public TelaAtualizarPaciente() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 543, 640);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(10, 11, 507, 45);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("ATUALIZAR PACIENTE");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 17));
		lblNewLabel_1.setBounds(102, 11, 285, 27);
		panel.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 67, 507, 293);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		txtProntuario = new JFormattedTextField();
		txtProntuario.setBounds(10, 40, 265, 29);
		panel_3.add(txtProntuario);
		txtProntuario.setForeground(Color.BLACK);
		txtProntuario.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		txtProntuario.setColumns(10);
		
		
		
		JLabel lblNewLabel = new JLabel("Prontuario *");
		lblNewLabel.setBounds(10, 11, 351, 29);
		panel_3.add(lblNewLabel);
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		JLabel lblNomeCompleto = new JLabel("Nome completo *");
		lblNomeCompleto.setBounds(10, 80, 127, 29);
		panel_3.add(lblNomeCompleto);
		lblNomeCompleto.setForeground(Color.BLACK);
		lblNomeCompleto.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		
		txtNome = new JTextField();
		txtNome.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtNome.setBounds(10, 110, 476, 29);
		panel_3.add(txtNome);
		txtNome.setColumns(10);
		
		JLabel lblCpf = new JLabel("CPF *");
		lblCpf.setForeground(Color.BLACK);
		lblCpf.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblCpf.setBounds(304, 11, 182, 29);
		panel_3.add(lblCpf);
		
		txtCpf = new JFormattedTextField();
		txtCpf.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCpf.setBounds(304, 39, 181, 29);
		panel_3.add(txtCpf);
		txtCpf.setColumns(10);
		
		JLabel lblDataDeNascimento = new JLabel("Data Nascimento *");
		lblDataDeNascimento.setBounds(174, 150, 312, 29);
		lblDataDeNascimento.setForeground(Color.BLACK);
		lblDataDeNascimento.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		panel_3.add(lblDataDeNascimento);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Dia", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26", "27", "28", "29", "30", "31"}));
		comboBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox.setBounds(172, 178, 59, 29);
		panel_3.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"Mês", "Janeiro", "Fevereiro", "Março", "Abril", "Maio", "Junho", "Julho", "Agosto", "Setembro", "Outubro", "Novembro", "Dezembro"}));
		comboBox_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1.setBounds(232, 178, 152, 29);
		panel_3.add(comboBox_1);
		
		JComboBox comboBox_1_1 = new JComboBox();
		comboBox_1_1.setModel(new DefaultComboBoxModel(new String[] {"Ano", "1910", "1911", "1912", "1913", "1914", "1915", "1916", "1917", "1918", "1919", "1920", "1921", "1922", "1923", "1924", "1925", "1926", "1927", "1928", "1929", "1930", "1931", "1932", "1933", "1934", "1935", "1936", "1937", "1938", "1939", "1940", "1941", "1942", "1943", "1944", "1945", "1946", "1947", "1948", "1949", "1950", "1951", "1952", "1953", "1954", "1955", "1956", "1957", "1958", "1959", "1960", "1961", "1962", "1963", "1964", "1965", "1966", "1967", "1968", "1969", "1970", "1971", "1972", "1973", "1974", "1975", "1976", "1977", "1978", "1979", "1980", "1981", "1982", "1983", "1984", "1985", "1986", "1987", "1988", "1989", "1990", "1991", "1992", "1993", "1994", "1995", "1996", "1997", "1998", "1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010", "2011", "2012", "2013", "2014", "2015", "2016", "2017", "2018", "2019", "2020", "2021", "2022", "2023"}));
		comboBox_1_1.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		comboBox_1_1.setBounds(386, 178, 100, 29);
		panel_3.add(comboBox_1_1);
		
		JComboBox sexoBox = new JComboBox();
		sexoBox.setModel(new DefaultComboBoxModel(new String[] {"Masculino", "Feminino"}));
		sexoBox.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		sexoBox.setBounds(10, 179, 134, 29);
		panel_3.add(sexoBox);
		
		JLabel lblNewLabel_2_1_4 = new JLabel("Sexo *");
		lblNewLabel_2_1_4.setForeground(Color.BLACK);
		lblNewLabel_2_1_4.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_4.setBounds(10, 150, 127, 29);
		panel_3.add(lblNewLabel_2_1_4);
		
		JLabel lblNewLabel_2_1_3 = new JLabel("Contato *");
		lblNewLabel_2_1_3.setForeground(Color.BLACK);
		lblNewLabel_2_1_3.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_3.setBounds(10, 218, 313, 29);
		panel_3.add(lblNewLabel_2_1_3);
		
		txtCarteira = new JFormattedTextField();
		txtCarteira.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtCarteira.setBounds(9, 246, 477, 29);
		panel_3.add(txtCarteira);
		txtCarteira.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 371, 507, 155);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_2_1_2_1 = new JLabel("Convênio");
		lblNewLabel_2_1_2_1.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_1.setBounds(10, 11, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_1);
		
		txtConvenio = new JTextField();
		txtConvenio.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtConvenio.setBounds(10, 41, 487, 29);
		panel_1.add(txtConvenio);
		txtConvenio.setColumns(10);
		
		JLabel lblNewLabel_2_1_2_2 = new JLabel("Nº Carteira");
		lblNewLabel_2_1_2_2.setForeground(Color.BLACK);
		lblNewLabel_2_1_2_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		lblNewLabel_2_1_2_2.setBounds(10, 81, 315, 29);
		panel_1.add(lblNewLabel_2_1_2_2);
		
		txtContato = new JFormattedTextField();
		txtContato.setFont(new Font("Yu Gothic UI", Font.PLAIN, 15));
		txtContato.setBounds(10, 112, 487, 29);
		panel_1.add(txtContato);
		txtContato.setColumns(10);
		
		JButton btnAtualizar = new JButton("Atualizar");
		btnAtualizar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnAtualizar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String prontuario = txtProntuario.getText().replace("", "");
				if (prontuario == null || prontuario.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo PRONTUARIO está vazio");
				} else {
					pacienteSelecionado.setProntuario(Integer.valueOf(prontuario));
				}
				String nome = txtNome.getText();
				if (nome == null || nome.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NOME está vazio");
				} else {
					pacienteSelecionado.setnomeCompleto(nome);
				}
				String cpf = txtCpf.getText().replace(".", "").replace("-", "");
				if (cpf == null || cpf.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CPF está vazio");
				} else {
					pacienteSelecionado.setCpf(Long.valueOf(cpf));
				}
				String carteira = txtCarteira.getText();
				if (carteira == null || carteira.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo NUMERO CARTEIRA está vazio");
				} else {
					pacienteSelecionado.setnCarteira(carteira);
				}
				String contato = txtContato.getText().replace("(", "").replace(")", "").replace("+", "").replace("-", "");
				if (contato == null || contato.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONTATO está vazio");
				} else {
					pacienteSelecionado.setContato(contato);
				}
				String convenio = txtConvenio.getText();
				if (convenio == null || convenio.isEmpty()) {
					JOptionPane.showMessageDialog(null, "O campo CONVENIO está vazio");
				} else {
					pacienteSelecionado.setConvenio(convenio);
				}
				String sexo = sexoBox.getSelectedItem().toString();
					pacienteSelecionado.setSexo(sexo);

				CDao tablePacientes = CDao.getInstancia();
				boolean update = tablePacientes.update(pacienteSelecionado);
				if (update == true) {
					JOptionPane.showMessageDialog(null, "Cadastro atualizado");

					txtProntuario.setText(null);
					txtNome.setText(null);
					txtCpf.setText(null);
					txtCarteira.setText(null);
					txtContato.setText(null);
					txtConvenio.setText(null);
					sexoBox.setSelectedItem("Masculino");
					
					dispose();
					TelaPaciente frame = new TelaPaciente();
					frame.setVisible(true);
				}else {
					JOptionPane.showMessageDialog(null, "Erro ao atualizar os dados");
				}
			}
		});
		btnAtualizar.setBounds(10, 544, 163, 37);
		contentPane.add(btnAtualizar);
		
		JButton btnVoltar = new JButton("Voltar");
		btnVoltar.setFont(new Font("Yu Gothic UI", Font.BOLD, 15));
		btnVoltar.setBounds(428, 544, 89, 37);
		contentPane.add(btnVoltar);
		
		if(this.pacienteSelecionado != null) {
			txtProntuario.setText(String.valueOf(this.pacienteSelecionado.getProntuario()));
			txtNome.setText(this.pacienteSelecionado.getnomeCompleto());
			txtCpf.setText(String.valueOf(this.pacienteSelecionado.getCpf()));
			txtCarteira.setText(this.pacienteSelecionado.getnCarteira());
			txtContato.setText(this.pacienteSelecionado.getContato());
			txtConvenio.setText(this.pacienteSelecionado.getConvenio());
			sexoBox.setSelectedItem(this.pacienteSelecionado.getSexo());
		}
	}
}
