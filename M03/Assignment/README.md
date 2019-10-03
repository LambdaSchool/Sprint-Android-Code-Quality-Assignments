# Android Unit Testing

For this app, you'll be building a simple, basic calculator that performs math operations. 
> You will also not be building a UI for this project.

## Steps

1. Build a `Calculator` class with a constructor injected parameter of type `Math` which is another class.  
2. Add two functions to the `Math` class, one to calculate the sum of squares of two numbers and the other to find the difference between the absolute values of two numbers. 

3. Write two functions in the `Calculator` functions to provide APIs to a client using the `Calculator` class. 
* The first function should be named `factorial` that accepts one parameter that calls the corresponding function in the `Math` class. 
* The second function should be named `difference` that accepts two parameters that calls the corresponding function in the `Math` class.

4. Write unit tests for verifying both the functions in the `Calculator` class.
* The unit tests should use a mock object for the `Math` class. 
* The unit tests should have mock implementation for the functions defined in the `Math` class.

5. Verify code coverage for your unit tests to see if the `Calculator` class is fully covered by the tests. 


#### Go Further (for the more curious)

* Learn what parameterized tests are write a function to check if a given number is a prime number. Now add parameterized tests to this function to verify the behavior of the function. 
Read more about parameterized tests here. 
https://github.com/junit-team/junit4/wiki/parameterized-tests  
https://blog.kotlin-academy.com/parametrized-tests-with-spek-e0e02d5766a
