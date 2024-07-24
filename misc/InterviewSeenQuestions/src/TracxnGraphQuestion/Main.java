

//
//    Given a Map of Organization Employee-Manager map,
//        Find the number of employees under every manager “in the hierarchy” and not just direct reportee.
//        Top person reports to himself. Do not count it.
//
//        Sample Input 1:
//        Employee -> Manager
//        {
//        "A": "C",
//        "B": "C",
//        "C": "F",
//        "D": "E",
//        "E": "F",
//        "F": "F"
//        }
//        Sample Output 1:
//        {
//        "A": 0,
//        "B": 0,
//        "C": 2,
//        "D": 0,
//        "E": 1,
//        "F": 5
//        }
//        Sample Input 2:
//        {
//        "A": "C",
//        "B": "C",
//        "C": "F",
//        "D": "E",
//        "E": "F",
//        "F": "G",
//        "G": "J",
//        "H": "J",
//        "J": "J"
//        }
//
//        Sample Output 2:
//
//        {
//        "A": 0,
//        "B": 0,
//        "C": 2,
//        "D": 0,
//        "E": 1,
//        "F": 5,
//        "G": 6,
//        "H": 0,
//        "J": 8
//        }
//
//
//        *********************



package TracxnGraphQuestion;

 import java.util.ArrayList;
 import java.util.HashMap;
 import java.util.List;
 import java.util.Map;

public class Main {
    private static int dfs(Map<Character, List<Character>> managerToEmployee, Map<Character, Integer> totalReports, Character manager) {
        int total = 0;

        if (managerToEmployee.containsKey(manager) ) {

            for (char reportee : managerToEmployee.get(manager)) {
                if (reportee == manager) continue;
                if (!totalReports.containsKey(managerToEmployee.get(manager))) {
                    total += dfs(managerToEmployee, totalReports, reportee);
                } else {
                    total += totalReports.get(reportee);
                }
            }
        }
        totalReports.put(manager, total);

        return total + 1;
    }

    private static Map<Character, Integer> calculateReportees(Map<Character, Character> relation) {
        Map<Character, List<Character>> managerToEmployee = new HashMap<>();

        for (Map.Entry<Character, Character> m: relation.entrySet()) {
            Character key = m.getKey();
            Character value = m.getValue();
            if (!managerToEmployee.containsKey(value)) managerToEmployee.put(value, new ArrayList<>());
            managerToEmployee.get(value).add(key);
        }


        Map<Character, Integer> totalReports = new HashMap<>();
        for (Map.Entry<Character, List<Character>> m: managerToEmployee.entrySet()) {
            if (!totalReports.containsKey(m.getKey())) {
                dfs(managerToEmployee, totalReports, m.getKey());
            }
        }

        return totalReports;
    }

    public static void main(String args[]) {
//        Map<Character, Character> relation = new HashMap() {{
//            put('A', 'C');
//            put('B', 'C');
//            put('C', 'F');
//            put('D', 'E');
//            put('E', 'F');
//            put('F', 'F');
//        }};

        Map<Character, Character> relation = new HashMap() {{
            put('A', 'C');
            put('B', 'C');
            put('C', 'F');
            put('D', 'E');
            put('E', 'F');
            put('F', 'G');
            put('G', 'J');
            put('H', 'J');
            put('J', 'J');
        }};

        Map<Character, Integer> totalReports = calculateReportees(relation);

        for (Map.Entry<Character, Integer> m: totalReports.entrySet()) {
            System.out.println(m.getKey() + " :- " + m.getValue());
        }
    }
}


