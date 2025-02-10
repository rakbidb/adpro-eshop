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
