package visual;

import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.ListIterator;
 
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import trataJSON.UsuarioJSON;


import auxiliar.Auxiliar;
import beans.Proyecto;

public class VentanaUsuario extends JDialog {
 
    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private final JPanel contentPanel = new JPanel();
	private final JTextField nomUsuario, ap1Usuario, ap2Usuario;
    
    public VentanaUsuario() 
    {
        setResizable(false);
        setTitle("Nuevo Usuario");
        setBounds(100, 100, 450, 229);
        
        getContentPane().setLayout(new BorderLayout());
        contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
        getContentPane().add(contentPanel, BorderLayout.CENTER); 
        contentPanel.setLayout(null);
        {
        	JLabel lbNomUsuario = new JLabel("NOMBRE");
        	lbNomUsuario.setBounds(10, 10, 300, 25);
            contentPanel.add(lbNomUsuario);
            
            nomUsuario = new JTextField();            
            nomUsuario.setBounds(100, 10, 300, 25);
            contentPanel.add(nomUsuario);
            
            JLabel lbAp1Usuario = new JLabel("APELLIDO 1");            
            lbAp1Usuario.setBounds(10, 40, 300, 25);
            contentPanel.add(lbAp1Usuario);
            
            ap1Usuario = new JTextField();            
            ap1Usuario.setBounds(100, 40, 300, 25);
            contentPanel.add(ap1Usuario);
            
            JLabel lbAp2Usuario = new JLabel("APELLIDO 2");            
            lbAp2Usuario.setBounds(10, 70, 300, 25);
            contentPanel.add(lbAp2Usuario);
            
            ap2Usuario = new JTextField();            
            ap2Usuario.setBounds(100, 70, 300, 25);
            contentPanel.add(ap2Usuario);
        }             
       
        {
            JPanel buttonPane = new JPanel();
            buttonPane.setLayout(new FlowLayout(FlowLayout.RIGHT));
            getContentPane().add(buttonPane, BorderLayout.SOUTH);
            {
                JButton okButton = new JButton("Guardar");
                okButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent e) {    
						//if (Logica.ValidarTexto(descripcionEjercicio.getText().toString()))
						//{
						//	JOptionPane.showMessageDialog(null, 
						//			"Se ha introducido un caracter no valido. " +
						//			"Valores permitidos [a-z], [A-Z], [0-9] y espacio");
						//							
						//} else {
                    	Proyecto u = new Proyecto((int) Math.floor(Math.random()*(1000-1+1)+1000), nomUsuario.getText(), ap1Usuario.getText(), ap2Usuario.getText(), null);
                    	Auxiliar.lUsuarios.add(u);
                    	Collections.sort(Auxiliar.lUsuarios, new Comparator<Proyecto>(){
                			public int compare(Proyecto u1, Proyecto u2) {
                				// TODO Auto-generated method stub
                				
                				return u1.getNombre().compareTo(u2.getNombre());
                			}
                        });
                        ListIterator<Proyecto> iter = Auxiliar.lUsuarios.listIterator();
                        Auxiliar.modelo.clear();
                        while (iter.hasNext())
                        {        	
                        	
                        	Proyecto usuario = (Proyecto) iter.next();
                        	Auxiliar.modelo.addElement(usuario.getNombre());
                        }
                                	
                        
                        
                        Auxiliar.modelo.addElement("+...");
                    	
                    	//Auxiliar.modelo.addElement(u.getNombre());
                    	UsuarioJSON uJSON = new UsuarioJSON(u);
                    	uJSON.escribirUsuariosJSON();
							dispose();
						//}							
                        
                    }
                });
                okButton.setActionCommand("Guardar");
                buttonPane.add(okButton);
                getRootPane().setDefaultButton(okButton);
            }
            {
                JButton cancelButton = new JButton("Cancelar");
                cancelButton.addActionListener(new ActionListener() {
                    public void actionPerformed(ActionEvent arg0) {
                        dispose();
                    }
                });
                cancelButton.setActionCommand("Cancelar");
                buttonPane.add(cancelButton);
            }
        }
    }
    

}

