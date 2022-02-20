package problem_solving;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;

class GradingStudentsResult {

    /*
     * Complete the 'gradingStudents' function below.
     *
     * The function is expected to return an INTEGER_ARRAY.
     * The function accepts INTEGER_ARRAY grades as parameter.
     */

    public static List<Integer> gradingStudents(List<Integer> grades) {
        ListIterator<Integer> iter = grades.listIterator();
        while(iter.hasNext()) {
            Integer grade = iter.next();
            if (grade >= 38) {
                Integer nextMulOfFive = determineNextMultipleOfFiveFor(grade);
                Integer diff = nextMulOfFive - grade;
                if (diff < 3) {
                    iter.set(nextMulOfFive);
                }
            }
        }
        return grades;
    }
    
    private static Integer determineNextMultipleOfFiveFor(Integer grade) {
        int unit = grade % 10;
        int quot = grade / 10;
        if (unit < 5) {
            return (quot * 10) + 5;
        } else {
            return (++quot * 10);
        }
    }

}

public class GradingStudents {
    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gradesCount = Integer.parseInt(bufferedReader.readLine().trim());

        List<Integer> grades = new ArrayList<>();

        for (int i = 0; i < gradesCount; i++) {
            int gradesItem = Integer.parseInt(bufferedReader.readLine().trim());
            grades.add(gradesItem);
        }

        List<Integer> result = GradingStudentsResult.gradingStudents(grades);

        for (int i = 0; i < result.size(); i++) {
            bufferedWriter.write(String.valueOf(result.get(i)));

            if (i != result.size() - 1) {
                bufferedWriter.write("\n");
            }
        }

        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }
}
