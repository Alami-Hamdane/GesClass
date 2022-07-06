import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Bienvenido extends JFrame {

	private JPanel contentPane;
	private JLabel labelLogo;
	
	
	
	private JButton botonAdmin;
	private JButton botonSalir;
	private JButton botonUsuario;

	
	
	public Bienvenido() {

		contentPane = new JPanel();
		labelLogo = new JLabel("");
		
		botonAdmin = new JButton("ADMIN");
		botonSalir = new JButton("Salir");
		botonUsuario = new JButton("USUARIO");
		
			
				
		
		
		botonUsuario.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
							
				dispose();
				new Login();		
				
				
			}
		});

		botonAdmin.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
								
			dispose();
				new LoginAdmin();			
				
				
			}
		});
		
		
	
		
		botonSalir.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					
		
				
				int resp=JOptionPane.showConfirmDialog(null,"Vas a salir del programa?","CONFIRMACIÓN", JOptionPane.WARNING_MESSAGE);
			      if (JOptionPane.OK_OPTION == resp){
			   
			   System.exit(0);
			 }
			      else{
			    
			    	  new Bienvenido();	
			   }
				
				
			
			
			}
		});
		
		
		
		
		// Configuración Grafica

		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		setTitle("Bienvenido");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 140, 1000, 590);
		setResizable(false);


		botonAdmin.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAdmin.setBounds(40, 326, 159, 55);
		contentPane.add(botonAdmin);
		setVisible(true);

		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(346, 44, 476, 346);
		contentPane.add(labelLogo);
				
		
		botonSalir.setFont(new Font("Tahoma", Font.BOLD, 20));
		botonSalir.setBounds(791, 485, 159, 55);
		contentPane.add(botonSalir);
		
		
		botonUsuario.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonUsuario.setBounds(40, 416, 159, 55);
		contentPane.add(botonUsuario);
		setVisible(true);
		
	
		
	}
	
	
	
}
