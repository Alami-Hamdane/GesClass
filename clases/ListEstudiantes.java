
import javax.swing.*;
import javax.swing.border.LineBorder;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Vector;

public class ListEstudiantes extends JFrame implements ActionListener {
	
  private JLabel label1;
  private JPanel panel1,panel2,panel3;
  private JTable table;
  private Vector<String> columnas;
  private Vector <String> tuple;
  private Vector <Vector>  lineas;
  ResultSet rs = null;
  private JButton botonAtras;
  
  
  

public ListEstudiantes(String curso,String nivel){
	setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Worckspace2020\\GesClass2\\GesClass.jpg"));
	
	
    ArrayList<Estudiante> estudiantes = new ArrayList<>();
  
    
    try {

        Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/gestionestudiantes", "root", "");

        String query = "SELECT * FROM estudiante";

        Statement sta = connection.createStatement();
        rs = sta.executeQuery(query);

        while (rs.next()){
            Estudiante e = new Estudiante();
            e.setNumeroDni(rs.getString("dniEstudiante"));
            e.setApellidos(rs.getString("nombreEstudiante"));
            e.setNombre(rs.getString("apellidosEstudiante"));
            e.setCurso(new Curso(rs.getString("cursoEstudiante")));
            e.setNivel(new Nivel(rs.getString("nivelEstudiante")));
            
            if (e.getNivel().getNombreNivel().equalsIgnoreCase(nivel) || e.getCurso().getNombreCurso().equalsIgnoreCase(curso)){
            	
                estudiantes.add(e);
            }

        }


    } catch (Exception exception) {
        exception.printStackTrace();
    }
   
    
    label1=new JLabel("Lista de estudiantes del Curso/Nivel  :"  +curso.toUpperCase()+ " " +nivel.toUpperCase());
    panel1=new JPanel();
    panel2=new JPanel();
  
    columnas = new Vector<String>();
    columnas.add("Número DNI");
    columnas.add("Nombre");
    columnas.add("Apellidos");
    columnas.add("Cursos");
    columnas.add("Niveles");
    
    lineas = new Vector <Vector>();
    
    for (int i=0;i<estudiantes.size();i++){
        
    	tuple = new Vector<String>();
    	
        Estudiante estudiante = estudiantes.get(i);
        
        tuple.add(estudiante.getNumeroDni());
        tuple.add(estudiante.getApellidos());
        tuple.add(estudiante.getNombre());
        tuple.add(estudiante.getCurso().getNombreCurso());
        tuple.add(estudiante.getNivel().getNombreNivel());
        
        lineas.add(tuple);
    }
    
    
    SpringLayout sl_panel2 = new SpringLayout();
    
    
    table = new JTable(lineas,columnas);
    table.setRowHeight(40);
    JScrollPane scrollPane = new JScrollPane(table,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS, ScrollPaneConstants.HORIZONTAL_SCROLLBAR_AS_NEEDED);
    panel3=new JPanel();
   
    botonAtras = new JButton("Atras");
    botonAtras.addActionListener(new ActionListener() {
    	public void actionPerformed(ActionEvent e) {
    		
    		 dispose();
             new Inicio();
    	}
    });
    setVisible(true);



  
    
    
    // Configuración Grafica 
    
    label1.setFont(new Font("Tahoma", Font.BOLD, 13));
    
    panel1.setBackground(new Color(176, 196, 222));
    panel1.add(label1);
    
    panel2.setBackground(new Color(176, 196, 222));
    panel2.setBorder(new LineBorder(new Color(255, 255, 255), 0));
    
    
    panel2.setLayout(sl_panel2);
    
    
    sl_panel2.putConstraint(SpringLayout.NORTH, scrollPane, 20, SpringLayout.NORTH, panel2);
    sl_panel2.putConstraint(SpringLayout.WEST, scrollPane, 33, SpringLayout.WEST, panel2);
    sl_panel2.putConstraint(SpringLayout.SOUTH, scrollPane, 480, SpringLayout.NORTH, panel2);
    sl_panel2.putConstraint(SpringLayout.EAST, scrollPane, -27, SpringLayout.EAST,panel2);
    scrollPane.setBorder(new LineBorder(UIManager.getColor("Tabla.highlight")));
    panel2.add(scrollPane);
    
    
    panel3.setBackground(new Color(176, 196, 222));
    
    
    getContentPane().add(panel1,BorderLayout.NORTH);
    getContentPane().add(panel2,BorderLayout.CENTER);
    getContentPane().add(panel3,BorderLayout.SOUTH);
    
    
    panel3.add(botonAtras);

    setBounds(150, 140, 1000, 590);
    setResizable(false);
    setTitle("Lista De Estudiantes");
    
    
    
}

@Override
public void actionPerformed(ActionEvent e)
{

}
}
