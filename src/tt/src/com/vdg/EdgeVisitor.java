package com.vdg;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.ASTVisitor;
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.ExpressionStatement;
import org.eclipse.jdt.core.dom.IfStatement;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;
import org.eclipse.jdt.core.dom.WhileStatement;

import com.vdg.Edge;
/*
 *获得控制依赖和数据依赖
	 *控制依赖：
		 *while语句：首先获得while表达式的变量名是边的尾     while的语句体的表达式的变量名是边的头   是true
		 *if语句：首先获得if表达式的变量名是边的尾      ifthen的语句体的表达式的变量名是边的头  是true   else的语句体的表达式的变量名是边的头  是false  语句标号从ifthen或者else的startposition 
		 *
	 *数据依赖：use-define chain ：
	 	*找assignment类且左边与右边的操作数不能重复 左边为边的尾  右边为头
 *
 */
public class EdgeVisitor extends ASTVisitor{

	public   List<Edge> edge_method=new ArrayList<>() ;

	public void print_edge(){
		for (int i=0;i<edge_method.size();i++){
			Edge edge=edge_method.get(i);
			System.out.println("Edge:\t"+edge.start+","+edge.end+","+edge.flag+","+edge.n_k.toString());
		}
	}
	public List<Edge> get_edge(){
		return edge_method;
		
	}
  @Override  
  public boolean visit(WhileStatement node) {
	String start_node=String.valueOf(node.getStartPosition());
	List<String> start_var = new ArrayList<>();  
  	Expression express=node.getExpression();
  	express.accept(new ASTVisitor() {
  		 
			public boolean visit(SimpleName node) {

				System.out.println("WhileStatement_getExpression: " + node.getFullyQualifiedName());
				start_var.add(node.getFullyQualifiedName().toString());
				return true;
			}
   	});
  	
  	Statement whi_body=node.getBody();
  	Contro_edge_vistor Contro__vistor1=new Contro_edge_vistor(start_var,whi_body,edge_method,"t");
  	whi_body.accept(Contro__vistor1);
     return true;  
  }
	@Override  
	public boolean visit(IfStatement node) {
		
		List<String> start_var = new ArrayList<>();  
	  	Expression express=node.getExpression();
	  	express.accept(new ASTVisitor() {
	  		 
				public boolean visit(SimpleName node) {

					System.out.println("IfStatement_getExpression: " + node.getFullyQualifiedName());
					start_var.add(node.getFullyQualifiedName().toString());
					return true;
				}
	   	});
	  	Statement Then=node.getThenStatement();
	  	//List start_var,Statement sta,List<Edge> edge_method,String flag
	  	Contro_edge_vistor Contro__vistor1=new Contro_edge_vistor(start_var,Then,edge_method,"t");
	  	Then.accept(Contro__vistor1);
	  	
	  	Statement Else=node.getElseStatement();
	  	if (Else != null){
		  	Contro_edge_vistor Contro__vistor2=new Contro_edge_vistor(start_var,Else,edge_method,"f");
		  	Else.accept(Contro__vistor2);
	  	}
	     return true;  
		
	}

	@Override  
	public boolean visit(Assignment node) {
			System.out.println("ExpressionStatement:\t"+node);
			List<String> var_lef = new ArrayList<>();
			List<String> var_rig = new ArrayList<>();
			Expression expre_stst_lef = node.getLeftHandSide();
			Expression expre_stst_rig =node.getRightHandSide();
			expre_stst_lef.accept(new ASTVisitor() {
				public boolean visit(SimpleName node) {
					String end_name=node.getFullyQualifiedName().toString();
					var_lef.add(end_name);
					System.out.println("datadependency_body: " + end_name);
					return true;
				}
			});
			expre_stst_rig.accept(new ASTVisitor() {
				public boolean visit(SimpleName node) {
					String end_name=node.getFullyQualifiedName().toString();
					System.out.println("datadependency_body: " + end_name);
					var_rig.add(end_name);
					return true;
				}
			});
			if(! var_rig.contains(var_lef.get(0))){
				for (int i=0;i<var_rig.size();i++){
					List<String> list = new ArrayList<String>();
					edge_method.add(new Edge(var_rig.get(i),var_lef.get(0),"d",list));
					}
			
				}
			
			return true;
	}
}
