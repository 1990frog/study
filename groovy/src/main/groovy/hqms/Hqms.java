package hqms;

import groovy.lang.Binding;
import groovy.lang.GroovyShell;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.testng.annotations.Test;

import java.math.BigDecimal;

/**
 * <p>
 *
 * </p>
 *
 * @author cai
 * @since 2022/5/7
 */

@Getter
@AllArgsConstructor
enum OPERATOR {

    func_contains("%s.contains('%s')"),
    func_ascii("((int)%s)"),
    func_substr("%s.substring(%s,%s)"),
    add("%s + %s"),
    gt("%s > %s");



    private String operator;
}

@Builder
class Expr {
    /**
     * 操作方式
     */
    OPERATOR operator;

    /**
     * 值（val1 or ref1）
     * todo List<Value>
     */
    String val1;
    String val2;
    String val3;

    /**
     * 开始套娃
     */
    Expr ref1;
    Expr ref2;
    Expr ref3;

    /**
     * 表达式，递给 groovy 执行
     */
    String groovyshell;
}

@Data
@Builder
class UserEntity {
    // 姓名
    private String name;
    // 年龄
    private Integer age;
    // 性别
    private Integer gender;
    // 数学分数
    private BigDecimal mathScore;
    // 中文分数
    private BigDecimal chineseScore;
    // 英文分数
    private BigDecimal englishScore;
    // 物理分数
    private BigDecimal physicsScore;
    // 化学分数
    private BigDecimal chemicalScore;
    // 班级
    private Integer dept;
}

@Slf4j
public class Hqms {

    /**
     * 递归组合 groovy 代码
     *
     * @param expr 根节点
     * @return
     */
    private Expr recursive(Expr expr) {

        if (expr == null)
            return null;
        /**
         * 递归终止条件
         */
        if (expr.ref1 == null && expr.ref2 == null && expr.ref3 == null) {
            expr.groovyshell = formula(expr.operator, expr.val1, expr.val2, expr.val3);
            return expr;
        }

        expr.ref1 = recursive(expr.ref1);
        expr.ref2 = recursive(expr.ref2);
        expr.ref3 = recursive(expr.ref3);
        expr.groovyshell = formula(expr.operator,
                expr.ref1 == null ? expr.val1 : expr.ref1.groovyshell,
                expr.ref2 == null ? expr.val2 : expr.ref2.groovyshell,
                expr.ref3 == null ? expr.val3 : expr.ref3.groovyshell);

        return expr;
    }

    private String formula(OPERATOR op, String val1, String val2, String val3) {
        switch (op) {
            case func_contains: {
                return String.format(op.getOperator(), val1, val2);
            }
            case func_ascii: {
                return String.format(op.getOperator(), val1);
            }
            case func_substr: {
                return String.format(op.getOperator(), val1, val2, val3);
            }
            case add: {
                return String.format(op.getOperator(), val1, val2);
            }
            case gt: {
                return String.format(op.getOperator(), val1, val2);
            }
        }
        return null;
    }

    @Test
    public void test() {
        /**
         * 公式1
         * contain(substr(User.name,0,1),'8')
         */
        Expr expr1 = Expr.builder() // 最外层函数 contain(fun2,"8")
                .operator(OPERATOR.func_contains)
                .ref1(Expr.builder()    // 最内层函数 substr(User.name,0,1)
                        .operator(OPERATOR.func_substr)
                        .val1("user.name")
                        .val2("0")
                        .val3("1").build())
                .val2("李")
                .build();
        /**
         * 公式2
         * user.age + 10 > user.dept
         */
        Expr expr2 = Expr.builder()
                .operator(OPERATOR.gt)
                .ref1(Expr.builder()
                        .operator(OPERATOR.add)
                        .val1("user.age")
                        .val2("10")
                        .build())
                .val2("user.dept")
                .build();

        /**
         * 递归组合 groovy 代码
         */
//        Expr expr = recursive(expr1);
        Expr expr = recursive(expr2);
        log.info("校验公式：{}", expr.groovyshell);

        /**
         * 数据
         */
        UserEntity user = UserEntity.builder()
                .name("李雷")
                .age(18)
                .gender(0)
                .chemicalScore(BigDecimal.valueOf(87))
                .chineseScore(BigDecimal.valueOf(96))
                .mathScore(BigDecimal.valueOf(50))
                .physicsScore(BigDecimal.valueOf(80))
                .englishScore(BigDecimal.valueOf(88))
                .dept(1)
                .build();

        Binding binding = new Binding();
        binding.setVariable("user", user);
        GroovyShell shell = new GroovyShell(binding);
        Object ret = shell.evaluate(expr.groovyshell);
        log.info("校验结果：{}", ret.toString());
    }

}
