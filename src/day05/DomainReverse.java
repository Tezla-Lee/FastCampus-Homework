package day05;

public class DomainReverse {
    public static void main(String[] args) {
        String domain = "www.google.com";

        int lastDot = 0;
        for (int i = 0; i < domain.length(); i++) {
            if (domain.charAt(i) == '.') {
                String domainSplit = domain.substring(lastDot, i);
                char[] arr = domainSplit.toCharArray();
                lastDot = i;
                for (int j = 0; j < domainSplit.length(); j++) {
                    if (arr[domainSplit.length() - j - 1] == '.') {
                        continue;
                    }
                        char[] arrRev = new char[arr.length];
                        arrRev[j] = arr[arrRev.length - 1 - j];
                        System.out.print(arrRev[j]);
                }
                System.out.print('.');
            } else if (i == domain.length() - 1) {
                String domainSplit = domain.substring(lastDot + 1, domain.length());
                char[] arr = domainSplit.toCharArray();
                for (int j = 0; j < domainSplit.length(); j++) {
                    char[] arrRev = new char[arr.length];
                    arrRev[j] = arr[arrRev.length - 1 - j];
                    System.out.print(arrRev[j]);
                }
            }
        }
    }
}