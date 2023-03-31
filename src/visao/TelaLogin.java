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
import javax.swing.BorderFactory;
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
import componentesVisuais.HintPasswordField;
import componentesVisuais.HintTextField;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;

public class TelaLogin extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaLogin frame = new TelaLogin();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
				
			}
		});
	}

	public TelaLogin() {
		setBackground(new Color(32, 178, 170));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(90, 90, 495, 665);
		contentPane = new JPanel();
		contentPane.setForeground(Color.BLACK);
		contentPane.setBackground(new Color(255, 255, 255));
		setContentPane(contentPane);
		contentPane.setLayout(null);

//Text Field ------------------------------------------------------------------------------------------------------------------

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/trancar_32.png")));
		lblNewLabel_1.setBounds(366, 357, 53, 48);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("");
		lblNewLabel_1_1.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/usuario_24.png")));
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
		lblNewLabel_1_1.setBounds(366, 247, 53, 48);
		contentPane.add(lblNewLabel_1_1);
		
		HintPasswordField senhatxt = new HintPasswordField("Senha"); 
		senhatxt.setText("Senha");
		senhatxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				senhatxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(95, 158, 160)));
				lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(95, 158, 160)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				senhatxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
				lblNewLabel_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
			}
		});
		senhatxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		senhatxt.setBounds(64, 357, 307, 48);
		contentPane.add(senhatxt);
		senhatxt.setColumns(10);
		
		HintTextField usertxt = new HintTextField("Usuário");
		usertxt.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				usertxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(95, 158, 160)));
				lblNewLabel_1_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(95, 158, 160)));
			}
			@Override
			public void focusLost(FocusEvent e) {
				usertxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
				lblNewLabel_1_1.setBorder(new MatteBorder(0, 0, 1, 0, (Color) Color.BLACK));
			}
		});
		usertxt.setBorder(new MatteBorder(0, 0, 1, 0, (Color) new Color(0, 0, 0)));
		usertxt.setColumns(10);
		usertxt.setBounds(64, 247, 307, 48);
		contentPane.add(usertxt);

		JLabel lblNewLabel = new JLabel("Seu usuário ou senha estão incorretos.");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setFont(new Font("Dialog", Font.PLAIN, 16));
		lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel.setBounds(91, 416, 280, 16);
		contentPane.add(lblNewLabel);
		lblNewLabel.setVisible(false);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/remover.png")));
		lblNewLabel_2.setBounds(64, 416, 21, 16);
		contentPane.add(lblNewLabel_2);
		setLocationRelativeTo(null);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setIcon(new ImageIcon(TelaLogin.class.getResource("/imagens/logo media.png")));
		lblNewLabel_3.setBounds(70, 41, 355, 112);
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
		loginbt.setBounds(64, 496, 355, 40);
		contentPane.add(loginbt);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(95, 158, 160));
		panel.setBounds(0, 51, 66, 94);
		contentPane.add(panel);
		
		

		
	}
}
