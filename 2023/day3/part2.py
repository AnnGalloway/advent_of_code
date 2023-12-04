input_string = open('input.txt').read()
use_string = input_string.split('\n')

symbol_locations = []

i = 1
for r in use_string:
    j = 1
    for c in r:
        if c == '*':
            symbol_locations.append([i,j])
        j+=1
    i+=1

#print(symbol_locations)

number_start_locations = []

i = 1
for r in use_string:
    j = 1
    for c in r:
        #print(f'{i},{j}:{c}')
        #if 3 digits long
        if r[j-1:j+2].isnumeric() and j <= len(r)-2:
            number_start_locations.append([[i,j],[r[j-1:j+2]]])
        #if 2 digits at beginning of row
        elif r[j-1:j+1].isnumeric() and j == 1 and not r[j+1].isnumeric():
            number_start_locations.append([[i,j],[r[j-1:j+1]]])
        #if 2 digits long at end of row
        elif r[j-1:j+1].isnumeric() and (not r[j-2].isnumeric()) and j+1 == len(r):
            number_start_locations.append([[i,j],[r[j-1:j+1]]])
        #if 2 digits long elsewhere
        elif r[j-1:j+1].isnumeric() and j < len(r) -1 and not r[j-2].isnumeric() and not r[j+1].isnumeric():
            number_start_locations.append([[i,j],[r[j-1:j+1]]])
        #if 1 digit long at start of row
        elif r[j-1].isnumeric() and j == 1 and not r[j].isnumeric():
            number_start_locations.append([[i,j],[r[j-1]]])
        #if 1 digit long at end of row
        elif r[j-1].isnumeric() and (not r[j-2].isnumeric()) and j == len(r):
            number_start_locations.append([[i,j],[r[j-1]]])
        #if 1 digit long elsewhere
        elif r[j-1].isnumeric() and (not r[j-2].isnumeric() or j == 1) and not r[j].isnumeric():
            number_start_locations.append([[i,j],[r[j-1]]])
        j += 1
    i += 1
        

# - change them to have if j = len(r) then else

print(number_start_locations)
print(len(number_start_locations))

counted_numbers = []

for n in number_start_locations:
    for s in symbol_locations:
        if len(n[1][0]) == 3:
            #if row matches row
            if s[0] == n[0][0]:
                #if column matches column before or after
                if s[1] == n[0][1]-1 or s[1] == n[0][1]+3:
                    counted_numbers.append([s,n])
            #if row is row below or row above
            elif s[0] == n[0][0]-1 or s[0] == n[0][0]+1:
                #if column matches column before or column 1 or column 2 or column 3 or column after
                if s[1] == n[0][1]-1 or s[1] == n[0][1] or s[1] == n[0][1]+1 or s[1] == n[0][1]+2 or s[1] == n[0][1]+3:
                    counted_numbers.append([s,n])
        elif len(n[1][0]) == 2:
            if s[0] == n[0][0]:
                if s[1] == n[0][1]-1 or s[1] == n[0][1]+2:
                    counted_numbers.append([s,n])
            elif s[0] == n[0][0]-1 or s[0] == n[0][0]+1:
                if s[1] == n[0][1]-1 or s[1] == n[0][1] or s[1] == n[0][1]+1 or s[1] == n[0][1]+2:
                    counted_numbers.append([s,n])
        else:
            if s[0] == n[0][0]:
                if s[1] == n[0][1]-1 or s[1] == n[0][1]+1:
                    counted_numbers.append([s,n])
            elif s[0] == n[0][0]-1 or s[0] == n[0][0]+1:
                if s[1] == n[0][1]-1 or s[1] == n[0][1] or s[1] == n[0][1]+1:
                    counted_numbers.append([s,n])


print(counted_numbers)
print(len(counted_numbers))

remove_dupes = []
for n in counted_numbers:
    if n not in remove_dupes:
        remove_dupes.append(n)

locations = []
for l in remove_dupes:
    locations.append(l[0])
print(locations)

index_singles = []
i = 0
for l in locations:
    if locations.count(l) == 1:
        index_singles.append(i)
    i+= 1
print(index_singles)
reverse = index_singles[::-1]
print(reverse)
for i in reverse:
    remove_dupes.pop(i)
remove_dupes = sorted(remove_dupes)
print(remove_dupes)
print(int(remove_dupes[0][1][1][0])*int(remove_dupes[1][1][1][0]))

sum = 0
i = 0
while i < len(remove_dupes):
    sum += int(remove_dupes[i][1][1][0])*int(remove_dupes[i+1][1][1][0])
    i += 2
print(sum)