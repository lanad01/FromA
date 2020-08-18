package sample1;

import java.io.FileWriter;
import java.io.IOException;

public class FileOutputter implements OutPutter { //종속객체- 인터페이스가 아닌 일반 클래스
	private String filePath;
	public void setFilePath(String filePath) {
		this.filePath = filePath; 
		//OutPutter를 쓰기 위한 경로 - private으로 되어 있기 때문에 set메소드를 통해 전송
		//1-1에서는 종속객체 생성만 해도 구현이 가능
		//1-2에서는 종속객체 생성 후 세터를 통한 변수 주입이 필요
	}
	@Override	
	public void output(String message) throws IOException {
		FileWriter out=new FileWriter(filePath);
		out.write(message);
		out.close();
		System.out.println("파일 생성 완료");

	}

}
