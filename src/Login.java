
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Login extends JFrame {

	private JPanel contentPane;



	private JLabel labelUsuario;
	private JLabel labelContraseña;
	private JLabel labelLogo;
	
	
	
	private JButton botonValidar;
	private JButton botonAtras;

	private String contenidoCaja1="";
	private String contenidoCaja2="";
	
	private GestorBaseDatos gbd= new GestorBaseDatos();
	private JPasswordField cajaContrasena;
	private JTextField cajaUsuario;
	
	
	
	
	
	public Login() {

		contentPane = new JPanel();
		
		labelUsuario = new JLabel("Usuario");
		labelContraseña = new JLabel("Contraseña");
		labelLogo = new JLabel("");
		
		cajaUsuario = new JTextField();
		cajaContrasena = new JPasswordField();
		cajaContrasena.setFont(new Font("Tahoma", Font.PLAIN, 23));
		
		botonValidar = new JButton("Validar");
		botonAtras = new JButton("Atras");
		
		
		

		

		botonValidar.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent actionEvent) {
						
		if (gbd.conectar())
				{
				
				contenidoCaja1= cajaUsuario.getText().toString();
				contenidoCaja2= cajaContrasena.getText().toString();
				
				if (gbd.validar(contenidoCaja1, contenidoCaja2))
				    {
					
					JOptionPane.showMessageDialog(null,"Bienvenido al sistema");
					dispose();
					new Inicio();
					
				      }
				else
				      {
					JOptionPane.showMessageDialog(null,"Usuario o Contraseña Incorrectos");
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

		cajaUsuario.setFont(new Font("Tahoma", Font.PLAIN, 23));
		cajaUsuario.setBounds(150, 315, 230, 53);
		contentPane.add(cajaUsuario);
		cajaUsuario.setColumns(10);


		

		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(312, 0, 489, 290);
		contentPane.add(labelLogo);
		
		botonValidar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonValidar.setBounds(406, 389, 159, 55);
		contentPane.add(botonValidar);
		
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonAtras.setBounds(798, 485, 159, 55);
		contentPane.add(botonAtras);
		setVisible(true);
		
		
		cajaContrasena.setBounds(645, 313, 230, 53);
		contentPane.add(cajaContrasena);
		
		
		
	
	}
}
