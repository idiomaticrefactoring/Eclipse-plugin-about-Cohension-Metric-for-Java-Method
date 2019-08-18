
import java.awt.Container;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.swt.events.MouseEvent;
import org.eclipse.swt.events.MouseListener;
import org.eclipse.ui.IEditorPart;
import org.eclipse.ui.IWorkbenchPage;
import org.eclipse.ui.IWorkbenchWindow;
import org.eclipse.ui.handlers.HandlerUtil;

import com.vdg.*;
/**
 * Our sample handler extends AbstractHandler, an IHandler base class.
 * @see org.eclipse.core.commands.IHandler
 * @see org.eclipse.core.commands.AbstractHandler
 */
public class Labeldep extends AbstractHandler implements MouseListener{
//	public static void main(String[] args ){
//		String ss="public int sum(int n,int j){int i=1;int result=0;while (i<n){i=i+1;result=result+i;}}";
//		Helloworld vdg_show=new Helloworld();
//		vdg_show.vdg_show(ss);
//	}
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Method_content content=new Method_content();
		String ss=content.get_content();
		MessageDialog.openInformation(
				window.getShell(),
				"Hh",
				ss);
		Helloworld vdg_show=new Helloworld();
		vdg_show.vdg_show(ss);
		/*JFrame frame=new JFrame();
		//Container c=frame.getContentPane();
		ImageIcon imagetoshow=new ImageIcon("F:/南京大学/软件度量/vdg." + "png"); 
		Container c=frame.getContentPane();
		JLabel showimagelabel=new JLabel(imagetoshow);  
		frame.getLayeredPane().add(showimagelabel,  
		        new Integer(Integer.MIN_VALUE)); // 设置JLabel在最底层  
		showimagelabel.setBounds(0, 0, 500,150); 
		//showimagelabel.setIcon(imagetoshow);
		c.add(showimagelabel);
		frame.pack();
		frame.setSize(400,400);
		frame.setVisible(true);*/
		
		
//		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		window.g
//		IWorkbenchPage page = window.getActivePage();
//		IEditorPart editor = page.getActiveEditor();
//		Transferable clipTf = sysClip.getContents(null);  
//		String ret="";  
//        if (clipTf != null) {  
//            // 检查内容是否是文本类型  
//            if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {  
//                try {  
//                    ret = (String) clipTf  
//                            .getTransferData(DataFlavor.stringFlavor);  
//                } catch (Exception e) {  
//                    e.printStackTrace();  
//                }  
//            }  
//        }  
////		editor.addPropertyListener(listener);
////		editor.setFocus();
//		MessageDialog.openInformation(
//				window.getShell(),
//				"Hh",
//				ret);
		return null;
	}

	@Override
	public void mouseDoubleClick(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseDown(MouseEvent e) {
		// TODO Auto-generated method stub
	
		
	}

	@Override
	public void mouseUp(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}
//import java.awt.event.MouseEvent;
//
//import javax.swing.text.JTextComponent;
//
//import org.eclipse.core.commands.ExecutionEvent;
//import org.eclipse.core.commands.ExecutionException;
//import org.eclipse.core.commands.IHandler;
//import org.eclipse.core.commands.IHandlerListener;
//import org.eclipse.jface.dialogs.MessageDialog;
//import org.eclipse.swt.widgets.Text;
//import org.eclipse.ui.IWorkbenchWindow;
//import org.eclipse.ui.handlers.HandlerUtil;
//
//
//public class Labeldep implements AbstractHandler {
//
//	@Override
//	public void addHandlerListener(IHandlerListener handlerListener) {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public void dispose() {
//		// TODO Auto-generated method stub
//
//	}
//
//	@Override
//	public Object execute(ExecutionEvent event) throws ExecutionException {
//		// TODO Auto-generated method stub
////		MouseEvent e = null;
////		JTextComponent textComponent = (JTextComponent) e.getSource();
////	    textComponent.requestFocus();
////	    String sel =textComponent.getSelectedText();
//		String sel ="hello";
//	    IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
//		MessageDialog.openInformation(
//				window.getShell(),
//				"Ff",
//				sel);
//		return null;
//	}
//
//	@Override
//	public boolean isEnabled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public boolean isHandled() {
//		// TODO Auto-generated method stub
//		return false;
//	}
//
//	@Override
//	public void removeHandlerListener(IHandlerListener handlerListener) {
//		// TODO Auto-generated method stub
//
//	}
//
//}
