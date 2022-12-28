public class FindPrimes {

    public static void main(String[] args) {
        System.out.println("Max = " + args[0]);
        int max = Integer.parseInt(args[0]);

        //Print the Prime numbers that are less than max
        //1.for each number less than max
        for(int number = 2; number < max; number++) {
            //1.1 check the number is prime
            int divisor = 2; //Let divisor = 2;
            boolean isPrime = true; //Let isPrime = true;
            while (divisor < number && isPrime) { // While divisor is less than number and isPrime is true
                if (number % divisor == 0) { //If the number is divisible by divisor
                    isPrime = false; //isPrime = false
                }
                divisor ++; //increment divisor;
            }
            if (isPrime) //1.2 if the number is prime
                System.out.print(number+ ","); //1.2.1 print
        }
    }





}
