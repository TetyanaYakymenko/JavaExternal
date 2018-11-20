package ua.com.calculator;

import org.apache.log4j.Logger;

import java.util.Stack;

class ParsePost {
    private Stack<Integer> stack;
    private String input;

    public ParsePost(String s) {
        input = s;
    }

    public int doParse() {
        stack = new Stack();
        char ch;
        int j;
        int num1, num2, interAns;
        for (j = 0; j < input.length(); j++) {
            ch = input.charAt(j);
            if (ch >= '0' && ch <= '9')
                stack.push((int) (ch - '0'));
            else {
                num2 = stack.pop();
                switch (ch) {
                    case '+':
                        num1 = stack.pop();
                        interAns = num1 + num2;
                        break;
                    case '-':
                        num1 = stack.pop();
                        interAns = num1 - num2;
                        break;
                    case '*':
                        num1 = stack.pop();
                        interAns = num1 * num2;
                        break;
                    case '/':
                        num1 = stack.pop();
                        interAns = num1 / num2;
                        break;
                    case '^':
                        num1 = stack.pop();
                        interAns = (int) Math.pow(num1, num2);
                        break;
                    case 's':
                        interAns = (int) Math.sin(num2);
                        break;
                    default:
                        interAns = 0;
                }
                stack.push(Integer.valueOf(interAns));
            }
        }
        interAns = stack.pop();
        return interAns;
    }

    public void displayStack(Stack<Integer> stack, String s, Logger logger) {
        logger.info(s);
        for (int i = 0; i < stack.size(); i++) {
            logger.info(stack.get(i));
        }
        logger.info("\n");
    }
}
