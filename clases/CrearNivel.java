

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

    public class CrearNivel extends JFrame {
    	
    	
	private JPanel contentPane;
	
	private JTextField CajaTextoNivel;
	
	private JLabel labelNuevoNivel ;
	
	private JButton botonAnadir;
	private JButton botonAtras;
	private JButton botonListaNiveles;
	
	private GestorBaseDatos gbd= new GestorBaseDatos();
	
	private boolean result=false;
	private String contenidoCaja="";
	private JLabel labelLogo;
	private JTextField cajaTextoBorrar;
	private JButton botonBorrar;

	public CrearNivel() {
		
		contentPane = new JPanel();
		
		labelLogo = new JLabel("");
		labelNuevoNivel = new JLabel("Nuevo Nivel");
		
		CajaTextoNivel = new JTextField();
		cajaTextoBorrar = new JTextField();
		
		
		botonAnadir = new JButton("Añadir");
		botonAtras  = new JButton("Atrás");
		botonBorrar = new JButton("Borrar");
		botonListaNiveles = new JButton("Lista Niveles");
		
		

		botonAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				 dispose();
	                new Inicio();
			}
		});
		
		
		
		
		botonAnadir.addActionListener(new ActionListener() {
		
			
	@Override
		
	public void actionPerformed(ActionEvent actionEvent) {
				
		
				contenidoCaja=CajaTextoNivel.getText().toString();
				
				result=gbd.crearNivel(contenidoCaja, "nivelestudios");
				
				
				
				
				
				if (!result)
				{
					JOptionPane.showMessageDialog(null, "Has añadido un nuevo nivel : " + contenidoCaja.toUpperCase());
					
					CajaTextoNivel.setText("");
				}
				else
				{
					JOptionPane.showMessageDialog(null, "No ha sido posible añadir el nuevo nivel");
				}
				
				
			}
		});
		
		
		botonListaNiveles.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				dispose();
		        
		        
				
			
			new ListNiveles("SELECT * FROM niveles");
				
				
			}
		});
		
		
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
			
		        
		        
				String contenidoNombreNivel = cajaTextoBorrar.getText().toString();
				
				result =gbd.borrarNivel(contenidoNombreNivel,"nivelestudios");
				
				

				if (result==true)

				{
					JOptionPane.showMessageDialog(null, "no ha sido posible borrar el nivel : " + contenidoNombreNivel.toUpperCase());
					
				} 
				
				else
				{
					JOptionPane.showMessageDialog(null, "Has borrado correctamente el nivel  : " + contenidoNombreNivel.toUpperCase());

				}
				
				
				cajaTextoBorrar.setText("");
				
				
			}
		});
		
		
		
		
		
		// Configuración Grafica
		
		contentPane.setBackground(new Color(176, 196, 222));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		setTitle("Crear Nivel");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(150, 140, 1000, 590);
		setResizable(false);
		
		labelNuevoNivel.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelNuevoNivel.setBounds(424, 55, 325, 50);
		contentPane.add(labelNuevoNivel);
		
		CajaTextoNivel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CajaTextoNivel.setBounds(309, 328, 440, 60);
		contentPane.add(CajaTextoNivel);
		CajaTextoNivel.setColumns(10);
		setVisible(true);
		
		botonAnadir.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadir.setBounds(10, 326, 259, 60);
		contentPane.add(botonAnadir);

		
		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAtras.setBounds(773, 490, 185, 50);
		contentPane.add(botonAtras);
		
		
		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(0, 0, 300, 183);
		contentPane.add(labelLogo);
		
		
		botonListaNiveles.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonListaNiveles.setBounds(10, 258, 259, 60);
		contentPane.add(botonListaNiveles);
		
		
		cajaTextoBorrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cajaTextoBorrar.setColumns(10);
		cajaTextoBorrar.setBounds(309, 409, 440, 60);
		contentPane.add(cajaTextoBorrar);
		
		
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonBorrar.setBounds(10, 407, 259, 60);
		contentPane.add(botonBorrar);
	}
}
