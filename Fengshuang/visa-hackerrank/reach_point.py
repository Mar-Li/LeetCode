def canReach(x1, y1, x2, y2):
    queue = []
    queue.append((x1, y1))
    while queue:
        x, y = queue.pop()
        if x == x2 and y == y2:
            return 'Yes'
        if x == x2 and x + y <= y2:
            queue.append((x, x + y))
        elif y == y2 and x + y <= x2:
            queue.append((x + y, y))
        elif x + y <= x2 and x + y <= y2:
            if x < x2:
                queue.append((x + y, y))
            if y < y2:
                queue.append((x, x + y))
    return 'No'
    

print(canReach(1,4,6624,1239))
print(canReach(1,4,5,9))
print(canReach(1,2,2,1))