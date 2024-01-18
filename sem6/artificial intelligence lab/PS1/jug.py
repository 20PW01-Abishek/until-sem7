import heapq

def h(state):
    return abs(2 - state[0]) + abs(2 - state[1])

def possible_actions(state):
    x, y = state
    actions = [(x, 0), (0, y), (4, y), (x, 3), (min(x + y, 4), max(0, x + y - 4)), (max(0, y + x - 3), min(3, x + y))]
    return actions

def astar(start, goal):
    heap = [(h(start), 0, start, [])]
    visited = set()
    while heap:
        (f, g, state, path) = heapq.heappop(heap)
        if state == goal:
            return (g, path + [state])
        if state in visited:
            continue
        visited.add(state)
        for action in possible_actions(state):
            heapq.heappush(heap, (g + h(action) + 1, g + 1, action, path + [state]))

start = (0, 0)
goal = (0, 2)
(cost, path) = astar(start, goal)
print("Cost:", cost)
print("Path:", path)
