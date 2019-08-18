package com.vdg;

import java.util.ArrayList;
import java.util.List;
/*
 * 变量依赖图VDG的边有：
 * 起始点，终点，边的信息（控制依赖"c"（含有起始点和真假t or f）或者数据依赖"d"）
 */

public class Edge {
		public Edge(String start, String end_name, String c,List a) {
		// TODO Auto-generated constructor stub
			this.start=start;
			this.end=end_name;
			this.flag=c;
			this.n_k=a;
			
	}
		public void print_dege(){
			System.out.println("Edge:\t"+start+","+end+","+flag+","+n_k.toString());
		}
		public String start;
		public String end;
		public String flag;
		public List<String> n_k;
}
