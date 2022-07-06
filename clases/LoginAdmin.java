
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

public class LoginAdmin extends JFrame {

	private JPanel contentPane;

	private JTextField cajaLogin;

	private JLabel labelUsuario;
	private JLabel labelContraseña;
	private JLabel labelLogo;
	
	
	
	private JButton botonValidar;
	private JButton botonAtras;

	private String contenidoCaja1="";
	private String contenidoCaja2="";
	
	private GestorBaseDatos gbd= new GestorBaseDatos();
	private JPasswordField cajaPassword;
	
	
	
	
	
	
	public LoginAdmin() {

		contentPane = new JPanel();
		
		labelUsuario = new JLabel("Login");
		labelContraseña = new JLabel("Password");
		labelLogo = new JLabel("");
		
		cajaLogin = new JTextField();
		cajaPassword = new JPasswordField();
		cajaPassword.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		botonValidar = new JButton("Validar");
		botonAtras = new JButton("Atras");
		
		
		

		

		botonValidar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
						
		if (gbd.conectar())
				{
				
				contenidoCaja1= cajaLogin.getText().toString();
				contenidoCaja2= cajaPassword.getText().toString();
				
				if (gbd.validarAdmin(contenidoCaja1, contenidoCaja2))
				    {
					
					JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
					dispose();
					new CrearUsuario();
					
				      }
				else
				      {
					JOptionPane.showMessageDialog(null,"Login o Password Incorrectos");
				      }
				
			  }else
				{
					System.out.println("Error en la conexion");
				}
		
			}
		});
		
		botonAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					

				 dispose();
				 
	                new Bienvenido();
			
			}
		});
		
		
		
		
		// Configuración Grafica

		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		setTitle("Login");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 140, 1000, 590);
		setResizable(false);

		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelUsuario.setBounds(23, 313, 99, 53);
		contentPane.add(labelUsuario);

		labelContraseña.setFont(new Font("Tahoma", Font.PLAIN, 20));
		labelContraseña.setBounds(419, 315, 146, 53);
		contentPane.add(labelContraseña);

		cajaLogin.setFont(new Font("Tahoma", Font.PLAIN, 23));
		cajaLogin.setBounds(150, 315, 230, 53);
		contentPane.add(cajaLogin);
		cajaLogin.setColumns(10);


		

		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(312, 0, 489, 290);
		contentPane.add(labelLogo);
		
		botonValidar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonValidar.setBounds(406, 389, 159, 55);
		contentPane.add(botonValidar);
		
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonAtras.setBounds(799, 485, 159, 55);
		contentPane.add(botonAtras);
		setVisible(true);
		
		
		cajaPassword.setBounds(645, 313, 230, 53);
		contentPane.add(cajaPassword);
		
		
		
	
	}
}
