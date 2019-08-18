package com.vdg;

import java.util.List;

import org.eclipse.jdt.core.dom.AST;
import org.eclipse.jdt.core.dom.ASTParser;
import org.eclipse.jdt.core.dom.Block;
import org.eclipse.jdt.core.dom.CompilationUnit;
import org.eclipse.jdt.core.dom.FieldDeclaration;
import org.eclipse.jdt.core.dom.MethodDeclaration;
import org.eclipse.jdt.core.dom.Statement;
import org.eclipse.jdt.core.dom.Type;
import org.eclipse.jdt.core.dom.TypeDeclaration;


public class Helloworld {
	public List<String> vert;
	public List<Edge> edge_method;
	public List<String> output_vert;
	public int sum(int n,int j){
		int i=1;
		int result=0;
		while (i<n){
			i=i+1;
			result=result+i;
		}
		if (result<10){
			result=result+n;
		}
		result=result+10;
		return result;
	}
	public  void vdg(String select_text){
		CompilationUnit cu = JdtAstUtil.getCompilationUnit(select_text);
		List typeDeclarations = cu. types ();
		
		VariabVisitor cu_visitor = new VariabVisitor();   
		cu.accept(cu_visitor);
		vert=cu_visitor.get_vert();
		output_vert=cu_visitor.output_vert;
		TypeDeclaration clazzNode = (TypeDeclaration)typeDeclarations.get(0);
		MethodDeclaration[] methods=clazzNode.getMethods();

		for  (MethodDeclaration method  : methods)  {
			//System.out.print(method.getBody());
			EdgeVisitor visitor = new EdgeVisitor();   
			Block meh=method.getBody();
			meh.accept(visitor);
			List<Edge> edge_list=visitor.get_edge();
			visitor.print_edge();
			edge_method=edge_list;
		}
	}
	public void vdg_show(String select_text){
		CompilationUnit cu = JdtAstUtil.getCompilationUnit(select_text);
		List typeDeclarations = cu. types ();
		
		VariabVisitor cu_visitor = new VariabVisitor();   
		cu.accept(cu_visitor);
		vert=cu_visitor.get_vert();
		output_vert=cu_visitor.output_vert;
		TypeDeclaration clazzNode = (TypeDeclaration)typeDeclarations.get(0);
		MethodDeclaration[] methods=clazzNode.getMethods();

		for  (MethodDeclaration method  : methods)  {
			//System.out.print(method.getBody());
			EdgeVisitor visitor = new EdgeVisitor();   
			Block meh=method.getBody();
			meh.accept(visitor);
			List<Edge> edge_list=visitor.get_edge();
			visitor.print_edge();
			edge_method=edge_list;
		}
		DrawVDG vdg=new DrawVDG();
		vdg.draw(edge_method);
		}


	public static void main(String[] args ){
		String tempMiddle="public int sum(int n,int j){int i=1;int result=0;while (i<n){i=i+1;result=result+i;}if (result<10){result=result+n;}result=result+10;return result;}";
		CompilationUnit cu = JdtAstUtil.getCompilationUnit(tempMiddle);
		List typeDeclarations = cu. types ();
		Helloworld hell=new Helloworld();
		VariabVisitor cu_visitor = new VariabVisitor();   
		cu.accept(cu_visitor);
		hell.vert=cu_visitor.get_vert();
		hell.output_vert=cu_visitor.output_vert;
		TypeDeclaration clazzNode = (TypeDeclaration)typeDeclarations.get(0);
		MethodDeclaration[] methods=clazzNode.getMethods();

		for  (MethodDeclaration method  : methods)  {
			//System.out.print(method.getBody());
			EdgeVisitor visitor = new EdgeVisitor();   
			Block meh=method.getBody();
			meh.accept(visitor);
			List<Edge> edge_list=visitor.get_edge();
			visitor.print_edge();
			hell.edge_method=edge_list;
		}
		DrawVDG vdg=new DrawVDG();
		vdg.draw(hell.edge_method);
		
		}
}
//Display display=new Display();
//Shell shell=new Shell(display);
//shell.setText("Hello");//���ô���֡�ı���
//shell.setBounds(100,0,200,50);/���ô���֡��С��λ��
//shell.setLayout(new FillLayout());
//Label lable=new Label(shell ,SWT.CENTER);//������ǩ���������ı�λ��������
//lable.setText("hello xidd");//���ñ�ǩ���ı�
//Color red =new Color(display,255,0,0);
//lable.setForeground(red);//���ñ�ǩ��ǰ��
//shell.open();//����֡�ɼ�
//while(!shell.isDisposed()){
//	if(!display.readAndDispatch()){
//		display.sleep();
//	}
//}
//red.dispose();//ϵͳ��ɫ��Ӧ�ñ����ͷ�
//display.dispose();
//}
