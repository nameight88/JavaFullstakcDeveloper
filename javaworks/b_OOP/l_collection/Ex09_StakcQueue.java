package l_collection;
import java.util.*;
/*
 * 자료구조 스택과 큐
 * 
 *  - 스텍(LIFO) : Last In First Out
 *  - 큐(FIFO) : First In First In
 */
public class Ex09_StakcQueue {

	public static void main(String[] args) {
		Stack stack = new Stack();
		stack.push("A");
		stack.push("B");
		stack.push("C");
		stack.push("D");
		stack.push("E");
		while(!stack.empty()) {
			System.out.println(stack.pop());
		}
		
	}

}
