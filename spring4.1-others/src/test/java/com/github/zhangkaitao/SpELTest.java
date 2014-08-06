package com.github.zhangkaitao;

import junit.framework.Assert;
import org.junit.Test;
import org.springframework.expression.Expression;
import org.springframework.expression.ExpressionParser;
import org.springframework.expression.spel.CompiledExpression;
import org.springframework.expression.spel.SpelCompilerMode;
import org.springframework.expression.spel.SpelParserConfiguration;
import org.springframework.expression.spel.ast.SpelNodeImpl;
import org.springframework.expression.spel.standard.SpelCompiler;
import org.springframework.expression.spel.standard.SpelExpression;
import org.springframework.expression.spel.standard.SpelExpressionParser;

/**
 * User: zhangkaitao
 * Date: 14-8-1
 * Time: 下午2:19
 * Version: 1.0
 */
public class SpELTest {
    @Test
    public void test() {
        SpelParserConfiguration configuration =
                new SpelParserConfiguration(SpelCompilerMode.MIXED, getClass().getClassLoader());
        SpelExpressionParser parser = new SpelExpressionParser(configuration);

        SpelExpression expression = parser.parseRaw("new String('haha')");
        Assert.assertEquals("haha", expression.getValue());

        //人工编译
        //或者使用expression.compileExpression();
        SpelCompiler spelCompiler = SpelCompiler.getCompiler(getClass().getClassLoader());
        CompiledExpression compiledExpression = spelCompiler.compile((SpelNodeImpl) expression.getAST());
        Assert.assertEquals("haha", compiledExpression.getValue(null, null));
    }
}
