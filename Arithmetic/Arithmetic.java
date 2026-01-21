import java.lang.Math;

public class Arithmetic {

	//Evaluates a String exp that has an arithmetic expression, written in classic notation
	public static int evaluate(String exp) {
		return 0;
	}
	
	//Returns the result of doing operand1 operation operand2,
	//e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		if(operation.equals("+")){
			return operand1 + operand2;
		} else if(operation.equals("-")){
			return operand1 - operand2;
		} else if(operation.equals("*")){
			return operand1 * operand2;
		} else if(operation.equals("/")){
			return operand1 / operand2;
		} else if(operation.equals("%")){
			return operand1 % operand2;
		} else if(operation.equals("^")){
			return (int) Math.pow(operand1, operand2);
		} else{
			throw new IllegalArgumentException("Invalid operation!");
		}
	}
	
	public static int isPriority(String op){
		if(op.equals("+")){
			return 4;
		} else if(op.equals("-")){
			return 4;
		} else if(op.equals("*")){
			return 5;
		} else if(op.equals("/")){
			return 5;
		} else if(op.equals("%")){
			return 5;
		} else if(op.equals("^")){
			return 6;
		} else{
			throw new IllegalArgumentException("Invalid operation!");
		}
	}

	public static boolean isOperator(String exp){
		if(exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("(") || exp.equals(")") || exp.equals("%") || exp.equals("^")){
			return true;
		} else{
			return false;
		}
	}

	//Evaluates a String exp that has an arithmetic expression written in STOUT notation
	public static int evaluateStout(String exp) {
		String[] thing = exp.split(" ");
		MyStack<Integer> operands = new MyStack<Integer>();
		for (int i = 0; i < operands.size(); i++) {
			if(!isOperator(thing[i])){
				operands.push(Integer.parseInt(thing[i]));
			} else{
				int operand1 = operands.pop();
				int operand2 = operands.pop();
				int newVal = operate(operand1, operand2, thing[i]);
				operands.push(newVal);
			}
		}

		return operands.pop();


	}
	
	public static String convertClassicToStout(String exp) {
		return "";
	}
	
	
}
