import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;


public class Method_content {
	public String get_content(){
		Clipboard sysClip = Toolkit.getDefaultToolkit().getSystemClipboard();
		Transferable clipTf = sysClip.getContents(null);  
		String ret=" " ;  
	    if (clipTf != null) {  
	        // 检查内容是否是文本类型  
	        if (clipTf.isDataFlavorSupported(DataFlavor.stringFlavor)) {  
	            try {  
	                ret = (String) clipTf  
	                        .getTransferData(DataFlavor.stringFlavor);  
	            } catch (Exception e) {  
	                e.printStackTrace();  
	            }  
	        }  
	    }
		return ret;  
	}
}
