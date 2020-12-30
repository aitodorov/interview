package com.softwareag.calculator.parser;

import com.softwareag.calculator.parser.generated.*;

/**
 * Visitor class that calculates the abstract syntax tree that
 * represents the original arithmetic expression.
 */
public class ArithmeticDefaultVisitor implements ArithmeticVisitor {
    public int visit(SimpleNode node, Object data) {
        throw new IllegalArgumentException();
    }

    public int visit(ASTStart node, Object data) {
        return node.jjtGetChild(0).jjtAccept(this, data);
    }

    public int visit(ASTAddExpr node, Object data) {
        int result = node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            result += node.jjtGetChild(i).jjtAccept(this, data);
        }
        return result;
    }

    public int visit(ASTSubractExpr node, Object data) {
        int result = node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            result -= node.jjtGetChild(i).jjtAccept(this, data);
        }
        return result;
    }

    public int visit(ASTMultiplyExpr node, Object data) {
        int result = node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            result *= node.jjtGetChild(i).jjtAccept(this, data);
        }
        return result;
    }

    public int visit(ASTDivideExpr node, Object data) {
        int result = node.jjtGetChild(0).jjtAccept(this, data);
        for (int i = 1; i < node.jjtGetNumChildren(); i++) {
            result /= node.jjtGetChild(i).jjtAccept(this, data);
        }
        return result;
    }

    public int visit(ASTInteger node, Object data) {
        return Integer.parseInt(node.jjtGetValue().toString());
    }
}