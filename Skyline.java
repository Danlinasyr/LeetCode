class Solution {
    /*
    if Ri-1 > Ri     no add
    if Hi-1 > Hi.    add[Ri-1, Hi]   else: add[Li, Hi]
    
    if Ri-1 < Li.    add[(Ri-1, 0)]
    if i == buildings.length - 1;  add[(Ri, 0)]
    
    [ [2 9 10], [3 7 15], [5 12 12], [11,15,11] [15 20 10], [19 24 8] ]
    [2,10],[3,15],[5,12],[12,0],[15,10],[19,8],[24,0]
    [2 10], [3 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ]
    */
    
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<List<Integer>> res = new ArrayList<>();
        if (buildings == null || buildings.length == 0) {
            return res;
        }
        
        int prevL = buildings[0][0]; 
        int prevR = buildings[0][1];
        int prevH = buildings[0][2];
        
        for (int[] building : buildings) {
            if (prevL < building[0]) {
                res.add(new ArrayList(new int[] {prevR, 0}));
            }
            if (prevH <= building[2]) {
                prevL = building[0];
                prevH = building[2];
            }    

        }
        // last right corner
        res.add(new ArrayList(new int[] {prevR, 0}));
        
        return res;
    }
}