package com.vdg;

import java.util.ArrayList;
import java.util.List;
/*
 * ��������ͼVDG�ı��У�
 * ��ʼ�㣬�յ㣬�ߵ���Ϣ����������"c"��������ʼ������t or f��������������"d"��
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
