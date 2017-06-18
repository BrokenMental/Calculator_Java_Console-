package Calculator;

public class Formula {
	private String exp;
	private int expSize;
	private char temp, openPair;
        String str = "";

	public boolean Same(String exp){
		this.exp = exp;
		LinkedStack2 stack = new LinkedStack2();
		expSize = this.exp.length();

		for(int i=0; i<expSize; i++){
			temp = exp.charAt(i);

			switch(temp){
			case '(' :
			case '[' :
			case '{' :
				stack.push(temp);
				break;
			case ')' :
			case ']' :
			case '}' :
				if(stack.isEmpty()){
					return false;
				}else{
					openPair = stack.pop();
					if((openPair==')') && (temp!='(') || 
					   (openPair==']') && (temp!='[') || 
					   (openPair=='}') && (temp!='{')){
						return false;

					}else{
						break;
					}
				}
			}
		}

		if(stack.isEmpty()){
			return true;
		}else{
			return false;
		}
	}
	
	public String toPostfix(String infix){
		char testCh;
		exp = infix;
		int expSize = exp.length();
		LinkedStack2 stack = new LinkedStack2();
		
		for(int i=0; i<expSize; i++){
			testCh = exp.charAt(i);
			
			switch(testCh){
			case '0' :
			case '1' :
			case '2' :
			case '3' :
			case '4' :
			case '5' :
			case '6' :
			case '7' :
			case '8' :
			case '9' :
				System.out.print(testCh);
                                str += Character.toString(testCh);
				break;
			case '+' :
			case '-' :
			case '/' :
			case '*' :
				stack.push(testCh);
				System.out.print(" ");
                                str += " ";
				break;
			case ')' :
                                char temp = stack.pop();
				System.out.print(" "+temp);
                                str += " " + Character.toString(temp);
				break;
			default:
			}
		}
                System.out.print(" ");
		str += " ";
		while(!stack.isEmpty()){
                        char temp = stack.pop();
                        System.out.print(temp);
                        str += Character.toString(temp);
		}
		System.out.println();
                return str;
	}
}
