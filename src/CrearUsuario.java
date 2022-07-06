import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;



    public class CrearUsuario extends JFrame {
    	
    	
    	private JPanel contentPane;
    	
    	private JTextField cajaTextoUsuario;
    	private JTextField cajaTextoContrasena;
    	private JTextField cajaTextoBorrar;
    	
    	private JButton botonAnadir;
    	private JButton botonAtras;
    	private JButton botonBorrar;
    	private JButton botonListaUsuarios;

    	
    	private JLabel labelNuevoUsuario;
    	private JLabel labelUsuario;
    	private JLabel labelContrasena;
    	
    	private GestorBaseDatos gbd= new GestorBaseDatos();
    	private String contenidoCajaUsuario="";
    	private String contenidoCajaPassword="";
    	
    	
    	
    	private boolean result=false;
    	private JLabel labelLogo_1;
    	
    	
    	ResultSet rs = null;
    	Usuario usuario =new Usuario();
    	private JTextField textField;
    	
    	
    	
	
	
	
	
	
	
	
	public CrearUsuario() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));

		
		
		contentPane = new JPanel();
		
		labelNuevoUsuario = new JLabel("Nuevo Usuario");
		labelUsuario = new JLabel("Nuevo USUARIO");	
		labelContrasena = new JLabel("Contraseña");
		
		cajaTextoUsuario = new JTextField();
		cajaTextoContrasena = new JTextField();
		cajaTextoBorrar = new JTextField();
		
	    botonAnadir = new JButton("Añadir");
		botonAtras = new JButton("Atras");
		botonBorrar = new JButton("Borrar Usuario");
		botonListaUsuarios = new JButton("Lista Usuarios");
		
		
		
		

		botonAnadir.addActionListener(new ActionListener() {
			@Override
			    public void actionPerformed(ActionEvent e) {
			  
			        	
			    	contenidoCajaUsuario=cajaTextoUsuario.getText().toString();
			    	contenidoCajaPassword=cajaTextoContrasena.getText().toString();
			    	
			    	
					
					result=gbd.crearUsuario(contenidoCajaUsuario,contenidoCajaPassword, "usuarios");
					
					
									
					
					
					
					
					if (!result)
					{
						JOptionPane.showMessageDialog(botonAnadir, "Has añadido un nuevo Usuario : " + contenidoCajaUsuario.toUpperCase());
						
						cajaTextoUsuario.setText("");
						cajaTextoContrasena.setText("");
								
					}
					else
					{
						JOptionPane.showMessageDialog(botonAnadir, "Este usuario ya existe en la base de datos");
					}
					
				
				
				
				
			}
		});
		
		
		botonListaUsuarios.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				
				
				
				dispose();
		        
		        
				
			
			
				new ListUsuarios("SELECT * FROM usuarios");
			
				
				
				 
			}
		});
		
		
		
		
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
			
		        		        
				String contenidoCajaBorrar = cajaTextoBorrar.getText().toString();
		
				result =gbd.borrarUsuario(contenidoCajaBorrar,"usuarios");
				
				
				if (result==true)

				{
					JOptionPane.showMessageDialog(null, "no ha sido posible borrar el usuario : " + contenidoCajaBorrar.toUpperCase());
					
				} 
				
				else
				{
					JOptionPane.showMessageDialog(null, "Has borrado correctamente el usuario  : " + contenidoCajaBorrar.toUpperCase());

				}
				
				
				cajaTextoBorrar.setText("");
			
				
				
				
				
				
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
		setTitle("Crear Curso");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 140, 1000, 590);
		setResizable(false);
		
		labelNuevoUsuario.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelNuevoUsuario.setBounds(424, 55, 325, 50);
		contentPane.add(labelNuevoUsuario);

		labelContrasena.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelContrasena.setBounds(45, 271, 177, 43);
		contentPane.add(labelContrasena);
		
		
		cajaTextoContrasena.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cajaTextoContrasena.setBounds(232, 265, 545, 60);
		contentPane.add(cajaTextoContrasena);
		cajaTextoContrasena.setColumns(10);
		setVisible(true);
		
		botonAnadir.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadir.setBounds(232, 336, 259, 60);
		contentPane.add(botonAnadir);
		

		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAtras.setBounds(805, 467, 169, 50);
		contentPane.add(botonAtras);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(0, 0, 300, 183);
		contentPane.add(labelLogo);
		
		
		cajaTextoUsuario.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cajaTextoUsuario.setColumns(10);
		cajaTextoUsuario.setBounds(232, 194, 545, 60);
		contentPane.add(cajaTextoUsuario);
		
		
		labelUsuario.setFont(new Font("Tahoma", Font.PLAIN, 24));
		labelUsuario.setBounds(45, 200, 177, 43);
		contentPane.add(labelUsuario);
		
		
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonBorrar.setBounds(20, 462, 202, 60);
		contentPane.add(botonBorrar);
		
		
		cajaTextoBorrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cajaTextoBorrar.setColumns(10);
		cajaTextoBorrar.setBounds(232, 462, 545, 60);
		contentPane.add(cajaTextoBorrar);
		
		
		botonListaUsuarios.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonListaUsuarios.setBounds(518, 336, 259, 60);
		contentPane.add(botonListaUsuarios);
		
		
		
			
		
	}
}
