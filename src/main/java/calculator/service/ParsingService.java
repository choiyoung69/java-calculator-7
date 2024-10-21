package calculator.service;

import calculator.domain.Delimiters;
import calculator.domain.Operands;

import static calculator.utils.Constants.*;
import static calculator.validators.InvalidInputStringFormatException.errorCheck;

public class ParsingService {
    public static Operands parseOperandStr(String operandStr) {
        Delimiters delimiters = new Delimiters();
        Operands operands = new Operands();

        if(checkIFStringEmpty(operandStr)){
            operands.addOperand("0");
            return operands;
        }

        errorCheck(operandStr);
        operandStr = parseCustomDelimiter(operandStr, delimiters);
        parse(operandStr, delimiters, operands);

        return operands;
    }

    //입력받은 문자열이 없을 때 true return
    private static Boolean checkIFStringEmpty(String operandStr){
        if(operandStr == null || operandStr.isEmpty()) return true;
        return false;
    }

    //customDelimiter 분리
    private static String parseCustomDelimiter(String operandStr, Delimiters delimiters){
        //custom 구분자 추출
        if(operandStr.startsWith(CUSTOM_DELIMITER_START_WRAPPER)){



            delimiters.addCustomDelimiter(operandStr.charAt(CUSTOM_DELIMITER_INDEX));
            operandStr = operandStr.substring(EXCEPT_CUSTOM_DELIMITER_INDEX);
        }
        return operandStr;
    }

    //구분자에 따라 문자열을 분리하는 기능
    private static void parse(String operandStr, Delimiters delimiters, Operands operands){
        String regex = delimiters.createRegexFromDelimiters();

        String[] tokens = operandStr.split(regex);
        for (String token : tokens) {
            operands.addOperand(token);
        }
    }
}
