input_string = open('input.txt').read()
use_string = input_string.split('\n')

order = {'A':1,'K':2,'Q':3,'J':4,'T':5,'9':6,'8':7,'7':8,'6':9,'5':10,'4':11,'3':12,'2':13,'1':14}
example_hand = '32T3K'
five_kind = []
four_kind = []
full_house = []
three_kind = []
two_pair = []
one_pair = []
high_card = []

def hand_type(hand_score):
    hand = hand_score.split()[0]
    hand_dict = {}
    for c in hand:
        hand_dict.update({c:hand.count(c)})
    values = list(hand_dict.values())
    if len(hand_dict) == 1:
        five_kind.append([hand,hand_score.split()[1]])
    elif 4 in values:
        four_kind.append([hand,hand_score.split()[1]])
    elif 3 in values and 2 in values:
        full_house.append([hand,hand_score.split()[1]])
    elif 3 in values:
        three_kind.append([hand,hand_score.split()[1]])
    elif values.count(2) == 2:
        two_pair.append([hand,hand_score.split()[1]])
    elif 2 in values:
        one_pair.append([hand,hand_score.split()[1]])
    else:
        high_card.append([hand,hand_score.split()[1]])
    

for i in use_string:
    hand_type(i)

def find_value(hand_list):
    for i in hand_list:
        value = []
        for c in i[0]:
            value.append(order[c])
        i.append(value)
    hand_list.sort(key = lambda x: x[2])

find_value(five_kind)
find_value(four_kind)
find_value(full_house)
find_value(three_kind)
find_value(two_pair)
find_value(one_pair)
find_value(high_card)

value_list = []
def add_to_list(hand_list):
    for i in hand_list:
        value_list.append([i[0],i[1]])

add_to_list(five_kind)
add_to_list(four_kind)
add_to_list(full_house)
add_to_list(three_kind)
add_to_list(two_pair)
add_to_list(one_pair)
add_to_list(high_card)

value_list = value_list[::-1]
print(value_list)

total = 0
for i in value_list:
    total += int(i[1]) * (value_list.index(i)+1)
print(total)
