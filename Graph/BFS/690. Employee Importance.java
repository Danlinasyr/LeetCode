/*
// Definition for Employee.
class Employee {
    public int id;
    public int importance;
    public List<Integer> subordinates;
};
*/

class Solution {
    public int getImportance(List<Employee> employees, int id) {
        Map<Integer, Employee> idMap = new HashMap<>();
        for(Employee e : employees) {
            idMap.put(e.id, e);   
        }
        Queue<Employee> queue = new ArrayDeque<>();
        queue.offer(idMap.get(id));
        int total = idMap.get(id).importance;
        while (!queue.isEmpty()) {
            Employee curr = queue.poll();
            for (int e_id : curr.subordinates) {
                Employee e = idMap.get(e_id);
                queue.offer(e);
                total += e.importance;
            }
        }
        return total;
    }
}