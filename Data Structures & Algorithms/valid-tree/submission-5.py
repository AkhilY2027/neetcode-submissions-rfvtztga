class Solution:


    def validTree(self, n: int, edges: List[List[int]]) -> bool:
        if len(edges) > (n - 1):
            return False
        # Two conditions:
            # Everything is connected
            # No circles
        
        # First, check if everything is connected
        Graph = [[] for x in range(n)]
        for edge in edges:
            Graph[edge[0]].append(edge[1])
            Graph[edge[1]].append(edge[0])

        # Construct a graph using bfs

        visited = set()
        def recur(node, previous):
            if node in visited:
                return False
            
            visited.add(node)
            for neighbor in Graph[node]:
                if neighbor != previous and not recur(neighbor, node):
                    return False
            
            return True
        
        return recur(0, -1) and len(visited) == n
        