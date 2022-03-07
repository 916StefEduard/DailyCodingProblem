public class Mian {

        public static int sum(int number){
            int sum = 0;
            while(number != 0){
                sum += number % 10;
                number /= 10;
            }
            return sum;
        }

        public static int addDigits(int number){
            int sum = 0;
            while(number > 9){
                sum = sum(number);
                number = sum;
            }
            return number;
        }
        public static void main(String[] args){
            int number = 38;
            System.out.print(addDigits(number));
        }

}
