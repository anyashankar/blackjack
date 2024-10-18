public class arrayHelpers {

    public static int[] Addition(int[]a, int b){
        int c = a.length;
        int n[] = new int[c + 1];
        for (int i = 0; i < c; i ++){
            n[i] = a[i];
        }
        n[c] = b;
        return n;
    }

    public static int[] Remove(int[]a){
        int b = a.length;
        int n[] = new int[b - 1];
        for (int i = 0; i < b - 1; i ++){
            n[i] = a[i];
        }
        return n;
    }

    public static int[] Add(int[]a, int b, int d){
        int c = a.length;
        int n[] = new int[c + 1];
        for (int i = 0; i < c + 1; i ++){
            if (i == d){
                n[i] = b;
            }
            else if(i < d)
                n[i] = a[i];
            else
                n[i] = a[i-1];
        }
        return n;
    }

    public static int[] Remove(int[]a, int b){
        int c = a.length;
        int n[] = new int[c - 1];
        for (int i = 0; i < c - 1; i ++){
            if (i == b){
                n[i] = a[i + 1];
            }
            else if (i < b)
                n[i] = a[i];
            else
                n[i] = a[i+1];
        }
        return n;
    }

    public static int[] replace(int[]a, int b, int c){
        int d = a.length;
        int n[] = new int[d];
        for (int i = 0; i < d; i ++) {
            if (i == c) {
                n[i] = b;
            }
            else
                n[i] = a[i];
        }
        return n;
    }

    public static void Display(int[]a){

        for (int temp: a)
            System.out.print(temp + " ");
    }

    public static void reverseArray(int[] a){
        int[]n = new int[a.length];
        for (int i = 0; i < a.length; i ++){
            n[i] = a[a.length - 1 - i];
        }
        System.out.println("");
        System.out.println(n);
    }

    public static boolean InArray(int[]a, int b){
        boolean e = false;
        int n[] = new int[a.length];
        for (int i = 0; i < a.length ; i ++){
            if (a[i] == b)
                e = true;
        }
        return e;
    }

    public static int Number(int[]a, int b){
        int count = 0;
        for ( int i = 0; i < a.length; i ++ ){
            if (a[i] == b){
                count = count + 1;
            }
        }
        return count;
    }
}

