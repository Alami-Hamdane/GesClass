
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;


    public class CrearCurso extends JFrame {
    	
    	
	private JPanel contentPane;
	
	private JTextField CajaTextoCurso;
	private JTextField cajaTextoBorrar;
	
	
	
	private JButton botonAnadir;
	private JButton botonAtras;
	private JButton botonListaCursos;
	private JButton botonBorrar;
	
	private JLabel labelNuevoCurso;
	
	private GestorBaseDatos gbd= new GestorBaseDatos();
	
	private String contenidoCaja="";
	
    private boolean result=false;
	
    ResultSet rs = null;
	Curso curso =new Curso();
	
	
	
	
	
	
	
	public CrearCurso() {
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));

		
		
		contentPane = new JPanel();
		
		labelNuevoCurso = new JLabel("Nuevo Curso");
		
		CajaTextoCurso = new JTextField();
		cajaTextoBorrar = new JTextField();
		
		botonAnadir = new JButton("Añadir");
		botonListaCursos = new JButton("Lista Cursos");
		botonBorrar = new JButton("Borrar");
		botonAtras = new JButton("Atrás");
		
		
		
		

		botonAtras.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				 dispose();
	                new Inicio();
				
			}
		});
		
		
		
		
		botonAnadir.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent actionEvent) {
    		
    		
			contenidoCaja=CajaTextoCurso.getText().toString();
						
			result=gbd.crearCurso(contenidoCaja, "curso");
			
			
			
			
			
			if (!result)
			{
				JOptionPane.showMessageDialog(null, "Has añadido un nuevo curso : " + contenidoCaja.toUpperCase());
				CajaTextoCurso.setText("");
				
			}
			else
			{
				JOptionPane.showMessageDialog(null, "No ha sido posible añadir el nuevo curso");
			}
			
						
				
				
			}
		});
		
		
		
		
		
		
		botonListaCursos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			dispose();
					        		
			new ListCursos("SELECT * FROM cursos");
				
				
			}
		});
		
		
		
		
		
		botonBorrar.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				
				
				
				String contenidoNombreCurso = cajaTextoBorrar.getText().toString();
				
				result =gbd.borrarCurso(contenidoNombreCurso,"curso");
				
				
				if (result==true)

				{
					JOptionPane.showMessageDialog(null, "no ha sido posible borrar el curso : " + contenidoNombreCurso.toUpperCase());
					
				} 
				
				else
				{
					JOptionPane.showMessageDialog(null, "Has borrado correctamente el curso  : " + contenidoNombreCurso.toUpperCase());

				}
				
				
				cajaTextoBorrar.setText("");
				
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
		
		labelNuevoCurso.setFont(new Font("Times New Roman", Font.BOLD, 32));
		labelNuevoCurso.setBounds(424, 55, 325, 50);
		contentPane.add(labelNuevoCurso);
		
		
		CajaTextoCurso.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CajaTextoCurso.setBounds(309, 328, 440, 60);
		contentPane.add(CajaTextoCurso);
		CajaTextoCurso.setColumns(10);
		setVisible(true);
		
		botonAnadir.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAnadir.setBounds(10, 326, 259, 60);
		contentPane.add(botonAnadir);
		

		botonAtras.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonAtras.setBounds(773, 490, 185, 50);
		contentPane.add(botonAtras);
		
		JLabel labelLogo = new JLabel("");
		labelLogo.setIcon(new ImageIcon("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
		labelLogo.setBounds(0, 0, 300, 183);
		contentPane.add(labelLogo);
		
		
		botonListaCursos.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonListaCursos.setBounds(10, 258, 259, 60);
		contentPane.add(botonListaCursos);
		
		
		cajaTextoBorrar.setFont(new Font("Tahoma", Font.PLAIN, 20));
		cajaTextoBorrar.setColumns(10);
		cajaTextoBorrar.setBounds(309, 409, 440, 60);
		contentPane.add(cajaTextoBorrar);
		
		
		botonBorrar.setFont(new Font("Tahoma", Font.BOLD, 22));
		botonBorrar.setBounds(10, 407, 259, 60);
		contentPane.add(botonBorrar);
		
		
		
			
		
	}
	
	
}
