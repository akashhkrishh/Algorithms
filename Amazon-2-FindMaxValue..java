import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;



class Result {

    /*
     * Complete the 'findMaxValue' function below.
     *
     * The function is expected to return a LONG_INTEGER.
     * The function accepts following parameters:
     *  1. INTEGER_ARRAY factor
     *  2. 2D_INTEGER_ARRAY data
     *  3. INTEGER x
     */

    public static long findMaxValue(List<Integer> factor, List<List<Integer>> data, int x) {
    // Write your code here
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i=0; i<factor.size();i++){
            Collections.sort(data.get(i),Collections.reverseOrder());
            for(int j=0;j<factor.get(i);j++){
                ans.add(data.get(i).get(j));
            }
        }
        Collections.sort(ans,Collections.reverseOrder());
        if(ans.size()<x){
            return -1;
        }
        long sum =0;
        for(int i=0;i<x;i++){
            sum+=ans.get(i);
        }
        return sum;
    }

}

public class Solution {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int factorCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> factor = IntStream.range(0, factorCount).mapToObj(i -> {
            try {
                return bufferedReader.readLine().replaceAll("\\s+$", "");
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        })
            .map(String::trim)
            .map(Integer::parseInt)
            .collect(toList());

        int dataRows = Integer.parseInt(bufferedReader.readLine().trim());
        int dataColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> data = new ArrayList<>();

        IntStream.range(0, dataRows).forEach(i -> {
            try {
                data.add(
                    Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" "))
                        .map(Integer::parseInt)
                        .collect(toList())
                );
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        });

        int x = Integer.parseInt(bufferedReader.readLine().trim());

        long result = Result.findMaxValue(factor, data, x);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
