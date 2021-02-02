class Solution {
    class Video implements Comparable<Video> {
        String name;
        int views;
        public Video(String n, int v) {
            name = n;
            views = v;
        }
        
        @Override
        public int compareTo(Video other) {
            if (this.views != other.views) {
                return this.views - other.views;
            } else {
                return this.name.compareTo(other.name);
            }
        }
    }
    public List<String> watchedVideosByFriends(List<List<String>> watchedVideos, int[][] friends, int id, int level) {
        int n = friends.length;
        Queue<Integer> queue = new ArrayDeque<>();
        queue.offer(id);
        int[] seen = new int[n];
        seen[id] = 1;
        Map<String, Integer> counts = new HashMap<>();
        
        
        while (!queue.isEmpty() && level > 0) {
            
            int sz = queue.size();
                for (int i = 0; i < sz; i++) {
                int person = queue.poll();

                for (int f : friends[person]) {
                    if (seen[f] == 1) {
                        continue;
                    }
                    queue.offer(f);
                    seen[f] = 1;
                    if (level != 1) {
                        continue;
                    }
                    for (String v : watchedVideos.get(f)) {
                        counts.put(v, counts.getOrDefault(v, 0) + 1);
                    }
                }                
            }

            level--;
        }
        
        PriorityQueue<Video> pq = new PriorityQueue<>();
        for (String name : counts.keySet()) {
            pq.offer(new Video(name, counts.get(name)));
        }
        List<String> res = new ArrayList<>();
        while (!pq.isEmpty()) {
            Video video = pq.poll();
            res.add(video.name);
        }
        return res;
        
    }
}


    
//              You (id = 1)  -> {2, 3, 4} 
//                                |  |  |
//                             {1,5} {X} {Y}    

//             to sort video based on their frequency (max heap)
            
//             friend[0] -> (1, 2)
//                         C,   B,   C
//             Arrays.sort(video,counts)
//             N = 100 * 8 * 100 * 100
//             NlongN