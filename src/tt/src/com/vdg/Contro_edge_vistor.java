package com.vdg;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.Statement;

import com.vdg.Edge;
/*
 * 从EdgeVistor的语句体重获得assignment表达式将其加入边集合，主要设置这个类是为了避免EdgeVistor的添加边 的重复操作
 */
public class Contro_edge_vistor extends ASTVisitor{
	List<String> start_var = new ArrayList<>();  
	Statement sta;
	String flag;
	List<Edge> edge_method=new ArrayList<>() ;
	public Contro_edge_vistor(List start_var,Statement sta,List<Edge> edge_method,String flag) {
		// TODO Auto-generated constructor stub
			this.start_var=start_var;
			this.sta=sta;
			this.edge_method=edge_method;
			this.flag=flag;
	}
	@Override 
	public boolean visit(Assignment node) {
		String start_node=String.valueOf(sta.getStartPosition());
		Expression expre_stst = node.getLeftHandSide();
		
		expre_stst.accept(new ASTVisitor() {
			public boolean visit(SimpleName node) {
				String end_name=node.getFullyQualifiedName().toString();
				//System.out.println("IfStatement_body: " + end_name);
				for (int i=0;i<start_var.size();i++){
					if(!start_var.get(i).equals(end_name)){
					List<String> list = new ArrayList();
					list.add(flag);
					list.add(start_node);
					edge_method.add(new Edge(start_var.get(i),end_name,"c",list));
					}
				}
				
				return true;
			}
		});
		return true;
}
}
