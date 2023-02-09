package visao;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import java.awt.Panel;
import javax.swing.JTextField;
import java.awt.Component;
import javax.swing.Box;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JCheckBox;
import java.awt.Dimension;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.SystemColor;
import javax.swing.ImageIcon;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TelaLogin extends JFrame {

	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField senhatxt;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
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
	public TelaLogin() {
		setUndecorated(true);
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 1306, 698);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(95, 158, 160));
		contentPane.setBorder(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 653, 698);
		contentPane.add(panel);
		
		JPanel login = new JPanel();
		login.setBackground(Color.WHITE);
		login.setBounds(736, 239, 504, 40);
		contentPane.add(login);
		login.setLayout(null);
		
		usertxt = new JTextField();
		usertxt.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if(usertxt.getText().equals("Username")) {
					usertxt.setText("");
				}else {
					usertxt.selectAll();
				}
			}
		});
		
		
		usertxt.setFont(new Font("Arial", Font.PLAIN, 18));
		usertxt.setBorder(null);
		usertxt.setText("Username");
		usertxt.setBounds(10, 11, 420, 18);
		login.add(usertxt);
		usertxt.setColumns(10);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(440, 0, 64, 40);
		login.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/usuarios.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel senha = new JPanel();
		senha.setBackground(Color.WHITE);
		senha.setBounds(736, 318, 504, 40);
		contentPane.add(senha);
		senha.setLayout(null);
		
		senhatxt.setFont(new Font("Arial", Font.PLAIN, 18));
		senhatxt.setBorder(null);
		senhatxt.setEchoChar((char)0);
		senhatxt.setText("Password");
		senhatxt.setBounds(10, 11, 403, 18);
		senha.add(senhatxt);
		
		senhatxt = new JPasswordField();
		senhatxt.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent arg0) {
				if(senhatxt.getText().equals("Password")) {
					senhatxt.setEchoChar('●');
					senhatxt.setText("");
				}else {
					senhatxt.selectAll();
				}
				
			}
		});
		
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(440, 0, 64, 40);
		senha.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/trancar (1).png")));
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(850, 465, 296, 40);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setForeground(new Color(95, 158, 160));
		lblNewLabel.setFont(new Font("Arial", Font.BOLD, 16));
		lblNewLabel.setBounds(10, 11, 276, 18);
		panel_1.add(lblNewLabel);
		
		JPanel sair = new JPanel();
		sair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TelaLogin.this.dispose();
			}
			
		});
		sair.setBounds(1256, 11, 40, 45);
		contentPane.add(sair);
		sair.setLayout(null);
		
		JLabel lblsair = new JLabel("");
		lblsair.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TelaLogin.this.dispose();
			}
	
			
			
		});
		lblsair.setBounds(6, 6, 30, 34);
		sair.add(lblsair);
		lblsair.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblsair.setHorizontalAlignment(SwingConstants.CENTER);
		lblsair.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/sair-alt.png")));
		setLocationRelativeTo(null);
	}
}
