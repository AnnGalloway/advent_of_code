input_string = open('input.txt').read()
use_string = input_string.split('\n')

directions = use_string[0]
instructions = sorted(use_string[2:])

where = 'BFA'
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

steps = 0
direction_index = 0
print(len(directions))
while where != 'ZZZ':
    update_where(directions[direction_index])
    #print(f'direction_index: {direction_index}')
    #print(f'direction: {directions[direction_index]}')
    #ßprint(f'where: {where}')
    if direction_index == len(directions)-1:
        direction_index = 0
    else:
        direction_index += 1
    steps += 1
print(f'steps: {steps}')