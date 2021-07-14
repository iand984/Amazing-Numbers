package numbers;

import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        List<String> numbers = new ArrayList<String>();

        System.out.println("Welcome to Amazing Numbers!");
        System.out.println("Supported requests:");
        System.out.println("- enter a natural number to know its properties;");
        System.out.println("- enter two natural numbers to obtain the properties of the list:");
        System.out.println("  * the first parameter represents a starting number;");
        System.out.println("  * the second parameter shows how many consecutive numbers are to be printed;");
        System.out.println("- two natural numbers and  properties to search for;");
        System.out.println("- a property preceded by minus must not be present in numbers;");
        System.out.println("- separate the parameters with one space;");
        System.out.println("- enter 0 to exit.");

        System.out.print("Enter a request: ");

        String line = scanner.nextLine();
        List<String> strings = Arrays.asList(line.split(" "));
        for (String s : strings) {
            numbers.add(s);
        }


        while (Long.parseLong(numbers.get(0)) != 0) {
            if (numbers.size() == 1) {
                inputSizeOne(numbers.get(0));
            } else if (numbers.size() == 2) {
                inputSizeTwo(numbers);
            } /*else if (numbers.size() == 3) {
                inputSizeThree(numbers);
            } else if (numbers.size() == 4) {
                inputSizeFour(numbers);
            } */ else {
                inputSizePlus(numbers);
            }
            numbers = new ArrayList<>();
            System.out.print("Enter a request: ");
            line = scanner.nextLine();
            strings = Arrays.asList(line.split(" "));
            for (String s : strings) {
                numbers.add(s);
            }
        }
        System.out.println("Goodbye!");
    }


    public static void inputSizeOne(String number) {

        if (isNegativeNumber(Long.parseLong(number))) {
            System.out.println("The first parameter should be a natural number or zero.");
        } else {
            properties(Long.parseLong(number));
        }
    }

    private static void inputSizeTwo(List<String> numbers) {

        long a = Long.parseLong(numbers.get(0));
        long b = Long.parseLong(numbers.get(1));

        if (isNegativeNumber(a) || isNegativeNumber(b)) {
            System.out.printf("%s%n", isNegativeNumber(a) ? "The first parameter should be a natural number or zero." : "The second parameter should be a natural number.");
        } else if (a == 0) {
            System.out.println("Goodbye");
        } else {
            for (; b >= 1; b--) {
                commonOutput(a);
                a++;
            }
        }

    }

    private static void inputSizePlus(List<String> numbers) {
        long a = Long.parseLong(numbers.get(0));
        long b = Long.parseLong(numbers.get(1));
        List<String> wrongTypes = new ArrayList<>();
        List<String> types = numbers.subList(2, numbers.size());
        List<String> standardTypes = new ArrayList<>(Arrays.asList("DUCK", "BUZZ", "PALINDROMIC", "GAPFUL", "SPY", "EVEN", "ODD"
                , "SUNNY", "SQUARE", "JUMPING", "HAPPY", "SAD", "-DUCK", "-BUZZ", "-PALINDROMIC", "-GAPFUL", "-SPY", "-EVEN", "-ODD"
                , "-SUNNY", "-SQUARE", "-JUMPING", "-HAPPY", "-SAD"));
        for (String type : types) {
            if (!standardTypes.contains(type.toUpperCase())) {
                wrongTypes.add(type);
            }
        }
        if (wrongTypes.size() == 0) {
            givePropertiesSizeFiveOrMore(a, b, types);
        } else {
            System.out.printf("The propert%s ", wrongTypes.size() == 1 ? "y" : "ies");
            for (String s : wrongTypes) {
                System.out.printf("%s ", s);
            }
            System.out.printf("%s wrong.%nAvailable properties: [BUZZ, DUCK, PALINDROMIC, GAPFUL, SPY, SQUARE, SUNNY, EVEN, ODD, JUMPING, HAPPY, SAD]%n", wrongTypes.size() == 1 ? "is" : "are");
        }
    }

    private static void givePropertiesSizeFiveOrMore(long a, long b, List<String> types) {
        List<Long> numbers = new ArrayList<>();
        for (String type : types) {
            type.toUpperCase(Locale.ROOT);
        }

        if (isNegativeNumber(a) || isNegativeNumber(b)) {
            System.out.printf("%s%n", isNegativeNumber(a) ? "The first parameter should be a natural number or zero." : "The second parameter should be a natural number.");
        } else if (a == 0) {
            System.out.println("Goodbye");
        } else if (types.contains("odd") && types.contains("even")) {
            System.out.println("The request contains mutually exclusive properties: ODD EVEN \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("-odd") && types.contains("-even")) {
            System.out.println("The request contains mutually exclusive properties: -ODD -EVEN \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("duck") && types.contains("spy")) {
            System.out.println("The request contains mutually exclusive properties: DUCK SPY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("-duck") && types.contains("-spy")) {
            System.out.println("The request contains mutually exclusive properties: -DUCK -SPY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("square") && types.contains("sunny")) {
            System.out.println("The request contains mutually exclusive properties: SQUARE SUNNY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("-square") && types.contains("-sunny")) {
            System.out.println("The request contains mutually exclusive properties: -SQUARE -SUNNY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("odd") && types.contains("-odd")) {
            System.out.println("The request contains mutually exclusive properties: -ODD ODD \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("even") && types.contains("-even")) {
            System.out.println("The request contains mutually exclusive properties: -EVEN EVEN \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("buzz") && types.contains("-buzz")) {
            System.out.println("The request contains mutually exclusive properties: -BUZZ BUZZ \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("duck") && types.contains("-duck")) {
            System.out.println("The request contains mutually exclusive properties: -DUCK DUCK \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("palindromic") && types.contains("-palindromic")) {
            System.out.println("The request contains mutually exclusive properties: -PALINDROMIC PALINDROMIC \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("gapful") && types.contains("-gapful")) {
            System.out.println("The request contains mutually exclusive properties: -GAPFUL GAPFUL \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("spy") && types.contains("-spy")) {
            System.out.println("The request contains mutually exclusive properties: -SPY SPY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("sunny") && types.contains("-sunny")) {
            System.out.println("The request contains mutually exclusive properties: -SUNNY SUNNY \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("square") && types.contains("-square")) {
            System.out.println("The request contains mutually exclusive properties: -SQUARE SQUARE \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("jumping") && types.contains("-jumping")) {
            System.out.println("The request contains mutually exclusive properties: -JUMPING JUMPING \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("sad") && types.contains("-sad")) {
            System.out.println("The request contains mutually exclusive properties: -SAD SAD \n" +
                    "There are no numbers with these properties.");
        } else if (types.contains("happy") && types.contains("-happy")) {
            System.out.println("The request contains mutually exclusive properties: -HAPPY HAPPY \n" +
                    "There are no numbers with these properties.");
        } else {
            numbers = determineCorrectCasesThreeOrMoreTypes(types, a, b);
            if (numbers.size() == 0) {
                System.out.printf("The request contains mutually exclusive properties: %n" +
                        "There are no numbers with these properties.");
            } else {
                for (long n : numbers) {
                    commonOutput(n);
                }
            }
        }

    }


    private static List<Long> determineCorrectCasesThreeOrMoreTypes(List<String> types, long a, long b) {

        List<Long> numbers = new ArrayList<>();
        List<Long> numbers1 = new ArrayList<>();

        do {
            for (String type : types) {
                calculateCases(type, a, numbers1);
            }
            if (numbers1.size() == types.size()) {
                numbers.add(a);
                numbers1.clear();
                b--;
            }
            a++;
            numbers1.clear();

        } while (b >= 1);
        return numbers;
    }

    private static void calculateCases(String type1, long a, List<Long> numbers1) {
        switch (type1.toUpperCase()) {
            case "BUZZ":
                if (isBuzzNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "DUCK":
                if (isDuckNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "PALINDROMIC":
                if (isPalindrome(a)) {
                    numbers1.add(a);
                }
                break;
            case "GAPFUL":
                if (isGapeFul(a)) {
                    numbers1.add(a);
                }
                break;
            case "SPY":
                if (isSpyNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "EVEN":
            case "-ODD":
                if (isEvenNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "ODD":
            case "-EVEN":
                if (!isEvenNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "SQUARE":
                if (isSquare(a)) {
                    numbers1.add(a);
                }
                break;
            case "SUNNY":
                if (isSunny(a)) {
                    numbers1.add(a);
                }
                break;
            case "JUMPING":
                if (isJumping(a)) {
                    numbers1.add(a);
                }
                break;
            case "HAPPY":
            case "-SAD":
                if (isHappy(a)) {
                    numbers1.add(a);
                }
                break;
            case "SAD":
            case "-HAPPY":
                if (!isHappy(a)) {
                    numbers1.add(a);
                }
                break;
            case "-BUZZ":
                if (!isBuzzNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "-DUCK":
                if (!isDuckNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "-PALINDROMIC":
                if (!isPalindrome(a)) {
                    numbers1.add(a);
                }
                break;
            case "-GAPFUL":
                if (!isGapeFul(a)) {
                    numbers1.add(a);
                }
                break;
            case "-SPY":
                if (!isSpyNumber(a)) {
                    numbers1.add(a);
                }
                break;
            case "-SQUARE":
                if (!isSquare(a)) {
                    numbers1.add(a);
                }
                break;
            case "-SUNNY":
                if (!isSunny(a)) {
                    numbers1.add(a);
                }
                break;
            case "-JUMPING":
                if (!isJumping(a)) {
                    numbers1.add(a);
                }
                break;
            default:
                break;
        }
    }

    private static void commonOutput(long a) {
        System.out.printf("%d is %s%s%s%s%s%s%s%s%s%s", a, isBuzzNumber(a) ? "buzz, " : "", isDuckNumber(a) ? "duck, " : ""
                , isPalindrome(a) ? "palindrome, " : "", isGapeFul(a) ? "gapful, " : "", isSpyNumber(a) ? "spy, " : "",
                isEvenNumber(a) ? "even, " : "odd, ", isSquare(a) ? "square, " : "", isSunny(a) ? "sunny, " : "", isJumping(a) ? "jumping, " : "", isHappy(a) ? "happy" : "sad");
        System.out.println();
    }


    public static void properties(long number) {


        System.out.printf("Properties of %d%n", number);
        System.out.printf("         even: %s%n", isEvenNumber(number));
        System.out.printf("          odd: %s%n", !isEvenNumber(number));
        System.out.printf("         buzz: %s%n", isBuzzNumber(number));
        System.out.printf("         duck: %s%n", isDuckNumber(number));
        System.out.printf("  palindromic: %s%n", isPalindrome(number));
        System.out.printf("       gapful: %s%n", isGapeFul(number));
        System.out.printf("          spy: %s%n", isSpyNumber(number));
        System.out.printf("        sunny: %s%n", isSunny(number));
        System.out.printf("       square: %s%n", isSquare(number));
        System.out.printf("      jumping: %s%n", isJumping(number));
        System.out.printf("        happy: %s%n", isHappy(number));
        System.out.printf("          sad: %s%n", !isHappy(number));

    }


    public static boolean isPalindrome(long number) {
        String numberString = String.valueOf(number);
        int length = numberString.length();
        String reverse = "";

        for (int i = length - 1; i >= 0; i--) {
            reverse += numberString.charAt(i);
        }

        return reverse.equals(numberString);

    }

    private static boolean isNegativeNumber(long nextLong) {
        return nextLong < 0;
    }

    private static boolean isEvenNumber(long number) {
        return number % 2 == 0;
    }

    private static boolean isBuzzNumber(long number) {
        return number % 7 == 0 || number % 10 == 7;
    }

    private static boolean isDuckNumber(long number) {
        String duckNumber = String.valueOf(number);
        for (int i = 1; i < duckNumber.length(); i++) {
            if (duckNumber.charAt(i) == '0') {
                return true;
            }
        }
        return false;
    }

    private static boolean isGapeFul(long number) {
        StringBuilder stringNumber = new StringBuilder(String.valueOf(number));
        char a = stringNumber.charAt(0);
        char b = stringNumber.charAt(stringNumber.length() - 1);
        StringBuilder newNumber = new StringBuilder().append(a).append(b);
        long test = Long.parseLong(String.valueOf(newNumber));

        if (number < 100) {
            return false;
        } else return number % test == 0;
    }

    private static boolean isSpyNumber(long number) {

        List<Long> numbers = new ArrayList<>();
        int sum = 0;
        int product = 1;

        while (number > 0) {
            numbers.add(number % 10);
            number /= 10;
        }

        for (long n : numbers) {
            sum += n;
            product *= n;
        }

        return sum == product;
    }

    private static boolean isSquare(long number) {
        int sqrt = (int) Math.sqrt((int) number);

        if (sqrt * sqrt == (int) number) {
            return true;
        }
        return false;
    }

    private static boolean isSunny(long number) {

        return Math.sqrt(number + 1) % 1 == 0;
    }

    private static boolean isJumping(long number) {

        String stringNumber = String.valueOf(number);
        if (number > 10) {
            for (int i = 1; i < stringNumber.length(); i++) {
                if ((int) stringNumber.charAt(i - 1) != (int) stringNumber.charAt(i) + 1 && (int) stringNumber.charAt(i - 1) != (int) stringNumber.charAt(i) - 1) {
                    return false;
                }
            }
        }
        return true;
    }

    private static boolean isHappy(long number) {
        List<Integer> numbers = new ArrayList<>();
        String stringNumber = String.valueOf(number);
        long newNumber = 0;
        do {
            newNumber = 0;
            for (int i = 0; i < stringNumber.length(); i++) {

                numbers.add(Character.getNumericValue(stringNumber.charAt(i)));
            }

            for (int n : numbers) {
                newNumber += (n * n);
            }

            numbers.clear();
            stringNumber = String.valueOf(newNumber);
        } while (newNumber >= 10);

        if (number == 1 || newNumber == 1) {
            return true;
        }
        return false;


    }
}