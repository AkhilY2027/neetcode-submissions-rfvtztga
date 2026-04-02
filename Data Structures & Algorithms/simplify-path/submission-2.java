class Solution {
    public String simplifyPath(String path) {
        // Is this a graph problem?
            // Close, use stacks to pop out unnecessary elements

        // Unnecessary elements:
            // '.' is just current directory so can ignore
            // '..' is previous directory so pop out element on top of stack
                // Unless there are no elements, then ignore (parent of root directory is root)
            // Multiple /s can be reduced down to one
        // Every other element is a filename

        String[] files = path.split("/");
        System.out.println(Arrays.toString(files));
        Stack<String> fileStack = new Stack<>();
        for (String file : files) {
            if (file.isEmpty())
                continue; // Either between two /s or is before the first slash
            else if (file.equals("."))
                continue; // Can ignore since we're just in the original directory
            else if (file.equals("..")) {
                if (!fileStack.isEmpty())
                    fileStack.pop();
            }
            else
                fileStack.add(file);
        }

        // Now, we have all files in reverse order – Need to place into a string
        // StringBuilder sol = new StringBuilder();
        // while (!fileStack.isEmpty()) {
        //     sol.insert(0, fileStack.pop());
        //     sol.insert(0, "/");
        // }
        // return sol.isEmpty() ? "/" : sol.toString();

        // Easier way to conjoin everything:
        return "/" + String.join("/", fileStack);
    }
}