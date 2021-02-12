/*
 * SymbolTableDriver.java
 * Author: Nicholas Kawwas
 * Completed: November, 2020
 * Purpose: Symbol Table Implementation with Ordered LL
*/

public class SymbolTableDriver {
    public static void main(String[] args) {
        SymbolTable<String, Double> st = new SymbolTable<>();

        st.put("A", 4.3);
        st.put("C", 4.0);
        st.put("B", 3.7);
        st.put("D", 3.3);
        st.put("E", 3.0);
        st.put("F", 2.67);
        st.put("H", 2.33);
        st.put("G", 2.0);
        st.put("I", 1.67);
        st.put("Z", 1.0);
        st.put("Y", 0.0);

        System.out.println(st.getValue("B")); //3.7
        System.out.println(st.getValue("D")); //3.3
        System.out.println(st.getValue("E")); //3.0

        System.out.println(st.min());
        System.out.println(st.max());

        st.deleteMin();
        st.deleteMax();

        System.out.println(st.rank("E"));
        System.out.println(st.select(4));

        System.out.println(st.ceiling("G"));
        System.out.println(st.floor("L"));

        st.printST();

    }
}
