import java.util.*;

/**
 * @author Neil Purohit
 * @implNote uses ListIterator<E>, Comparable<E>, Term from Term.java
 */
public class Polynomial implements Comparable<Term> {
    // stores all polynomial terms and can be accessed for future use:
    LinkedList<Term> main = new LinkedList<Term>(); 
    
    /**
     * adds term to the current polynomial list:
     * @param coefficient
     * @param power
     */
    public void addTerm(int coefficient, int power) {
        Term term = new Term(coefficient, power);
        ListIterator<Term> iterator = main.listIterator();
        while (iterator.hasNext()) {
            iterator.next();
        }
        iterator.add(term);
    }

    /**
     * passes a polynomial through a parameter and the sum of both polynomials
     * are stored through another polynomial list:
     * @param p
     * @return sum of polynomials
     */
    public Polynomial add(Polynomial p) {
        Polynomial sum = new Polynomial();
        ListIterator<Term> mainIterator = main.listIterator();
        ListIterator<Term> secondaryIterator = p.main.listIterator();
        while (mainIterator.hasNext()) {
            Term term = mainIterator.next();
            sum.addTerm(term.getCoefficient(), term.getPower());
        }
        while (secondaryIterator.hasNext()) {
            Term term = secondaryIterator.next();
            sum.addTerm(term.getCoefficient(), term.getPower());
        }
        // calls simplify() method for organization:
        sum.simplify();
        return sum; 
    }

    /**
     * removes a certain term of the polynomial list (specified from the index parameter),
     * and throws an exception if the index is out of range:
     * @param index
     * @return removed term
     */
    public Term removeTerm(int index) {
        ListIterator<Term> iterator = main.listIterator();
        int count = 0;
        // calls size() for error checking to ensure no crashes:
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (iterator.hasNext() && count != index) {
            iterator.next();
            count++;
        }
        // stores removed term as a object:
        Term term = iterator.next();
        iterator.remove();
        return term;
    }

    /**
     * passes a polynomial through a parameter and the product of both polynomials
     * are stored through another polynomial list:
     * @param p
     * @return product of polynomials
     */
    public Polynomial multiply(Polynomial p) {
        Polynomial product = new Polynomial();
        ListIterator<Term> mainIterator = main.listIterator();
        ListIterator<Term> secondaryIterator = p.main.listIterator();
        while (mainIterator.hasNext()) {
            Term term1 = mainIterator.next();
            while (secondaryIterator.hasNext()) {
                Term term2 = secondaryIterator.next();
                product.addTerm(term1.getCoefficient() * term2.getCoefficient(), term1.getPower() + term2.getPower());
            }
            // avoids 
            secondaryIterator = p.main.listIterator();
        }
        // calls simplify() method for organization:
        product.simplify();
        return product;
    }

    /**
     * fetches a certain term of the polynomial list (specified from the index parameter),
     * and throws an exception if the index is out of range:
     * @param index
     * @return term
     */
    public Term getTerm(int index) {
        ListIterator<Term> iterator = main.listIterator();
        int count = 0;
        // calls size() for error checking to ensure no crashes:
        if (index > this.size()) {
            throw new IndexOutOfBoundsException();
        }
        while (iterator.hasNext() && count != index) {
            iterator.next();
            count++;
        }
        return iterator.next();
    }

    /**
     * returns the size of the current polynomial list:
     * @return size of polynomial list
     */
    public int size() {
        return main.size();
    }

    /**
     * simplifies a polynomial by combining like terms: 
     */
    public void simplify() {
        // calls sort() for efficiency and simplicity:
        this.sort();
        ListIterator<Term> mainIterator = main.listIterator();
        if (mainIterator.hasNext()) {
            Term term1 = mainIterator.next();
            ListIterator<Term> secondaryIterator = mainIterator;
            while (secondaryIterator.hasNext()) {
                Term term2 = secondaryIterator.next();
                if (term1.getPower() == term2.getPower()) {
                    term1.setCoefficient(term1.getCoefficient() + term2.getCoefficient());
                    secondaryIterator.remove();
                } else {
                    term1 = term2;
                }
            }
        }
    }

    /**
     * sorts the polynomial by using Collections.sort(), hence the implementation
     * of Comparable<E>:
     */
    public void sort() {
        Collections.sort(main);
    }

    /**
     * converts the polynomial into a string in the format of...
     * "4x^3 + 2x^2 + 1x^1 + -2x^0" if main = [4x^3, 2x^2, 1x^1, -2x^0],
     * used as a way to access the private list of a certain polynomial.
     * @return str
     */
    public String toString() {
        this.sort();
        ListIterator<Term> iterator = main.listIterator();
        String str = "";
        while (iterator.hasNext()) {
            Term term = iterator.next();
            str += " + " + term.toString();
        }
        // returns the str in the correct syntax:
        return str.substring(3, str.length());
    }

    /**
     * passes a term through a parameter and compares that term with the 
     * starting term of a polynomial and returns int...
     * 1. 1 if the starting term is bigger than the parameter term.
     * 2. 0 if the starting term is the same as the parameter term.
     * 3. -1 if the starting term is smaller than the parameter term.
     * @param other
     * @return 1, 0, -1
     */
    public int compareTo(Term other) {
        this.sort();
        ListIterator<Term> iterator = main.listIterator();
        Term term = iterator.next();
        // calls compareTo(Term other) from Term.java: 
        return term.compareTo(other);
    }

    /**
     * passes a polynomial through a parameter and compares the current polynomial
     * with the other, returning true if both polynomials are exactly identical and
     * false if the polynomials do not have the exact same terms:
     * @param other
     * @return true, false
     */
    public boolean equals(Object other) {
        Polynomial p = (Polynomial)other;
        // calls sort() to ensure polynomial order does not impact the result:
        this.sort();
        p.sort();
        // calls toString() for simplicity:
        if (this.toString().equals(p.toString())) {
            return true;
        } else {
            return false;
        }
    }
}
