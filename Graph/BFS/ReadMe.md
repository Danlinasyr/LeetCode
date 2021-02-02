# BFS Search: 

## Pointers:
- usually it's asking for minimum steps or shortest path
- there is a source and a target
- it would said return -1 if not possible
- If the given map is matrix, the dimension of matrix is within m * n (what is the m and n range?)

## Djikstra vs Pure BFS
- if BFS is in place to Djikstra (Best example so far is The Maze III, try to solve it using both Djikstra and Pure BFS)
	- Does NOT need to poll elements of current queue (sz = queue.size(); while(sz)). Take care of level by keep subprobelm result and optimized result with a dp array.
	- There should be some form of dp arrays to keep track of updates
	- There must be some conditions/onstraints that governing the enqueue and stoping the enqueue at some points so that while loop could stop
	- Does Djikstra still need a seen/visited?
