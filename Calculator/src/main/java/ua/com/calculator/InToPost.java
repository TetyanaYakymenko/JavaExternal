package ua.com.calculator;

class InToPost {
    private MyStack myStack;
    private String input;
    private String output = "";

    public InToPost(String in) {
        input = in;
        int stackSize = input.length();
        myStack = new MyStack(stackSize);
    }

    public String doTrans() {
        for (int j = 0; j < input.length(); j++) {
            char ch = input.charAt(j);
            switch (ch) {
                case '+':
                case '-':
                    gotOper(ch, 1);
                    break;
                case '*':
                case '/':
                    gotOper(ch, 2);
                    break;
                case '^':
                case 's':
                    gotOper(ch, 3);
                    break;
                case '(':
                    myStack.push(ch);
                    break;
                case ')':
                    gotParen(ch);
                    break;
                default:
                    output = output + ch;
                    break;
            }
        }
        while (!myStack.isEmpty()) {
            output = output + myStack.pop();
        }
        return output;
    }

    public void gotOper(char opThis, int prec1) {
        while (!myStack.isEmpty()) {
            char opTop = myStack.pop();
            if (opTop == '(') {
                myStack.push(opTop);
                break;
            } else
            {
                int prec2;
                if (opTop == '+' || opTop == '-') {
                    prec2 = 1;
                } else if (opTop == '*' || opTop == '/') {
                    prec2 = 2;
                } else {
                    prec2 = 3;
                }
                if (prec2 < prec1) {
                    myStack.push(opTop);
                    break;
                } else
                    output = output + opTop;
            }
        }
        myStack.push(opThis);
    }

    public void gotParen(char ch) {
        while (!myStack.isEmpty()) {
            char chx = myStack.pop();
            if (chx == '(')
                break;
            else
                output = output + chx;
        }
    }
}