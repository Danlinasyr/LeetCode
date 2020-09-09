/**
 * // This is the robot's control interface.
 * // You should not implement it, or speculate about its implementation
 * interface Robot {
 *     // Returns true if the cell in front is open and robot moves into the cell.
 *     // Returns false if the cell in front is blocked and robot stays in the current cell.
 *     public boolean move();
 *
 *     // Robot will stay in the same cell after calling turnLeft/turnRight.
 *     // Each turn will be 90 degrees.
 *     public void turnLeft();
 *     public void turnRight();
 *
 *     // Clean the current cell.
 *     public void clean();
 * }
 */

/*
    Initial input: robot is facing north
    Progress input: true/false of the moving
    Output: all the room accessible cell has been visted and cleaned 
    How to terminate: when all the acessiable cell has been cleaned  => no acessiable cell from any cell
*/

class Solution {
    //build a grid orgin from the starting position of the robot to keep track the visited cell in the room
    private Set<Pair<Integer, Integer>> visited;

    //moving direction of the robot (effect on the current pos)
    private int[][] d = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};

    /*
        input: current visiting cell pos (i, j); robot
        
        base: ???
        update: visited cell 
    */
    private void backTrack(int i, int j, int d, Robot robot){
        visited.add(new Pair(i, j));
        robot.clean();

        for()

    }


    public void cleanRoom(Robot robot) {
        visited = new HashSet<>();
        backTrack
    }
}




















































// Stack Overflow Solution
// class Solution {
//     public void cleanRoom(Robot robot) {
        
//         if(!robot.move()){
//             robot.turnLeft();
//             if(!robot.move()){
//                 robot.turnLeft();
//                 if(!robot.move()){
//                     robot.turnLeft();
//                     if(!robot.move()){
//                         return;
//                     }
//                 }
//             }
//         }
        
//         //Try forward direction move
//         if(robot.move()){
//             robot.clean();
//             //next move
//             cleanRoom(robot);
//             //unmove
//             robot.turnLeft();
//             robot.turnLeft();
//             robot.move();
//             //back starting direction
//             robot.turnLeft();
//             robot.turnLeft();
//         }
        
//         //Try move to the Left
//         robot.turnLeft();
//         if(robot.move()){
//             robot.clean();
//             cleanRoom(robot);
//             //unmove
//             robot.turnLeft();
//             robot.turnLeft();
//             robot.move();
//             //back starting direction
//             robot.turnLeft();
//             robot.turnLeft();
//         }
//         // turn back to orginal facing direction
//         robot.turnRight();
        
//         //Try move to the Right
//         robot.turnRight();
//         if(robot.move()){
//             robot.clean();
//             cleanRoom(robot);
//             //unmove
//             robot.turnLeft();
//             robot.turnLeft();
//             robot.move();
//             //back starting direction
//             robot.turnLeft();
//             robot.turnLeft();
//         }
//         // turn back to orginal facing direction
//         robot.turnLeft();
        
//         //Try move backward
//         robot.turnLeft();
//         robot.turnLeft();
//         if(robot.move()){
//             robot.clean();
//             cleanRoom(robot);
//             //unmove
//             robot.turnLeft();
//             robot.turnLeft();
//             robot.move();
//             robot.turnLeft();
//             robot.turnLeft();
//         }
//         robot.turnLeft();
//         robot.turnLeft();
        
//         return;
        
//     }
// }

/*

room = [
  [1,1,1,1,1,0,1,1],
  [1,1,1,1,1,0,1,1],
  [1,0,1,1,1,1,1,1],
  [0,0,0,1,0,0,0,0],
  [1,1,1,1,1,1,1,1]
],
row = 1,
col = 3


movement[turnLeft, turnRight, forward]

*/