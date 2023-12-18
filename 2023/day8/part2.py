from math import lcm

input_string = open('input.txt').read()
use_string = input_string.split('\n')

directions = use_string[0]
instructions = sorted(use_string[2:])
ends_a = []
for i in instructions:
    if i[2] == 'A':
        ends_a.append(i)
print(ends_a)

where = 'AAA'
indices = [i for i, s in enumerate(instructions) if where == s[0:3]]
print(indices)

def update_where(direction):
    global where
    if direction == 'L':
        where_index = [i for i, s in enumerate(instructions) if where == s[0:3]]
        new_where = instructions[where_index[0]][7:10]
        where = new_where
    if direction == 'R':
        where_index = [i for i, s in enumerate(instructions) if where == s[0:3]]
        new_where = instructions[where_index[0]][12:15]
        where = new_where
steps = []
direction_index = 0
print(len(directions))
for i in ends_a:
    step = 0
    where = i[0:3]
    while where[2] != 'Z':
        update_where(directions[direction_index])
        #print(f'direction_index: {direction_index}')
        #print(f'direction: {directions[direction_index]}')
        #print(f'where: {where}')
        if direction_index == len(directions)-1:
            direction_index = 0
        else:
            direction_index += 1
        step += 1
    steps.append(step)
    print(f'steps: {steps}')
print(lcm(steps[0],steps[1],steps[2],steps[3],steps[4],steps[5]))


