input_string = open('input.txt').read()
use_string = input_string.split('\n')

example1 = 'Card 1: 41 48 83 86 17 | 83 86  6 31 17  9 48 53'
split_example = example1.split('|')


split_example[0] = split_example[0].split(':')
split_example[0][1] = split_example[0][1].split()
split_example[1] = split_example[1].split()

#value of winning card is 2**(matched numbers -1)

number_of_cards = len(use_string)

def find_card_value(line):
    global card_value
    line_split = line.split('|')
    line_split[0] = line_split[0].split(':')
    line_split[0][1] = line_split[0][1].split()
    line_split[1] = line_split[1].split()
    #print(line)
    matched_numbers = 0
    for n in line_split[1]:
        if n.isnumeric() and n in line_split[0][1]:
            matched_numbers += 1
    print(use_string.index(line))
    if matched_numbers != 0:
        while matched_numbers >= 1:
            if matched_numbers+use_string.index(line) < len(use_string):
                use_string.append(use_string[matched_numbers+use_string.index(line)])
            matched_numbers -= 1
    

for s in use_string:
    find_card_value(s)

#find_card_value(example1)

number_of_cards2 = len(use_string)

print(use_string)
print(number_of_cards)
print(number_of_cards2)
