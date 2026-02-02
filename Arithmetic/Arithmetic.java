import java.lang.Math;
import java.lang.StringBuilder;

public class Arithmetic {

	// Evaluates a String exp that has an arithmetic expression, written in classic
	// notation
	public static int evaluate(String exp) {
		return evaluateStout(convertClassicToStout(exp));
	}

	// Returns the result of doing operand1 operation operand2,
	// e.g. operate(5, 2, "-") should return 3
	public static int operate(int operand1, int operand2, String operation) {
		if (operation.equals("+")) {
			return operand1 + operand2;
		} else if (operation.equals("-")) {
			return operand1 - operand2;
		} else if (operation.equals("*")) {
			return operand1 * operand2;
		} else if (operation.equals("/")) {
			return operand1 / operand2;
		} else if (operation.equals("%")) {
			return operand1 % operand2;
		} else if (operation.equals("^")) {
			return (int) Math.pow(operand1, operand2);
		} else {
			throw new IllegalArgumentException("Invalid operation!");
		}
	}

	public static int isPriority(String op) {
		if (op.equals("+")) {
			return 4;
		} else if (op.equals("-")) {
			return 4;
		} else if (op.equals("*")) {
			return 5;
		} else if (op.equals("/")) {
			return 5;
		} else if (op.equals("%")) {
			return 5;
		} else if (op.equals("^")) {
			return 6;
		} else if (op.equals("(")) {
			return 8;
		} else if (op.equals(")")) {
			return 8;
		} else {
			throw new IllegalArgumentException("Invalid operation!");
		}
	}

	public static boolean isOperator(String exp) {
		if (exp.equals("+") || exp.equals("-") || exp.equals("*") || exp.equals("/") || exp.equals("(")
				|| exp.equals(")") || exp.equals("%") || exp.equals("^")) {
			return true;
		} else {
			return false;
		}
	}

	// Evaluates a String exp that has an arithmetic expression written in STOUT
	// notation
	public static int evaluateStout(String exp) {
		String[] thing = exp.split(" ");
		MyStack<Integer> operands = new MyStack<Integer>();
		for (int i = 0; i < thing.length; i++) {
			if (!isOperator(thing[i])) {
				operands.push(Integer.parseInt(thing[i]));
			} else {
				int operand2 = operands.pop();
				int operand1 = operands.pop();
				int newVal = operate(operand1, operand2, thing[i]);
				operands.push(newVal);
			}
		}

		return operands.pop();

	}

	public static String convertClassicToStout(String exp) {
		StringBuilder toReturn = new StringBuilder("");
		String[] thing = exp.split(" ");
		MyStack<String> operators = new MyStack<String>();
		int priority = 0;
		for (int i = 0; i < thing.length; i++) {
			if (!(isOperator(thing[i]))) {
				toReturn.append(thing[i]);
				toReturn.append(" ");
			} else {
				if (thing[i].equals(")")) {
					while (!(operators.peek().equals("("))) {
						toReturn.append(operators.pop());
						toReturn.append(" ");
					}
					operators.pop();
				} else if ((isPriority(thing[i]) > priority) || operators.peek().equals("(")) {
					priority = isPriority(thing[i]);
					operators.push(thing[i]);
				} else {
					if (isPriority(thing[i]) <= priority) {
						while (!operators.empty() && !operators.peek().equals("(")) {
							toReturn.append(operators.pop());
							toReturn.append(" ");
						}
						operators.push(thing[i]);
						priority = isPriority(operators.peek());
					}
				}
			}
		}
		while (!operators.empty()) {
			toReturn.append(operators.pop());
			toReturn.append(" ");
		}
		return toReturn.toString();
	}

}
