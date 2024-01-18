from queue import PriorityQueue

def is_valid(state):
    # Check if the state is valid (i.e., cannibals never outnumber missionaries on either bank)
    miss_left, can_left, boat, miss_right, can_right = state
    if miss_left < can_left and miss_left > 0:
        return False
    if miss_right < can_right and miss_right > 0:
        return False
    return True

def astar(start, end):
    # A* algorithm to find the shortest path from start state to end state
    queue = PriorityQueue()
    queue.put((0, 0, start))
    visited = set()

    while not queue.empty():
        g, f, state = queue.get()
        if state == end:
            return f

        if state in visited:
            continue
        
        print(state)
        visited.add(state)

        miss_left, can_left, boat, miss_right, can_right = state

        if boat == 'left':
            # Move two missionaries to the right bank
            if miss_left >= 2:
                new_state = (miss_left - 2, can_left, 'right', miss_right + 2, can_right)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move two cannibals to the right bank
            if can_left >= 2:
                new_state = (miss_left, can_left - 2, 'right', miss_right, can_right + 2)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one missionary and one cannibal to the right bank
            if miss_left >= 1 and can_left >= 1:
                new_state = (miss_left - 1, can_left - 1, 'right', miss_right + 1, can_right + 1)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one missionary to the right bank
            if miss_left >= 1:
                new_state = (miss_left - 1, can_left, 'right', miss_right + 1, can_right)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one cannibal to the right bank
            if can_left >= 1:
                new_state = (miss_left, can_left - 1, 'right', miss_right, can_right + 1)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))
        else:
            # Move two missionaries to the left bank
            if miss_right >= 2:
                new_state = (miss_left + 2, can_left, 'left', miss_right - 2, can_right)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move two cannibals to the left bank
            if can_right >= 2:
                new_state = (miss_left, can_left + 2, 'left', miss_right, can_right - 2)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one missionary and one cannibal to the left bank
            if miss_right >= 1 and can_right >= 1:
                new_state = (miss_left + 1, can_left + 1, 'left', miss_right - 1, can_right - 1)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one missionary to the left bank
            if miss_right >= 1:
                new_state = (miss_left + 1, can_left, 'left', miss_right - 1, can_right)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

            # Move one cannibal to the left bank
            if can_right >= 1:
                new_state = (miss_left, can_left + 1, 'left', miss_right, can_right - 1)
                if is_valid(new_state):
                    queue.put((g + 1, g + 1 + heuristic(new_state, end), new_state))

def heuristic(state, end):
    # Heuristic function to estimate the cost from state to end
    miss_left, can_left, boat, miss_right, can_right = state
    miss_end, can_end, _, _, _ = end
    return abs(miss_left - miss_end) + abs(can_left - can_end)

# Initial state: three missionaries and three cannibals on the left bank, boat on the left bank
start = (3, 3, 'left', 0, 0)

# End state: three missionaries and three cannibals on the right bank, boat on the right bank
end = (0, 0, 'right', 3, 3)
print(astar(start, end))
