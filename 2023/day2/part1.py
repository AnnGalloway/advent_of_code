input_string = open('input.txt').read()

max_red = 12
max_green = 13
max_blue = 14

games = []
games_total = 0

Game1 = 'Game 1: 3 blue, 4 red; 1 red, 2 green, 6 blue; 2 green'
Game2 = 'Game 2: 1 blue, 2 green; 3 green, 4 blue, 1 red; 1 green, 1 blue'
Game3 = 'Game 3: 8 green, 6 blue, 20 red; 5 blue, 4 red, 13 green; 5 green, 1 red'
Game4 = 'Game 4: 1 green, 3 red, 6 blue; 3 green, 6 red; 3 green, 15 blue, 14 red'
Game5 = 'Game 5: 6 red, 1 blue, 3 green; 2 blue, 1 red, 2 green'

def add_to_dict(line):
    global games_total
    game = int(line.split()[1].replace(':',''))
    line = line.replace(';',',').replace(':',',')
    list_line = line.split(',')
    blue = []
    green = []
    red = []
    for c in list_line:
        if 'blue' in c:
            blue.append(int(c.split()[0]))
        elif 'green' in c:
            green.append(int(c.split()[0]))
        elif 'red' in c:
            red.append(int(c.split()[0]))
    '''print(f'blue:{blue}')
    print(max(blue))
    print(f'red:{red}')
    print(max(red))
    print(f'green:{green}')
    print(max(green))'''
    if max(blue) <= max_blue and max(green) <= max_green and max(red) <= max_red:
        games.append({'game':game, 'blue':max(blue), 'green':max(green), 'red':max(red)})
        games_total += game


for s in input_string.split('\n'):
    add_to_dict(s)
print(games)
print(games_total)