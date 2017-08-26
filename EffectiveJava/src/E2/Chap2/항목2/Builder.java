package E2.Chap2.항목2;

public class Builder {
	int num1;
	int num2;
	int num3;
	int num4;
	
	Builder setNum1(int num1){
		this.num1=num1;
		return this;
	}
	Builder setNum2(int num2){
		this.num2=num2;
		return this;
	}
	Builder setNum3(int num3){
		this.num3=num3;
		return this;
	}
	Builder setNum4(int num4){
		this.num4=num4;
		return this;
	}
	
	
	public static void main(String[] args)
	{
		Builder builder = new Builder();
		//이런식으로 return을 이용한 패턴 사용한다.
		builder.setNum1(1).setNum2(2).setNum3(3).setNum4(4);
		
	}
}
