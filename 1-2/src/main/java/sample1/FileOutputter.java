package sample1;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements Outputter {
	private String filePath;//세터를 통한 주입
	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}
	
	public void output(String message) throws IOException {
		FileWriter out = new FileWriter(filePath);//파일로 출력 객체 생성
		out.write(message);//파일로 message의 내용을 출력
		out.close();//파일을 닫음
		System.out.println("파일 생성 완료!");
	}

}














