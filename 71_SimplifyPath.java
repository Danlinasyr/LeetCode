class Solution {
    public String simplifyPath(String path) {
        // no corner case to handle since 1 <= path.length <= 3000 and vaild path
        
        Stack<String> stack = new Stack<>();
        // Split the input string on "/" as the delimiter
        String[] s = path.split("/");
        
        for (String dir : s) {
            
            if (dir.isEmpty() || dir.equals(".")) {
                continue;
            } else if (dir.equals("..")) {
                // if it is a "..", which mean up a level == pop last directory
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.add(dir);
            }
        }
        
        StringBuilder sb = new StringBuilder();
        for (String dir : stack) {
            sb.append("/");
            sb.append(dir);
        }
        
        return sb.length() > 0 ? sb.toString() : "/";
    }
}