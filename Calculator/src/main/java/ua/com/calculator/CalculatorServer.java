package ua.com.calculator;

import org.apache.log4j.Logger;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class CalculatorServer {
    final static Logger logger = Logger.getLogger(CalculatorServer.class);

    public static void main(String[] args) throws IOException {
        String input, output;
        int result;
        while (true) {
            logger.info("Enter infix: ");
            input = getString();
            if (input.equals(""))
                break;

            InToPost theTrans = new InToPost(input);
            output = theTrans.doTrans();
            logger.info("Postfix is " + output + '\n');
            ParsePost aParser = new ParsePost(output);
            result = aParser.doParse();
            logger.info("Evaluates to " + result);
        }
    }

    public static String getString() throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        String s = br.readLine();
        return s;
    }
}