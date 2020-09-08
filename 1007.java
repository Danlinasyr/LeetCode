class Solution {
    public int minDominoRotations(int[] A, int[] B) {
    
    /*
    A = [2 1 2 4 2 2]
    B = [5 2 6 2 3 2]
    
    
    case 1: A[i] = B[i]
        opt1: val_equalRow = A[i]/B[i]
        
    case 2: A[i] != B[i]    
        opt2: val_equalRow = A[i]
        opt3: val_equalRow = B[i]
        
    
    HashMap<val_equalRow, count> val_equalRows
    
    if( !val_equalRows.contains(A[i] && !val_equalRows.contains(B[i]) ){
        
        return -1;
    }
    
    else if (val_equalRows.contains (A[i]) && put(B[i], val_equalRows.get(B[i]+1)){
        put(A[i], val_equalRows.get(A[i]+1);
    }
    
    
    
    
    
    
    */
        

        // A -> Set
        Set<Integer> a = new HashSet<>();
        for(int num: A){
            a.add(num);
        }

        // B -> Set
        Set<Integer> b = new HashSet<>();
        for(int num: B){
            b.add(num);
        }
        
       
        int count1 = 0;
        int minCount1 = -1;
        for (int candidate: a){
            count1 = 0;
            for(int i = 0; i < A.length; i++){
                if(A[i] != candidate){
                    if(B[i] != candidate){
                        count1 = -1;
                        break;
                    }else{
                        count1++;
                    }
                }
            }
            
            
            if (minCount1 == -1 || (count1 < minCount1 && count1 >= 0)){
                minCount1 = count1;
            }
        }
        
        

        int count2 = 0;
        int minCount2 = -1;
        for (int candidate: b){
            count2 = 0;
            for(int i = 0; i < B.length; i++){
                if(B[i] != candidate){
                    if(A[i] != candidate){
                        count2 = -1;
                        break;
                    }else{
                        count2++;
                    }
                }
            }
            if (minCount2 == -1 || (count2 < minCount2 && count2 >= 0)){
                minCount2 = count2;
            }
        }
        

  
        if(minCount1 < minCount2){
            return minCount1;
        }else{
            return minCount2;
        }  
        
        
    }
}

// O(n^2)