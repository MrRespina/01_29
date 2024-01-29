package com.ji.hadoop.p002;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.fs.Path;
import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Job;
import org.apache.hadoop.mapreduce.lib.input.FileInputFormat;
import org.apache.hadoop.mapreduce.lib.output.FileOutputFormat;

// 소설책 > 작가가 무슨 단어를 자주 사용했는지 찾아볼 것.
// Hadoop : 서버급(Linux) 컴퓨터를 여러대로 병렬처리해서 분석하는 Java프로그램
// Window로 Hadoop 짜는 이유 > 자동완성의 편리성
//		> 필요한것만 자동완성되면 OK
//		> Hadoop 전체적인건 필요 X
//		> 실제로 실행 할 Linux에는 Hadoop 전체가 다 설치되어 있음.
//			> 현재 사용할 것은 Hadoop-common, Hadoop-mapreduce-client-core 만 있으면 됨.

// 
public class WCMain {
	
	public static void main(String[] args) {
		
		try {
			
			Configuration c = new Configuration();
			Job j = Job.getInstance(c);
		
			j.setMapperClass(WCMapper.class);
			j.setCombinerClass(WCReducer.class);
			j.setReducerClass(WCReducer.class);
		
			j.setOutputKeyClass(Text.class);
			j.setOutputValueClass(IntWritable.class);
			
			for(int i=1;i<=10;i++) {

				FileInputFormat.addInputPath(j, new Path("/threekingdoms/tk0"+i+".txt"));
			
			}		
			FileOutputFormat.setOutputPath(j, new Path("/tkResult"));
			
			j.waitForCompletion(true);
		

		}catch (Exception e) {
			e.printStackTrace();
		}
		
	}

}