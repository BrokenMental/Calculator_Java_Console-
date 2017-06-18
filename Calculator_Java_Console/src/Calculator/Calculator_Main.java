package Calculator;

import java.util.Scanner;

public class Calculator_Main {
	public static void main(String[] args) {
            System.out.print("수식을 입력하세요 : ");
            Scanner abc = new Scanner(System.in);
            String num = abc.next();
            Formula op = new Formula();
            // String exp = "(3*5)-(6/2)";
		
            if(op.Same(num)){
		System.out.println("수식이 올바름(괄호의 쌍이 일치)");
            }else{
		System.out.println("수식이 올바르지 않음(괄호의 쌍이 불일치)");
            }
            String temp = op.toPostfix(num);
            System.out.println(temp);
            evalPostfix(temp);
	}
        
	public static void evalPostfix(String postfix){
		char Word = ' ';
		LinkedStack1 stack = new LinkedStack1();
		double num = 0.0, num1 = 0.0, num2 = 0.0;
                String temp = "";
                
		for(int i=0; i<postfix.length(); i++){
			Word = postfix.charAt(i);
                        
			if(Word == ' '){
                            num = Integer.parseInt(temp);
                            stack.push(num);
                            temp = "";
                        }else{
                            if(Word == '+' || Word == '-' || Word == '*' || Word == '/'){
				num2 = stack.pop();
				num1 = stack.pop();
				
				switch(Word){
				case '+' :
					stack.push(num1+num2);
					break;
				case '-' :
					stack.push(num1-num2);
					break;
				case '*' :
					stack.push(num1*num2);
					break;
				case '/' :
					stack.push(num1/num2);
					break;
				}
                            }else{
                                temp += Word;
                            }
                        }
		}
		
		System.out.println("결과값 : " + stack.pop());
	}
}
