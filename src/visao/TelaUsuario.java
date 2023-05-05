package visao;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import java.awt.BorderLayout;
import java.awt.Color;

import net.miginfocom.swing.MigLayout;
import visaoCad.TelaCadastroMedico;

public class TelaUsuario extends JFrame {

	private JPanel contentPane;
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
		setBounds(100, 100, 993, 540);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(192, 192, 192));
		panel_1.setBounds(10, 11, 957, 53);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 84, 957, 53);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("USUÁRIO");
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.BOLD, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(316, 11, 304, 31);
		panel_1.add(lblNewLabel);
		
		btnNewButton = new JButton("Cadastrar Médico");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaCadastroMedico frame = null;
				frame = new TelaCadastroMedico();
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
			}
		});
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setFocusPainted(false);
		btnNewButton_1.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_1.setBounds(699, 11, 119, 31);
		panel.add(btnNewButton_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 154, 957, 294);
		contentPane.add(scrollPane);
		
		btnNewButton_2 = new JButton("Deletar");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
			}
		});
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setFocusPainted(false);
		btnNewButton_2.setFont(new Font("Yu Gothic UI", Font.BOLD, 14));
		btnNewButton_2.setBounds(828, 11, 119, 31);
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
		btnNewButton_3.setBounds(870, 459, 97, 31);
		contentPane.add(btnNewButton_3);
	}
}
