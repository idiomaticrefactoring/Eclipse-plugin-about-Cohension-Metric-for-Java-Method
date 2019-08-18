package com.vdg;

  
import org.eclipse.jdt.core.dom.AST;  
/*
 * 获得方法的完整字符串和CompilationUnit供后续进行访问操作
 */
import org.eclipse.jdt.core.dom.ASTParser;  
import org.eclipse.jdt.core.dom.CompilationUnit;  
public class JdtAstUtil {  

	public static CompilationUnit getCompilationUnit(String tMiddle){
		String sourceStart = "public class A {\n";
		String tempMiddle=tMiddle;//"public int sum(int n,int j){int i=1;}";//, "int result=0;","while (i<n){","i=i+1;","result=result+i;","}","if(result<n){","result=result+10;","}","result=result+10;","return result;","}"};
		//add a fake class A as a shell, to meet the requirement of ASTParser
		String sourceMiddle =tempMiddle;
//		String sourceMiddle = "";
//		for(String s : tempMiddle){	
//			s = s.trim();
//			if(s.trim().length()>0 && !s.startsWith("---") && !s.startsWith("/") && !s.startsWith("*") )
//			sourceMiddle += s.trim() + "\n";
//		}
		String sourceEnd = "}";
		String source = sourceStart + sourceMiddle + sourceEnd;
		
		ASTParser parser = ASTParser.newParser(AST.JLS8);   
		parser.setSource(source.toCharArray());
		parser.setKind(ASTParser.K_COMPILATION_UNIT);
		CompilationUnit cu = (CompilationUnit) ( parser.createAST(null));  
		return cu; 
	}

}