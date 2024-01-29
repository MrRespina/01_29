package com.ji.hadoop.p002;

import java.io.IOException;
import java.util.StringTokenizer;

import org.apache.hadoop.io.IntWritable;	// int 형 처리
import org.apache.hadoop.io.Text;	// String 형 처리
import org.apache.hadoop.mapreduce.Mapper;

// Hadoop 작업의 첫 번째 단계 : Map

// 1단계 : 다운받은 소설책을 분석하라고 넣어줄 것 !
//		> key : 없고, value : String (hadoop에서는 String이 Text)
// 2단계 : 결과를 받아오기
//		> key : String, value : int
//		ex) I, 1
//			am, 1
//			sleepy, 1

public class WCMapper extends Mapper<Object, Text, Text, IntWritable>{

	private static final Text WORD = new Text();
	private static final IntWritable ONE = new IntWritable(1);

	@Override
	protected void map(Object key,
			Text value,
			Mapper<Object, Text, Text, IntWritable>.Context context)
			throws IOException, InterruptedException {

		String line = value.toString();
		StringTokenizer st = new StringTokenizer(line," ");
		
		// 각각 유비 / 조조 / 손권 찾기
		String word = null;
		while(st.hasMoreElements()) {
			
			word = st.nextToken();
			if(word.contains("유비") || word.contains("현덕")) {
				
				WORD.set("유비");
				context.write(WORD,ONE);
				
			}else if(word.contains("조조") || word.contains("맹덕")) {
				
				WORD.set("조조");
				context.write(WORD,ONE);
				
			}else if(word.contains("손권") || word.contains("중모")) {
				
				WORD.set("손권");
				context.write(WORD,ONE);
				
			}
			
			
		}

		
	}
	
}
