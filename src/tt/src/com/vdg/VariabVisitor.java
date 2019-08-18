package com.vdg;
/*
 * 获得方法的output variables
	 1.* 获得方法的参数
	 2. * 获得方法中声明的变量
 */

import java.util.ArrayList;
import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTVisitor;  
import org.eclipse.jdt.core.dom.Assignment;
import org.eclipse.jdt.core.dom.Assignment.Operator;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.Expression;
import org.eclipse.jdt.core.dom.FieldDeclaration;  
import org.eclipse.jdt.core.dom.MethodDeclaration;  
import org.eclipse.jdt.core.dom.MethodRefParameter;
import org.eclipse.jdt.core.dom.QualifiedName;
import org.eclipse.jdt.core.dom.SimpleName;
import org.eclipse.jdt.core.dom.SingleVariableDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.TypeDeclaration;
import org.eclipse.jdt.core.dom.VariableDeclarationExpression;
import org.eclipse.jdt.core.dom.VariableDeclarationFragment;  
import org.eclipse.jdt.core.dom.VariableDeclarationStatement;
import org.eclipse.jdt.core.dom.WhileStatement;
  
public class VariabVisitor extends ASTVisitor {  
	public  List<String> vert=new ArrayList<>();
	public  List<String> output_vert=new ArrayList<>();
	public List<String> get_vert(){
	   return vert;
   }
	public void print_vert(){
		for (int i=0;i<vert.size();i++){
			String vertex=vert.get(i);
			System.out.println("Variable:\t"+vertex);
		}
	}
    @Override  
    public boolean visit(MethodDeclaration node) {  
    	List<SingleVariableDeclaration> params = node.parameters(); 
    	Block block = node.getBody();
    	for (int i=0;i<params.size();i++){
    		SingleVariableDeclaration param=(SingleVariableDeclaration) params.get(i);
    		vert.add(param.getName().toString());
	    	block.accept(new ASTVisitor(){
	    		public boolean visit(Assignment node) {
	    			
	    			System.out.println("output_var: "+node.toString() );
	    			List<String> right_var=new ArrayList<>();
	    			List<String> left_var=new ArrayList<>();
					Expression expre_Left = node.getLeftHandSide();
					Expression expre_Right = node.getRightHandSide();
					expre_Left.accept(new ASTVisitor(){
						public boolean visit(SimpleName node) {
							right_var.add(node.getFullyQualifiedName());
							System.out.println("output_var_right: "+node.getFullyQualifiedName() );
							return true;
						}
					});
//					expre_Right.accept(new ASTVisitor(){
//						public boolean visit(SimpleName node) {
//							left_var.add(node.getFullyQualifiedName());
//							System.out.println("output_var_right: "+node.getFullyQualifiedName() );
//							return true;
//						}
//					});
					if(right_var.contains(param.getName().toString()) ){
						output_vert.add(param.getName().toString());
					}
					return true;
	    	}
	    	});
    	}
        return true;  
    }  
  
    @Override  
    public boolean visit(VariableDeclarationFragment node) {  
    	node.accept(new ASTVisitor() {
   		 
			public boolean visit(SimpleName node) {
 
				System.out.println("VariableDeclarationFragment: " + node.getFullyQualifiedName());
				vert.add(node.getFullyQualifiedName());
				return true;
			}
    	});
        return true;  
    }  
    
  
}  