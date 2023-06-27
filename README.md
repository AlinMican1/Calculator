# Calculator
Dynamic Calculator Developer | Expert in Reverse Polish and Infix Notation | TDD Advocate

I spearheaded the development of a robust calculator application that seamlessly handled both Reverse Polish Notation (RPN) and Infix Notation calculations, providing users with flexible input options. My implementation adhered to best practices, emphasizing the importance of test-driven development (TDD).

Before each class, I meticulously crafted comprehensive JUnit test cases, ensuring that the code and algorithms performed flawlessly. These tests served as a safety net, validating the accuracy and reliability of the calculator's functionalities.

To gain a clear understanding of the calculator's structure, I employed UML diagrams, enabling me to visualize and comprehend the intricate relationships between components. Additionally, I utilized SVN to establish a version-controlled repository, streamlining code updates and facilitating collaborative development.

To promote maintainability and ease of use, I diligently documented the codebase using Javadoc, enabling future developers and users to comprehend its inner workings effortlessly.

The calculator operated by utilizing a stack, further encapsulated into distinct stacks for numbers, operators, and strings. For Reverse Polish Notation calculations, the number stack was employed to accurately evaluate the user-inputted string. In contrast, Infix Notation calculations utilized the Shunting Yard algorithm, converting the infix expression into a postfix notation for subsequent evaluation by the RevPolishCalc() function.

By leveraging RevPolishCalc(), users could input postfix notation formulas and obtain accurate results. The function employed a stack, pushing operands onto it until encountering an operator. At that point, the necessary operands were popped, and the corresponding operation was performed, with the result being pushed back onto the stack. This iterative process continued until the final result was obtained.

The entire project adhered to the principles of TDD, with test cases meticulously written for each class, such as "EntryTest.java." This approach allowed for continuous testing and verification throughout the development process, fostering code quality and reliability.

Through my expertise in developing dynamic calculators, my proficiency in handling diverse notations, and my commitment to TDD practices, I successfully delivered a powerful tool that offers users flexibility and accuracy in mathematical calculations.
![Calculator](https://user-images.githubusercontent.com/95189863/144627894-465e66cf-74ff-411d-ba6b-f100aee354bc.JPG)

