import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.ExecutionException;
import org.eclipse.core.commands.IHandlerListener;
import org.eclipse.jface.dialogs.MessageDialog;
import org.eclipse.ui.handlers.HandlerUtil;
import org.eclipse.ui.IWorkbenchWindow;

import com.vdg.Edge;
import com.vdg.Helloworld;


public class MetCohesion extends AbstractHandler  {
	
/*	0,"undefined"
	1,Coincidental
	2,Logical
	3,Procedural
	4,Communicational
	5,Sequential
	6,Functional*/
	@Override
	public Object execute(ExecutionEvent event) throws ExecutionException {
		// TODO Auto-generated method stub
		IWorkbenchWindow window = HandlerUtil.getActiveWorkbenchWindowChecked(event);
		Method_content content=new Method_content();
		String ss=content.get_content();
		
		Helloworld vdg_show=new Helloworld();
		vdg_show.vdg(ss);
		List<String> vert = vdg_show.output_vert;
		List<String> vert1 = vdg_show.vert;
		List<Edge> edge_method = vdg_show.edge_method;
		//System.out.println("vertex:"+vert1.toString()+","+edge_method.size())
		System.out.println("vertex:"+vert1.toString());
		System.out.println("output_vert:"+vert.toString());
		HashMap<Integer, String> myMap = new HashMap<Integer, String>(){{
	        put(0,"undefined");
	        put(1,"Coincidental");
	        put(2,"Logical");
	        //.... some other put() code
	        put(3,"Procedural");
	        put(4,"Communicational");
	        put(5,"Sequential");
	        put(6,"Functional");
	    }};; 
	   
		String  cohension="null";
		if (vert.size()==0){
			cohension="undefined";
		}
		else if(vert.size()==1){
			cohension="Functional";
		}
		else{
			List<Integer> pairs=new ArrayList<>() ;
			for(int i=0;i<vert.size()-1;i++){
				for(int j=i+1;j<vert.size();j++){
					if(i!=j){
						String v1 = vert.get(i);
						String v2 = vert.get(j);
						System.out.println("method_cohension:变量"+v1+","+v2);
						List<Integer> pairs1 = new ArrayList<>();
						for(Edge edge:edge_method){
							   // System.out.println("method_cohension:变量"+edge.start+","+edge.end);
								if (edge.start.equals(v1) &&edge.end.equals(v2)){
									pairs1.add(5);}else if(edge.start.equals(v2) &&edge.end.equals(v1)){
										pairs1.add(5);
									}
								else{
									String s_s =(edge.n_k).get(0);
									String s_e=edge.n_k.get(1);
									for(int k=0;k<vert1.size();k++){
										String z = vert1.get(k);
										if(!v1.equals(z)&&!v2.equals(z)){
											
											for(int i2=0;i2<edge_method.size();i2++){
												Edge edge1 = edge_method.get(i2);
												String s3=edge1.n_k.get(0);
												String s4=edge1.n_k.get(1);
												if(edge1.start.equals(z) &&edge1.end.equals(v1)&&edge.start.equals(z)&&edge.end.equals(v2)&&s3.equals(s_s)&&s4.equals(s_e)){
													System.out.println("匹配 的边：");
													edge1.print_dege();
													edge.print_dege();
													pairs1.add(3);
												}else if(edge1.start.equals(z) &&edge1.end.equals(v1)&&edge.start.equals(z)&&edge.end.equals(v2)&&s4.equals(s_e)){
													pairs1.add(2);
												}
											}
										}
								
									}
								}
						}
						if(pairs1.isEmpty()){
							System.out.println("method_cohension:变量is not 2 or 3");
							for(Edge edge1:edge_method){
									for(int k=0;k<vert1.size();k++){
										String z = vert1.get(k);
										if(!v1.equals(z)&&!v2.equals(z)){
											
											for(int i1=0;i1<edge_method.size();i1++){
												Edge edge2 = edge_method.get(i1);
												if (edge2.start.equals(z) &&edge2.end.equals(v1) &&edge1.start.equals(z) &&edge1.end.equals(v2)){
															pairs1.add(4);
														}else if (edge2.start.equals(v1) &&edge2.end.equals(z) &&edge1.start.equals(v2) &&edge1.end.equals(z)){
															pairs1.add(4);
														}
													}
												}
											}
										}
										
									}
						if(pairs1.isEmpty()){
							pairs1.add(1);
						}
						pairs.add(Collections.max(pairs1));
					}
					
			}
			cohension=myMap.get(Collections.min(pairs));
		}
		}
			
		MessageDialog.openInformation(
				window.getShell(),
				"Method cohension",
				cohension);
		return null;
	}

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

//	@Override
//	public void removeHandlerListener(IHandlerListener handlerListener) {
//		// TODO Auto-generated method stub
//
//	}

}
