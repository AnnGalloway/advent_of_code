example_race = [[7,9],[15,40], [30,200]]
input_race = [[47,400],[98,1213],[66,1011],[98,1540]]
actual_race = [47986698,400121310111540]

race = actual_race
example1 = [7,9]
races = []

def how_far(input):
    time = input[0]
    distance = input[1]
    winning = []
    hold = 1
    print(time)
    print(distance)
    while hold < time:
        new_distance = (time-hold)*hold
        print(new_distance)
        if new_distance > distance:
            winning.append(new_distance)
        hold += 1
    races.append(len(winning))

how_far(actual_race)
print(races)

'''for r in race:
    how_far(r)
print(races)

m = 1
for r in races:
    m *= r
print(m)'''