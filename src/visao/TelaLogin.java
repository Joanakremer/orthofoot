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

public class TelaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
	private JTextField usertxt;
	private JPasswordField senhatxt;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaLogin() {
		setUndecorated(true);
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 1306, 698);
		contentPane = new JPanel();
		contentPane.setBorder(null);
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(95, 158, 160));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		// Panel
		// ----------------------------------------------------------------------------------------------------------------------

		JPanel panel = new JPanel();
		panel.setBorder(null);
		panel.setEnabled(false);
		panel.setBackground(Color.WHITE);
		panel.setBounds(0, 0, 663, 709);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/aviso.png")));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_4.setBounds(84, 178, 500, 340);
		panel.add(lblNewLabel_4);

		JPanel Username = new JPanel();
		Username.setBackground(Color.WHITE);
		Username.setBounds(736, 239, 504, 40);
		contentPane.add(Username);
		Username.setLayout(null);

		JPanel senha = new JPanel();
		senha.setBackground(Color.WHITE);
		senha.setBounds(736, 318, 504, 40);
		contentPane.add(senha);
		senha.setLayout(null);

		// Text Field
		// ------------------------------------------------------------------------------------------------------------------

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
		usertxt.setFont(new Font("Arial", Font.BOLD, 18));
		usertxt.setBorder(null);
		usertxt.setText("Usuário");
		usertxt.setBounds(10, 11, 420, 18);
		Username.add(usertxt);
		usertxt.setColumns(10);

		senhatxt = new JPasswordField();
		senhatxt.setDisabledTextColor(Color.BLACK);
		senhatxt.addFocusListener(new FocusAdapter() {
			public void focusGained(FocusEvent e) {
				if (senhatxt.getText().equals("Senha")) {
					senhatxt.setText("");
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
		senhatxt.setFont(new Font("Arial", Font.BOLD, 18));
		senhatxt.setText("Senha");
		senhatxt.setToolTipText("Passord");
		senhatxt.setBorder(null);
		senhatxt.setBounds(10, 11, 440, 18);
		senha.add(senhatxt);

		// Label
		// -------------------------------------------------------------------------------------------------------------------

		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setBounds(440, 0, 64, 40);
		Username.add(lblNewLabel_1_1);
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/usuarios.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(440, 0, 64, 40);
		senha.add(lblNewLabel_1);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/trancar (1).png")));

		JLabel lblNewLabel = new JLabel("Seu usuário ou senha estão incorretos.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Arial", Font.PLAIN, 14));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(736, 369, 249, 20);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/remover.png")));
		lblNewLabel_2.setBounds(985, 369, 31, 20);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		lblNewLabel_2.setVisible(false);

		// Button
		// --------------------------------------------------------------------------------------------------------------------

		JButton loginbt = new JButton("Login");
		loginbt.setFocusPainted(false);
		loginbt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Login
				// --------------------------------------------------------------------------------------------------------------------

				String senha = senhatxt.getText();
				String username = usertxt.getText();

				CDaoUsuario dao = new CDaoUsuario();
				MUsuario usuario = dao.efetuarLogin(username, senha);
				if (usuario != null) {
					if (usuario.getLogin().equals(username) && usuario.getSenha().equals(senha)) {
						// sucesso
						dispose();
						TelaPrincipal telaPrincipal = new TelaPrincipal(usuario);
						telaPrincipal.setVisible(true);
					} else {
						JOptionPane.showMessageDialog(null, "Erro ao efetuar login");
					}
				}

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
		loginbt.setForeground(Color.BLACK);
		loginbt.setBackground(Color.WHITE);
		loginbt.setFont(new Font("Arial", Font.BOLD, 18));
		loginbt.setBounds(861, 437, 266, 40);
		contentPane.add(loginbt);

		JButton sairbt = new JButton("");
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
		sairbt.setBorder(null);
		sairbt.setBackground(Color.WHITE);
		sairbt.setBounds(1249, 11, 47, 33);
		contentPane.add(sairbt);
	}

}
