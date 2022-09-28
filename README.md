# Calculator
Created a calculator that utilised 'Reverse Polish notation' and 'Infix notation' to calculate a string inputted by the user. Test cases in JUNIT were written before each class to ensure the code and algorithm worked. UML diagrams were used to understand the structure of the calculator , SVN was used to make a repository to deliver updates of the working code and javadoc was used to document it. The program works by using a stack which is further "facade" into more stacks that takes a numbers, operators and strings. The reverse polish uses the number stack to calculate a string written and the infix uses shunting yard algorithm to calculate an infix string.
![Calculator](https://user-images.githubusercontent.com/95189863/144627894-465e66cf-74ff-411d-ba6b-f100aee354bc.JPG)

-The idea is that the user is able to write an infix notation formula and using shunting yard algorithm we are able to produce
a postfix notation that is passed into RevPolishCalc() which is able to calculate it. 
-The user is able to also write a postfix notation formula and produce a result, using RevPolishCalc(), the way this function works
it uses a stack and pushes the answer whenever a operator is met. For example RevPolishCalc("2 2 + 3 -") will first push into a number
stack the numbers and whenever a operator is met in this case "+" a if statment is popping the latest 2 entries in the stack which 
are both 2. Then the operation 2 +2 is performed and now the new answer which is 4 is pushed onto the stack. Now the stack only contains
4 but we still have 3 and - left so we do the same thing until we hit minus, (4 - 3) which result will output 1.

The project was done using TDD, because I wanted to get used to using test cases in JUNIT, so every class that has Test at the end e.g "EntryTest.java"
is a test case for that certain class, being able to test case as i go along.

