package com.ji.hadoop.p002;

import java.io.IOException;

import org.apache.hadoop.io.IntWritable;
import org.apache.hadoop.io.Text;
import org.apache.hadoop.mapreduce.Reducer;

// Hadoop 작업 두 번째 단계 : Combine
// 두 번째 단계는 알아서 처리됨!

// Hadoop 작업 세 번째 단계 : Reduce
// Mapper에서 유비,조조,손권으로 처리했기 때문에, arg0 값은 유비/조조/손권만 들어옴.

// 인자 앞의 두자리는 Mapper쪽 뒤의 두자리와 같아야 함.
public class WCReducer extends Reducer<Text, IntWritable, Text, IntWritable>{
	
	private static final IntWritable SUM = new IntWritable();
	
	@Override
	protected void reduce(Text arg0,Iterable<IntWritable> arg1,	Reducer<Text, IntWritable, Text, IntWritable>.Context arg2)
		throws IOException, InterruptedException {
		
		int sum = 0;
		
		for (IntWritable i : arg1) {

			sum += i.get();	
			
		}
		
		SUM.set(sum);
		arg2.write(arg0, SUM);
		

	}

}
