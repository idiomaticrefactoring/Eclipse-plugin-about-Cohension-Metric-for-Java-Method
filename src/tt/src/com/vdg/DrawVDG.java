package com.vdg;

import java.awt.Container;
import java.io.File;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DrawVDG {
	public void draw(List<Edge> edge_method){
		GraphViz gv = new GraphViz();
		gv.addln(gv.start_graph());
		for (int i=0;i<edge_method.size();i++){
			Edge edge=edge_method.get(i);
			gv.addln(edge.start+"->"+edge.end+"[label="+'"'+edge.flag+edge.n_k.toString()+'"'+']'); 
		} 
//		gv.addln("A -> B;");
//		gv.addln("A -> C;");
		gv.addln(gv.end_graph());
		System.out.println(gv.getDotSource());
	
		gv.increaseDpi();   // 106 dpi
	
		//String type = "gif";
		//      String type = "dot";
		//      String type = "fig";    // open with xfig
		//      String type = "pdf";
		//      String type = "ps";
		//      String type = "svg";    // open with inkscape
		      String type = "png";
		//      String type = "plain";
		
		String repesentationType= "dot";
		//		String repesentationType= "neato";
		//		String repesentationType= "fdp";
		//		String repesentationType= "sfdp";
		// 		String repesentationType= "twopi";
		// 		String repesentationType= "circo";
		
		//File out = new File("/tmp/out"+gv.getImageDpi()+"."+ type);   // Linux
		      File out = new File("c:/vdg." + type);    // Windows
		gv.writeGraphToFile( gv.getGraph(gv.getDotSource(), type, repesentationType), out );
		
		JFrame frame=new JFrame();
		//Container c=frame.getContentPane();
		ImageIcon imagetoshow=new ImageIcon("c:/vdg." + type); 
		Container c=frame.getContentPane();
		JLabel showimagelabel=new JLabel(imagetoshow);  
		frame.getLayeredPane().add(showimagelabel,  
		        new Integer(Integer.MIN_VALUE)); // ÉèÖÃJLabelÔÚ×îµ×²ã  
		showimagelabel.setBounds(0, 0, 500,150); 
		//showimagelabel.setIcon(imagetoshow);
		c.add(showimagelabel);
		frame.pack();
		frame.setSize(400,400);
		frame.setVisible(true);
	}
}
