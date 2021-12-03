# Calculator
-This is a maven project made in eclipse IDE. 
-Main class is the Calculator which opens up a user interface, being able to use the calculator.
![Calculator](https://user-images.githubusercontent.com/95189863/144626005-302c3f25-939c-4860-a669-16e15ba0ff10.JPG)

-The idea is that the user is able to write an infix notation formula and using shunting yard algorithm we are able to produce
a postfix notation that is passed into RevPolishCalc() which is able to calculate it. 
-The user is able to also write a postfix notation formula and produce a result, using RevPolishCalc(), the way this function works
it uses a stack and pushes the answer whenever a operator is met. For example RevPolishCalc("2 2 + 3 -") will first push into a number
stack the numbers and whenever a operator is met in this case "+" a if statment is popping the latest 2 entries in the stack which 
are both 2. Then the operation 2 +2 is performed and now the new answer which is 4 is pushed onto the stack. Now the stack only contains
4 but we still have 3 and - left so we do the same thing until we hit minus, (4 - 3) which result will output 1.
