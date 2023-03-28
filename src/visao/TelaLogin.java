package visao;

import java.awt.Color; 
import java.awt.Cursor;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controle.CDaoUsuario;
import modelo.MUsuario;
import javax.swing.border.BevelBorder;
import javax.swing.border.MatteBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.SoftBevelBorder;
import javax.swing.border.TitledBorder;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class TelaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField usertxt;
	private JPasswordField senhatxt;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setExtendedState(MAXIMIZED_BOTH);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public TelaLogin() {
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 469, 625);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
//Panel--------------------------------------------------------------------------------------------------------------------------

		JPanel Username = new JPanel();
		Username.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		Username.setBackground(Color.WHITE);
		Username.setBounds(56, 271, 355, 40);
		contentPane.add(Username);
		Username.setLayout(null);

		JPanel senha = new JPanel();
		senha.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		senha.setBackground(Color.WHITE);
		senha.setBounds(56, 348, 355, 40);
		contentPane.add(senha);
		senha.setLayout(null);

//Text Field ------------------------------------------------------------------------------------------------------------------

		usertxt = new JTextField();
		usertxt.setDisabledTextColor(Color.BLACK);
		usertxt.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (usertxt.getText().equals("Usuário")) {
					usertxt.setText("");
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (usertxt.getText().equals("")) {
					usertxt.setText("Usuário");
				}
			}
		});
		usertxt.setFont(new Font("Dialog", Font.PLAIN, 18));
		usertxt.setBorder(null);
		usertxt.setText("Usuário");
		usertxt.setBounds(2, 7, 314, 27);
		Username.add(usertxt);
		usertxt.setColumns(10);
		
		senhatxt = new JPasswordField();
		senhatxt.setDisabledTextColor(Color.BLACK);
		senhatxt.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (senhatxt.getText().equals("Senha")) {
					senhatxt.setText("");
					senhatxt.setFont(new Font("Dialog", Font.PLAIN, 12));
					senhatxt.setEchoChar('●');
				}
			}

			@Override
			public void focusLost(FocusEvent e) {
				if (senhatxt.getText().isEmpty()) {
					senhatxt.setText("Senha");
				}
			}
		});
		senhatxt.setEchoChar((char) 0);
		senhatxt.setFont(new Font("Dialog", Font.PLAIN, 18));
		senhatxt.setText("Senha");
		senhatxt.setBorder(null);
		senhatxt.setBounds(1, 9, 314, 27);
		senha.add(senhatxt);
		
				JLabel lblNewLabel_1 = new JLabel("");
				lblNewLabel_1.setBounds(321, 0, 34, 40);
				senha.add(lblNewLabel_1);
				lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
				lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/trancar (1).png")));

		
//Label -------------------------------------------------------------------------------------------------------------------
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(324, 0, 31, 40);
		Username.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/usuarios.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);


		JLabel lblNewLabel = new JLabel("Seu usuário ou senha estão incorretos.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(80, 403, 280, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/remover.png")));
		lblNewLabel_2.setBounds(53, 403, 21, 16);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/logo media.png")));
		lblNewLabel_3.setBounds(56, 77, 355, 112);
		contentPane.add(lblNewLabel_3);

//Button --------------------------------------------------------------------------------------------------------------------

		JButton loginbt = new JButton("Login");
		loginbt.setFocusPainted(false);
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String senha = senhatxt.getText();
				String username = usertxt.getText();

				CDaoUsuario dao = new CDaoUsuario();
				MUsuario usuario = dao.efetuarLogin(username, senha);
				if (usuario != null) {
					if (usuario.getLogin().equals(username) && usuario.getSenha().equals(senha)) {
						dispose();
						TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
						telaPrincipal.setVisible(true);
					} 
				}
				lblNewLabel.setVisible(true);
				lblNewLabel_2.setVisible(true);
			}
		});

		loginbt.addMouseListener(new MouseAdapter() {
			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		loginbt.setBorder(null);
		loginbt.setForeground(new Color(255, 255, 255));
		loginbt.setBackground(new Color(95, 158, 160));
		loginbt.setFont(new Font("Dialog", Font.BOLD, 19));
		loginbt.setBounds(56, 477, 355, 40);
		contentPane.add(loginbt);

		JButton sairbt = new JButton("");
		sairbt.setVisible(false);
		sairbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
			
		});
		sairbt.setFocusPainted(false);
		sairbt.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				TelaLogin.this.dispose();
			}

			public void mouseEntered(MouseEvent e) {
				setCursor(new Cursor(Cursor.HAND_CURSOR));
			}

			public void mouseExited(MouseEvent e) {
				setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}
		});
		sairbt.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/sair-alt.png")));
		sairbt.setBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(64, 128, 128)));
		sairbt.setBackground(Color.WHITE);
		sairbt.setBounds(408, 11, 35, 33);
		contentPane.add(sairbt);
		
	}
}
