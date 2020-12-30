The classes in `com.softwareag.calculator.parser.generated` are generated 
with the commands:
``` 
java -classpath "javacc.jar" jjtree Arithmetic.jjt
java -classpath "javacc.jar" javacc Arithmetic.jj
```
`Arithmetic.jj` is generated with the first command.

`ArithmeticDefaultVisitor` is manually modified to calculate the value 
from the abstract syntax tree that represents the arithmetic expression and moved 
to `com.softwareag.calculator.parser` package.
