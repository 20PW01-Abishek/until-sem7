import networkx as nx
from matplotlib import pyplot as plt
graph = {
    'A' : ['B','C'],
    'B' : ['D', 'E'],
    'C' : ['F'],
    'D' : [],
    'E' : ['F'],
    'F' : []
}

DFS=[]
visited = set()
def dfs(visited, graph, node):
    if node not in visited:
        DFS.append(node)
        visited.add(node)
        for neighbour in graph[node]:
            dfs(visited, graph, neighbour)
    
edges=[]        
for i in graph:
    for j in graph[i]:
        edges.append([i,j])

dfs(visited, graph, 'A')
G=nx.Graph()
G.add_edges_from(edges)
nx.draw_networkx(G)
plt.show()
print(DFS)
print(list(nx.dfs_edges(graph,'A')))