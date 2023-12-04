input_string = open('input.txt').read()
use_string = input_string.split('\n')

example1 = 'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53'
split_example = example1.split('|')


split_example[0] = split_example[0].split(':')
split_example[0][1] = split_example[0][1].split()
split_example[1] = split_example[1].split()

#value of winning card is 2**(matched numbers -1)

card_value = 0
def find_card_value(line):
    global card_value
    line = line.split('|')
    line[0] = line[0].split(':')
    line[0][1] = line[0][1].split()
    line[1] = line[1].split()
    #print(line)
    matched_numbers = 0
    for n in line[1]:
        if n.isnumeric() and n in line[0][1]:
            matched_numbers += 1
    #print(matched_numbers)
    #print(2**(matched_numbers-1))
    if matched_numbers != 0:
        card_value += 2**(matched_numbers-1)

for s in use_string:
    find_card_value(s)
print(card_value)