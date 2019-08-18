# Cohension Metric Plugin

## Introduction

It implements two functions for Java methods and make a plugin for eclipse. The one function is to generate variable dependency graph, the other is to compute the cohension.
## Variable Dependency Graph
1. decide all variables: decide the parameters and declared variables of methods
	
2. decide all edges:
	2.1 decide variable dependency edge
	2.2 decide control dependency edge
## Compute cohension
1. output variable determination. 
2. cohension algorithm
![Alt Image Text](./png/cohension classification.png)
![Alt Image Text](./png/cohension algorithm.png "cohension algorithm")
## Plugin implementation
![plugin implementation](png/plugin implementation.png "plugin implementation")
![choose specified method](png/choose method.png "choose specified method")
## Result 

```
public int sum(int n,int result,int prod){		int i=1;		int j=1;		result=0;		prod=1;		while (i<n){			i=i+1;			result=result+i;		}		while (j<n){			j=j+1;			prod=prod*j;		}	}
	
```
![Alt Image Text](png/variable dependency.png "variable dependency")
![Alt Image Text](png/cohension result.png "cohension result")
## Code description
1. the implementation of variable dependency graph in com.vdg
		Helloworld represent test code
		VariabVisitor decides all variables and output variables
		EdgeVisitor decides the edges
		JdtAstUtil generate AST for a method
		GraphVize implements the defination of graph
		DrawVDG implements the drawing
2. the implementation of plugin
		Labeldep is to show the variable dependency graph
		MetCohension is to implement the cohension algorithm and show the cohension of a method
		
## Running environment
Windows OS, 64
NOTE: It needs GraphViz, download from <https://graphviz.gitlab.io/_pages/Download/Download_window.html>

## References
[1] Rule-based Approach to Computing Module Cohesion 

[2]深入理解菜单<http://blog.csdn.net/zhuce0001/article/details/53231670>

[3]JDT的AST文档<https://max.book118.com/html/2017/0213/90939698.shtm> <https://wenku.baidu.com/view/a0b8e07931b765ce050814ac.html> <https://www.programcreek.com/2012/08/parse-a-sequence-of-java- statements-by-using-jdt-astparser/>

[4]DEF-USE chain
<https://en.wikipedia.org/wiki/Use-define_chain> <http://web.cs.iastate.edu/~weile/cs513x/5.DependencySlicing.pdf> <https://www.seas.harvard.edu/courses/cs252/2011sp/slides/Lec02 -Dataflow.pdf>

[5]eclipse 插件开发第 3 版