

class Program{
    public static int climb(int n, int[] mem){
        if(n == 0){
            return 1;
        }
        if(n < 0){
            return 0;
        }
        if(mem[n] != 0)
            return mem[n];

        int count = 0;
        count += climb(n- 1,mem);
        count += climb(n- 2,mem);
        mem[n] = count;
        return  mem[n];
    }
    public static void main(String[] args) {
        int number = 4;
        int[] mem = new int[100];
        System.out.println(climb(number,mem));
    }
}