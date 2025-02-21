#### Nama    : Rakha Abid Bangsawan
#### NPM     : 2206081585
#### Kelas   : Pemrograman Lanjut B

---

# TUTORIAL

---
# Tutorial 1

### Reflection 1

You already implemented two new features using Spring Boot. Check again your source code and evaluate the coding standards that you have learned in this module. Write clean code principles and secure coding practices that have been applied to your code.  If you find any mistake in your source code, please explain how to improve your code. Please write your reflection inside the repository's README.md file.

**Answer:** 

I have implemented some clean code principles in this tutorial:
- Variables written by me are all descriptive;
- Each functions/methods has one purpose only;
- There are no complex block of codes. So, I don't use comments because they're all explanatory and descriptive.

Some mistakes I found in the code:
- Edit Product uses @PostMapping, even though it should be using PUT. I tried to use PUT but the code couldn't work properly because for some reason I couldn't state the form method to be PUT (I could only use GET)
- Like Edit Product, Delete Product also uses @PostMapping even though @DeleteMapping exists. The reason is similar, I couldn't set the form's method to Delete (for some reason it always use the POST method)

### Reflection 2
1. After writing the unit test, how do you feel? How many unit tests should be made in a class? How to make sure that our unit tests are enough to verify our program? It would be good if you learned about code coverage. Code coverage is a metric that can help you understand how much of your source is tested. If you have 100% code coverage, does that mean your code has no bugs or errors?

   **Answer:**

   Writing unit tests can provide a sense of assurance and confidence in my code. It ensures that my code behaves as expected under different scenarios. Successful unit tests can be satisfying, knowing that my code is covered by tests that help catch potential issues. There shouldn't be a fixed number of how many test should be mae. The goal is to have enough tests to cover different cases, including edge cases and common scenarios. Code coverage is a useful metric to understand how much of my code is tested by my unit tests. However, having 100% code coverage does not guarantee that my code is free of bugs or errors. It only means that every line of code has been executed during my tests. To ensure the test we should cover different scenarios and review the codes we've written.

2. Suppose that after writing the CreateProductFunctionalTest.java along with the corresponding test case, you were asked to create another functional test suite that verifies the number of items in the product list. You decided to create a new Java class similar to the prior functional test suites with the same setup procedures and instance variables.
   What do you think about the cleanliness of the code of the new functional test suite? Will the new code reduce the code quality? Identify the potential clean code issues, explain the reasons, and suggest possible improvements to make the code cleaner!

   **Answer:**

   Some of the code cleanliness concern i can think is that it may cause duplicates and the codes are not independent anymore

---
# Tutorial 2
Code quality issues I've identified include the need to eliminate the public modifier from tests due to deprecation. To enhance adaptability, a test case should be added to the main app test class. Consistency should be improved by transitioning from @Autowired field injection to method injection. I've also removed several unused imports from the code base.

In terms of Continuous Integration and Continuous Deployment (CI/CD), the project aligns with these principles. Three workflows (ci, scorecard, and sonarcloud) exist, each containing specific jobs with custom commands for automated tasks, mainly focused on testing. The workflows are triggered automatically after push or pull requests, demonstrating a well-implemented CI/CD process.

---