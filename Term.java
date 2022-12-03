/**
 * @implNote uses Comparable<E>
 */
public class Term implements Comparable<Term> {
    private int coefficient;
    private int power;

    /**
     * @param c (coefficient)
     * @param p (power)
     */
    public Term(int c,int p) {
        coefficient = c;
        power = p;
    }

    /**
     * returns coefficient of the current term:
     */
    public int getCoefficient() {
        return coefficient;   
    }

    /**
     * sets coefficient of the current term:
     * @param newC
     */
    public void setCoefficient(int newC) {
        coefficient = newC;   
    }

    /**
     * returns power of the current term:
     */
    public int getPower() {
        return power;   
    }

    /**
     * sets power of the current term:
     * @param newP
     */
    public void setPower(int newP) {
        power = newP;   
    }

    /**
     * converts term to a string:
     */
    public String toString() {
        return coefficient + "x^" + power;   
    }

    /**
     * returns -1 if term is smaller.
     * returns 0 if term is identical.
     * returns 1 if term is bigger.
     * @param obj
     */
    public int compareTo(Term obj) {
        if (this.power > obj.power) {
            return -1;
        } else if (this.power < obj.power) {
            return 1; 
        } else {
            if (this.coefficient > obj.coefficient) {
                return -1;
            } else if (this.coefficient < obj.coefficient) {
                return 1;
            } else {
                return 0;
            }
        }
    }
}
