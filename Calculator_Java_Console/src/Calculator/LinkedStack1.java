package Calculator;

public class LinkedStack1 implements Stack1{
	StackNode1 top;
	
	public LinkedStack1() {
		this.top = null;
	}

	@Override
	public boolean isEmpty() {
		return (top==null);
	}

	@Override
	public void push(double item) {
		StackNode1 node = new StackNode1();
		node.item = item;
		node.next = top;
		top = node;
	}

	@Override
	public double pop() {
		if(isEmpty()){
			System.out.println("스택이 비어있습니다.");
			return 0;
		}else{
			StackNode1 node = top;
			top = node.next;			
			return node.item;
		}
	}

	@Override
	public void delete() {
		if(isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}else{
			top = top.next;
		}
	}

	@Override
	public double peek() {
		if(isEmpty()){
			System.out.println("스택이 비어있습니다.");
			return 0;
		}else{
			return top.item;
		}
	}
	
	public void printStack() {
		if(isEmpty()){
			System.out.println("스택이 비어있습니다.");
		}else{
			StackNode1 node = top;
			System.out.println("<<Stack>>");
			while(node.next!=null){
				System.out.println(node.item);
				node = node.next;
			}
			System.out.println(node.item);
			System.out.println();
		}
	}
}