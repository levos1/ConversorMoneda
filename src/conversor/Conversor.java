package conversor;
import java.awt.*;
import java.awt.event.*;
import java.text.DecimalFormat;

import javax.swing.*;

public class Conversor extends WindowAdapter implements ItemListener {
	 public JFrame f;
	 public JComboBox cb;
	 public JLabel l1;
	public Conversor() {
		// TODO Auto-generated method stub
	    Dimension ss = Toolkit.getDefaultToolkit ().getScreenSize ();
	    Dimension frameSize = new Dimension ( 800, 400 );
		this.f = new JFrame("Menu");
		l1 = new JLabel("Elija la moneda a la que deseas convertir tu dinero");
		l1.setBounds(150, 30,500,20);   
		f.add(l1);
		String opciones[]={"Elija una opción",
				"De Pesos Chilenos a Dólar",
				"De Pesos Chilenos a Euros",
				"De Pesos Chilenos a Libras Esterlinas",
				"De Pesos Chilenos a Yen Japonés",
				"De Pesos Chilenos a Won sur-coreano",
				"De Dólar a Pesos Chilenos",
				"DeEuros a Pesos Chilenos",
				"De Libras Esterlinas a Pesos Chilenos",
				"De Yen Japonés a Pesos Chilenos",
				"Won sul-coreano a Pesos Chilenos"};        
	    cb=new JComboBox(opciones);    
	    cb.setBounds(150, 50,500,20);
	    //cb.setAlignmentX(cb.CENTER_ALIGNMENT);
	    //cb.setAlignmentY(cb.CENTER_ALIGNMENT);
	    cb.addItemListener(this); 
	    f.add(cb);     

	    f.setSize(frameSize); 
	    f.setBounds ( ss.width / 2 - frameSize.width / 2, 
	            ss.height / 2 - frameSize.height / 2,
	            frameSize.width, frameSize.height ); 
	    f.setLayout(null);  
	    f.setVisible(true);  
	}
	
	@Override
    public void itemStateChanged(ItemEvent event) {
       if (event.getStateChange() == ItemEvent.SELECTED) {
    	   int indice = cb.getSelectedIndex();
          //Object item = event.getItem();// valor de item seleccionado
          //System.out.print(this.cb.getSelectedIndex());// indice de objeto
          // logica
          switch(indice) {
          case 0:
        	  JOptionPane.showMessageDialog(f,"Elija una opción","Alert",JOptionPane.WARNING_MESSAGE); 
        	  break;
          case 1:
        	  this.menuConvertirMoneda(0.0012,"dolares");
        	  break;
          case 2:
        	  this.menuConvertirMoneda(0.0011,"euros");
        	  break;
          case 3:
        	  this.menuConvertirMoneda(0.00094,"libras esterlinas");
        	  break;
          case 4:
        	  this.menuConvertirMoneda(0.17,"yenes");
        	  break;
          case 5:
        	  this.menuConvertirMoneda(1.56,"wones");
        	  break;
          case 6:
        	  this.menuConvertirMoneda(809.40,"pesos Chilenos");
        	  break;
          case 7:
        	  this.menuConvertirMoneda(908.68,"pesos Chilenos");
        	  break;
          case 8:
        	  this.menuConvertirMoneda(1065.93,"pesos Chilenos");
        	  break;
          case 9:
        	  this.menuConvertirMoneda(5.83,"pesos Chilenos");
        	  break;
          case 10:
        	  this.menuConvertirMoneda(0.64,"pesos Chilenos");
        	  break;
        	  
          }
       }
	}
	
	
	// quizá cambiar a otra clase 
	public void menuConvertirMoneda(double tasaConversion,String moneda) {

		//JComboBox.getSelectedItem()
		      JFrame f=new JFrame();   
			  String cifra= JOptionPane.showInputDialog(f,"Input");
			  //double cifraAsDouble = (cifra!=null) ? Double.valueOf(JOptionPane.showInputDialog(f,"Input")) :0;
		    try {
		    	double cifraAsDouble = (cifra!=null) ? Double.valueOf(cifra) :-1;
		    	if(cifraAsDouble >0) {		    
		    		DecimalFormat numberFormat = new DecimalFormat("#.##");
		    		JOptionPane.showMessageDialog(f,"Tienes "+numberFormat.format(cifraAsDouble * tasaConversion)+" "+moneda); 
		    	}
		    	else {
		    		int a=JOptionPane.showConfirmDialog(f,"¿Desea Continuar?");  
			    	if(a==JOptionPane.YES_OPTION){  
			    	    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);  
			    	}
			    	else {
			    		JOptionPane.showMessageDialog(f,"Programa Finalizado!","Alert",JOptionPane.WARNING_MESSAGE); 
			    		this.f.dispatchEvent(new WindowEvent(this.f, WindowEvent.WINDOW_CLOSING));
			    	}
		    	}
		    	
		    	
		    } catch (NumberFormatException nfe) {
		    	// error salta cuando ingreso caracteres especiales pero no al usar solo letras
		    	JOptionPane.showMessageDialog(f,"No se permite ingresar valores no numéricos","Alert",JOptionPane.WARNING_MESSAGE); 
		    }
			  
	}
	
	
	 
}
