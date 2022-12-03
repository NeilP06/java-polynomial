# Polynomial.java
Polynomial.java provides a basic, working Polynomial and Term class using Comparable&lt;E>, and ListIterator&lt;E>, can be used in unique implementations. Listed below is the API of Polynomial.java:

**public void addTerm(int coefficient, int power)**
This method has the purpose to add a term to the end of a polynomial list, using two parameters to create the term. This is the backbone of Polynomial.java, where it can be used with remove(int index) to easily modify a polynomial.

**public Polynomial add(Polynomial p)**
This method has the purpose to add two polynomials together, in which this method returns the sum. This method can be used for more heavy polynomial computations, and in order to substract polynomials, use the inverse signs.

**public Term removeTerm(int index)**
This method give the user the ability to easily remove a term at the specified index and it proposes the same purpose as addTerm(int coefficient, int power): gives the ability to easily modify a polynomial.

**public Polynomial multiply(Polynomial p)**
This method has the purpose to multiply two polynomials together, in which the method reutrns the product. This method is useful when it comes to arbitrary computations, or computations that are more advanced.

**public Term getTerm(int index)**
This method gives the user the ability to fetch any term from a polynomial list (giving them the ability to store that term), and extends the usability of the Polynomial class.

**public int size()**
This method returns the size (i.e. the # of terms in the list) of a certain polynomial list, which can be useful in error checking scenarios or for certain method requirements.

**public void simplify()**
This method combines like terms in a polynomial list, and returns the simplified, sorted list, which can make many methods easier to program and can drive efficiency of those methods, too.

**public void sort()**
This method sorts the polynomial by comparing term powers, and sorting the terms from highest power to lowest power. This method is also another backbone of Polynomial.java.

**public String toString()**
This methods allows for the accessibility of the polynomial's private list by returning the polynomial as a string, expressed in the format of "4x^3 + 3x^2 + -1x^1" if the list is [4x^3 --> 3x^2 --> -1x^1]. Note that there is no special cases for terms with the coefficients of 1 or terms with negative coefficients (the format of the string is static).

**public int compareTo(Term other)**
This method takes a term parameter and uses the Term.java compareTo(Term obj) method to compare it with the first term of the polynomial list. Returns 1 if the polynomial term is bigger than the parameter term, returns 0 if the polynomial term is the exact same as the parameter term, and returns -1 if the polynomial term is smaller than the parameter term.

**public boolean equals(Object other)**
This method takes a polynomial parameter and compares it with the current polynomial. If both polynomials are the exact same, it returns true, otherwise returns false.

NOTE: use pull requests if there is a significant issue with the API, or if there is an efficiency boost with the suggestion.
